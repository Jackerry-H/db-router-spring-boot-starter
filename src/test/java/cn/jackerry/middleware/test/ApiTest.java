package cn.jackerry.middleware.test;

import cn.jackerry.middleware.db.router.annotation.DBRouter;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @fileName: ApiTest
 * @description:
 * @author: jackerry
 * @date: 2022/4/13 14:47
 */
public class ApiTest {


    @Test
    public void test_annotation() throws NoSuchMethodException{
        Class<IUserDao> iUserDaoClass = IUserDao.class;
        Method method = iUserDaoClass.getMethod("insertUser", String.class);

        DBRouter dbRouter = method.getAnnotation(DBRouter.class);

        System.out.println(dbRouter.key());
    }
}
