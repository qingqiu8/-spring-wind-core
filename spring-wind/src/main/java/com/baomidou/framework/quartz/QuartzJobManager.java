/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.baomidou.framework.quartz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

/**
 *  QUARTZ管理器
 * @author yyn_0210@sina.com
 * @history 2009-8-18 新建
 * @version V2.0
 */
@Service
public class QuartzJobManager {
    private final static String JOB_GROUP_NAME = "job_group";
    private final static String TRIGGER_GROUP_NAME = "trigger_group";
    private final Log log = LogFactory.getLog(this.getClass());

    /**
     * 注入调度工厂
     */
    @Autowired
    private SchedulerFactoryBean schedulerFactory;

    /**
     * 添加JOB
     *
     * @param jobName        JOB名称
     * @param jobClass       JOB类
     * @param cronExpression
     * @throws ParseException
     * @throws SchedulerException
     */
    public void addJob(String jobName, Class<? extends Job> jobClass, String cronExpression)
            throws ParseException, SchedulerException {

        JobBuilder jobBuilder = JobBuilder.newJob(jobClass);
        jobBuilder.withIdentity(jobName, JOB_GROUP_NAME);
        JobDetail jobDetail = jobBuilder.build();

        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(jobName, TRIGGER_GROUP_NAME);
        triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
        Trigger trigger = triggerBuilder.build();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        if (!scheduler.isShutdown())
            scheduler.start();
    }

    /**
     * 添加JOB
     *
     * @param jobName          JOB名称
     * @param jobGroupName     JOB组名称
     * @param triggerName      触发器名称
     * @param triggerGroupName 触发器组名称
     * @param jobClass         JOB类
     * @param cronExpression   时间规则表达式
     * @throws SchedulerException
     * @throws ParseException
     */
    public void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName,
                       Class<? extends Job> jobClass, String cronExpression)
            throws SchedulerException, ParseException {
        addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass,  cronExpression, null);
    }

    /**
     * 添加JOB
     *
     * @param jobName          JOB名称
     * @param jobGroupName     JOB组名称
     * @param triggerName      触发器名称
     * @param triggerGroupName 触发器组名称
     * @param jobClass         JOB类
     * @param cronExpression   时间规则表达式
     * @param dataMap          数据Map
     * @throws SchedulerException
     * @throws ParseException
     */
    public void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName,
                       Class<? extends Job> jobClass, String cronExpression, Map<String, Object> dataMap)
            throws SchedulerException, ParseException {
        Scheduler scheduler = schedulerFactory.getScheduler();

            JobBuilder jobBuilder = JobBuilder.newJob(jobClass);
            jobBuilder.withIdentity(jobName, jobGroupName);
            JobDetail jobDetail = jobBuilder.build();
            if (dataMap != null) {
                for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
                    jobDetail.getJobDataMap().put(entry.getKey(),  entry.getValue());
                }
            }

            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            triggerBuilder.withIdentity(triggerName, triggerGroupName);
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
            Trigger trigger = triggerBuilder.build();
            scheduler.scheduleJob(jobDetail, trigger);
            if (!scheduler.isShutdown()){
                scheduler.start();
            }
    }

    /**
     * 修改JOB触发时间
     *
     * @param jobName        JOB名称
     * @param cronExpression 时间表达式
     * @throws SchedulerException
     * @throws ParseException
     */
    public void modifyJobTime(String jobName, String cronExpression)
            throws SchedulerException, ParseException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        Trigger trigger = scheduler.getTrigger(TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME));
        if (trigger != null) {
            CronTriggerImpl ct = (CronTriggerImpl) trigger;
            ct.setCronExpression(cronExpression);
            scheduler.resumeTrigger(TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME));
        }
    }

    /**
     * 修改JOB触发时间
     *
     * @param triggerName      触发器名称
     * @param triggerGroupName 触发器粗面
     * @param cronExpression   时间表达式
     * @throws SchedulerException
     * @throws ParseException
     */
    public void modifyJobTime(String triggerName, String triggerGroupName,
                              String cronExpression) throws SchedulerException, ParseException {
        Scheduler scheduler = schedulerFactory.getScheduler();

        Trigger trigger = scheduler.getTrigger(TriggerKey.triggerKey(triggerName, triggerGroupName));
        if (trigger != null) {
            CronTriggerImpl ct = (CronTriggerImpl) trigger;
            // 修改时间
            ct.setCronExpression(cronExpression);
            // 重启触发器
            scheduler.rescheduleJob(TriggerKey.triggerKey(triggerName, triggerGroupName), ct);
        }
    }

    /**
     * 修改JOB触发时间
     *
     * @param triggerName      触发器名称
     * @param triggerGroupName 触发器组名
     * @param startTime        开始时间
     * @param endTime          结束时间
     * @throws SchedulerException
     */
    public void modifyJobTime(String triggerName, String triggerGroupName, Date startTime, Date endTime)
            throws SchedulerException {
        Trigger trigger = null;
        Scheduler scheduler = schedulerFactory.getScheduler();
        try {

            trigger = scheduler.getTrigger(TriggerKey.triggerKey(triggerName, triggerGroupName));
            // 停止触发器
            scheduler.pauseTrigger(TriggerKey.triggerKey(triggerName, triggerGroupName));

        } catch (SchedulerException e) {
            log.error(
                    "scheduler.getTrigger(triggerName, triggerGroupName) Exception: ",
                    e);
        }

        if (trigger != null) {
            CronTriggerImpl ct = (CronTriggerImpl) trigger;
            ct.setStartTime(startTime);
            ct.setEndTime(endTime);
            // 重启触发器
            try {
                scheduler.resumeTrigger(TriggerKey.triggerKey(triggerName, triggerGroupName));
                scheduler.rescheduleJob(TriggerKey.triggerKey(triggerName, triggerGroupName), ct);
            } catch (SchedulerException e) {
                log.error(
                        "scheduler.resumeTrigger(triggerName, triggerGroupName) Exception: ",
                        e);
                throw new SchedulerException();
            }
        }
    }

    /**
     * 移除JOB
     *
     * @param jobName JOB名称
     * @throws SchedulerException
     */
    public void removeJob(String jobName) throws SchedulerException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 停止触发器
        scheduler.pauseTrigger(TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME));
        // 移除触发器
        scheduler.unscheduleJob(TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME));
        // 删除任务
        scheduler.deleteJob(JobKey.jobKey(jobName, JOB_GROUP_NAME));
    }

    /**
     * 移除JOB
     *
     * @param jobName          JOB名称
     * @param jobGroupName     JOB组名
     * @param triggerName      触发器名称
     * @param triggerGroupName 触发器组名
     * @throws SchedulerException
     */
    public void removeJob(String jobName, String jobGroupName,
                          String triggerName, String triggerGroupName)
            throws SchedulerException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 停止触发器
        scheduler.pauseTrigger(TriggerKey.triggerKey(triggerName, triggerGroupName));
        // 移除触发器
        scheduler.unscheduleJob(TriggerKey.triggerKey(triggerName, triggerGroupName));
        // 删除任务
        scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));
    }


    /**
     * 判断是否已添加过该job
     *
     * @param jobName      任务名称
     * @param jobGroupName 任务组名称
     * @return true/false
     * @throws SchedulerException
     * @throws ParseException
     */
    public boolean isJobAdded(String jobName, String jobGroupName)
            throws SchedulerException, ParseException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail = scheduler.getJobDetail(JobKey.jobKey(jobName, jobGroupName));
        if (jobDetail != null) {
            return true;
        } else {
            return false;
        }
    }

}