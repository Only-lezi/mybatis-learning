package cn.blinkit.mybatis.dynamicSQL;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cn.blinkit.mybatis.po.UserCustom;
import cn.blinkit.mybatis.po.UserQueryVo;

/**
 * @Author: Only-lezi
 * @Date: 2017-01-06 18:49
 * @Description:
 */

public class UserMapper1Test {
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
    public void testFindUserList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建一个UserMapper对象,MyBatis自动生成mapper代理对象
        UserMapper1 userMapper1 = sqlSession.getMapper(UserMapper1.class);

        //创建包装对象，设置查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();

        //由于这里使用动态sql，如果不设置某个值，条件不会拼接在sql中
        userCustom.setSex("女");
        userCustom.setUsername("Only");
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        userQueryVo.setIds(ids);

        userQueryVo.setUserCustom(userCustom);
        //调用UserMapper的方法
        List<UserCustom> list = userMapper1.findUserList(userQueryVo);

        System.out.println(list);
    }
}
