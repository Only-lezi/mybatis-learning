package cn.blinkit.mybatis.dao.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;

import cn.blinkit.mybatis.dao.UserDao;
import cn.blinkit.mybatis.po.User;

/**
 * @Author: Only-lezi
 * @Date: 2017-01-04 14:06
 * @Description:
 */

public class UserDaoTest {

    private SqlSessionFactory sqlSessionFactory;

    /**
     * 创建sqlSessionFactory
     * 此方法是在执行testFindUserById之前执行
     */
    @Before
    public void setUp() throws Exception{

        //MyBatis配置文件
        String resource = "SqlMapConfig.xml";

        //得到配置文件流
        InputStream inputStream =  Resources.getResourceAsStream(resource);

        //创建会话工厂，传入MyBatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void testFindUserById() throws Exception {
        //创建UserDao的对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        //调用UserDao的方法
        User user = userDao.findUserById(1);

        System.out.println(user);
    }

    @Test
    public void testInsertUser() throws Exception {
        //创建UserDao的对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        User user = new User();
        user.setUsername("李晓明");
        user.setBirthday(new Date());
        user.setAddress("湖北省武汉市");
        user.setSex("男");
        //调用UserDao的方法
        userDao.insertUser(user);
    }

    @Test
    public void testDeleteUser() throws Exception {
        //创建UserDao的对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        //调用UserDao的方法
        userDao.deleteUser(16);
    }
}
