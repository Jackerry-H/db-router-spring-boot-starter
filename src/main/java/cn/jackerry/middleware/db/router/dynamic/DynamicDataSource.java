package cn.jackerry.middleware.db.router.dynamic;

import cn.jackerry.middleware.db.router.DBContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @fileName: DynamicDataSource
 * @description: 动态数据源获取
 * @author: jackerry
 * @date: 2022/4/14 14:28
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return "db" + DBContextHolder.getDBKey();
    }


}
