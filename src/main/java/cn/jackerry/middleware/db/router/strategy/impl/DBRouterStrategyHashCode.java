package cn.jackerry.middleware.db.router.strategy.impl;

import cn.jackerry.middleware.db.router.DBContextHolder;
import cn.jackerry.middleware.db.router.DBRouterConfig;
import cn.jackerry.middleware.db.router.strategy.IDBRouterStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @fileName: DBRouterStrategyHashCode
 * @description: 哈希路由
 * @author: jackerry
 * @date: 2022/4/14 13:12
 */
public class DBRouterStrategyHashCode implements IDBRouterStrategy {

    private static final Logger logger = LoggerFactory.getLogger(DBRouterStrategyHashCode.class);

    private final DBRouterConfig dbRouterConfig;

    public DBRouterStrategyHashCode(DBRouterConfig dbRouterConfig) {
        this.dbRouterConfig = dbRouterConfig;
    }

    /**
     * 路由计算
     *
     * @param dbKeyAttr 路由字段
     */
    @Override
    public void doRouter(String dbKeyAttr) {
        int size = dbRouterConfig.getDbCount() * dbRouterConfig.getTbCount();

        // 扰动函数
        int idx = (size - 1) * (dbKeyAttr.hashCode() ^ (dbKeyAttr.hashCode() >>> 16));

        // 库表索引
        int dbIdx = idx / dbRouterConfig.getTbCount() + 1;
        int tbIdx = idx - dbRouterConfig.getTbCount() * (dbIdx - 1);

        // 设置到 ThreadLocal
        DBContextHolder.setDBKey(String.format("%02d", dbIdx));
        DBContextHolder.setTBKey(String.format("%03d", tbIdx));
        logger.debug("数据库路由 dbIdx: {} tbIdx: {}", dbIdx, tbIdx);
    }

    /**
     * 手动设置分库路由
     *
     * @param dbIdx 路由库，需要在配置范围内
     */
    @Override
    public void setDBKey(int dbIdx) {
        DBContextHolder.setDBKey(String.format("%02d", dbIdx));
    }

    /**
     * 手动设置分表路由
     *
     * @param tbIdx 路由表，需要在配置范围内
     */
    @Override
    public void setTBKey(int tbIdx) {
        DBContextHolder.setTBKey(String.format("%03d", tbIdx));
    }

    /**
     * 获取分库数
     *
     * @return 数量
     */
    @Override
    public int dbCount() {
        return dbRouterConfig.getDbCount();
    }

    /**
     * 获取分表数
     *
     * @return 数量
     */
    @Override
    public int tbCount() {
        return dbRouterConfig.getTbCount();
    }

    /**
     * 清除路由
     */
    @Override
    public void clear() {
        DBContextHolder.clearDBKey();
        DBContextHolder.clearTBKey();
    }
}
