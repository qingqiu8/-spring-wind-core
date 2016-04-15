package com.baomidou.framework.poi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by creazier.huang on 16/4/15.
 */

@Target({ElementType.METHOD,ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelField {

    /**
     * 导出的字段名(默认调用当前字段)
     * @return
     */
    String value() default "";

    /**
     * 导出字段标题
     * @return
     */
    String title();

    /**
     * 字段类型(0:导入导出;1:导出;2:导入)
     * @return
     */
    int  type() default 0;

    /**
     * 导出字段对齐方式(0:自动;1:靠左;2:居左;3:靠右)
     * @return
     */
    int align() default 0;

    /**
     * 排序(升序)
     * @return
     */
    int sort() default 0;

    /**
     * 如果是字典类型青设置字典的type
     * @return
     */
    String dictType() default "";

    /**
     * 反射类型
     * @return
     */
    Class<?> fieldType() default Class.class;

    /**
     * 字段归属组
     * @return
     */
    int[] groups() default {};


}
