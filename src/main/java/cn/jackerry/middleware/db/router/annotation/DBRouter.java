package cn.jackerry.middleware.db.router.annotation;

import java.lang.annotation.*;

/**
 * @fileName: DBRouter
 * @description: 路由注解
 * @author: jackerry
 * @date: 2022/4/13 14:42
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface DBRouter {

    /**
     * 分库分表字段
     * @return
     */
    String key() default "";

}
