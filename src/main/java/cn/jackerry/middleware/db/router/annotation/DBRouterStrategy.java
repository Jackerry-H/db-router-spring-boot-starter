package cn.jackerry.middleware.db.router.annotation;

import java.lang.annotation.*;

/**
 * @fileName: DBRouterStrategy
 * @description: 路由策略，分表标记
 * @author: jackerry
 * @date: 2022/4/14 11:32
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DBRouterStrategy {

    /**
     * 分表标记
     *
     * @return
     */
    boolean splitTable() default false;

}
