package com.baomidou.framework.quartz;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public abstract class QuartzJobSupport extends QuartzJobBean {


	static Log log = LogFactory.getLog(QuartzJobSupport.class);

    private ApplicationContext applicationContext;
    /**
     * 从SchedulerFactoryBean注入的applicationContext.
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public <T> T getBean(String beanName, Class<T> clazz) {
        return this.applicationContext.getBean(beanName, clazz);
    }

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
    	innerIter(context);
    }

    public abstract void innerIter(JobExecutionContext context);

}
