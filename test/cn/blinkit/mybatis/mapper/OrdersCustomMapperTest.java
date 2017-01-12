package cn.blinkit.mybatis.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import cn.blinkit.mybatis.po.Orders;
import cn.blinkit.mybatis.po.OrdersCustom;

/**
 * @Author: Only-lezi
 * @Date: 2017-01-08 13:05
 * @Description:
 */

public class OrdersCustomMapperTest {
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
    public void testFindOrdersUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建代理对象
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);

        //调用Mapper的方法
        List<OrdersCustom> list = ordersCustomMapper.findOrdersUser();

        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void testFindOrdersUserResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建代理对象
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);

        //调用Mapper的方法
        List<Orders> list = ordersCustomMapper.findOrdersUserResultMap();

        System.out.println(list);

        sqlSession.close();
    }
}
