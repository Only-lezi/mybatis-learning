package cn.blinkit.ssm.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.blinkit.ssm.po.User;

/**
 * @author: Only-lezi
 * @date: 2017-01-15 23:12
 * @description:
 */

public class UserMapperTest {

    private ApplicationContext context;

    //在setUp这个方法得到spring容器
    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }
}
