package cn.jackerry.middleware.test;

import cn.jackerry.middleware.db.router.annotation.DBRouter;

/**
 * @fileName: IUserDao
 * @description: 测试UserDao
 * @author: jackerry
 * @date: 2022/4/13 14:45
 */
public interface IUserDao {

    @DBRouter(key = "userId")
    void insertUser(String req);

}
