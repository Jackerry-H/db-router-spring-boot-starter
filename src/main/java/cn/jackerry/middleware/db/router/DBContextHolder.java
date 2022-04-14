package cn.jackerry.middleware.db.router;

/**
 * @fileName: DBContextHolder
 * @description: 数据源上下文
 * @author: jackerry
 * @date: 2022/4/14 12:57
 */
public class DBContextHolder {

    private static final ThreadLocal<String> dbKey = new ThreadLocal<>();
    private static final ThreadLocal<String> tbKey = new ThreadLocal<>();

    public static String getDBKey() {
        return dbKey.get();
    }

    public static void setDBKey(String dbKeyIdx) {
        dbKey.set(dbKeyIdx);
    }

    public static String getTBKey() {
        return tbKey.get();
    }

    public static void setTBKey(String tbKeyIdx) {
        tbKey.set(tbKeyIdx);
    }

    public static void clearDBKey() {
        dbKey.remove();
    }

    public static void clearTBKey() {
        tbKey.remove();
    }

}
