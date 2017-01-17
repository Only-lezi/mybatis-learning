package cn.blinkit.ssm.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.blinkit.ssm.dao.UserDao;
import cn.blinkit.ssm.po.User;

/**
 * @author: Only-lezi
 * @date: 2017-01-15 22:52
 * @description:
 */

public class UserDaoImplTest {

    private ApplicationContext context;

    //在setUp这个方法得到spring容器
    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {
        UserDao userDao = (UserDao) context.getBean("userDao");
        User user = userDao.findUserById(1);
        System.out.println(user);
    }
}
