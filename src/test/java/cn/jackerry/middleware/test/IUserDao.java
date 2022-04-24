package cn.jackerry.middleware.test;

import cn.jackerry.middleware.db.router.annotation.DBRouter;
import org.apache.ibatis.annotations.Mapper;

/**
 * @fileName: IUserDao
 * @description: 测试UserDao
 * @author: jackerry
 * @date: 2022/4/13 14:45
 */
@Mapper
public interface IUserDao {

    @DBRouter(key = "userId")
    void insertUser(String req);

}
