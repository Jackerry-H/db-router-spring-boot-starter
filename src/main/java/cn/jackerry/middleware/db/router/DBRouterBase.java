package cn.jackerry.middleware.db.router;

/**
 * @fileName: DBRouterBase
 * @description: 数据源基础配置
 * @author: jackerry
 * @date: 2022/4/14 13:02
 */
public class DBRouterBase {

    private String tbIdx;

    public String getTbIdx() {
        return DBContextHolder.getTBKey();
    }

}
