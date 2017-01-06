package cn.blinkit.mybatis.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import cn.blinkit.mybatis.po.User;
import cn.blinkit.mybatis.po.UserCustom;
import cn.blinkit.mybatis.po.UserQueryVo;

/**
 * @Author: Only-lezi
 * @Date: 2017-01-04 15:29
 * @Description:
 */

public class UserMapperTest {

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

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建一个UserMapper对象,MyBatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用UserMapper的方法
        User user = userMapper.findUserById(1);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testFindUserByName() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建一个UserMapper对象,MyBatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用UserMapper的方法
        List<User> list = userMapper.findUserByName("明");

        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void testInsertUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建一个UserMapper对象,MyBatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("李晓明1");
        user.setBirthday(new Date());
        user.setAddress("湖北省武汉市1");
        user.setSex("男");

        //调用UserMapper的方法
        userMapper.insertUser(user);

        //一定不能忘了事务提交
        sqlSession.commit();

        System.out.println(user.getId());

        sqlSession.close();
    }

    @Test
    public void testDeleteUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建一个UserMapper对象,MyBatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用UserMapper的方法
        userMapper.deleteUser(22);

        //在删除后执行事务提交
        sqlSession.commit();

        sqlSession.close();
    }

    //用户信息的综合查询
    @Test
    public void testFindUserList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建一个UserMapper对象,MyBatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //创建包装对象，设置查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex("女");
        userCustom.setUsername("Only");
        userQueryVo.setUserCustom(userCustom);
        //调用UserMapper的方法
        List<UserCustom> list = userMapper.findUserList(userQueryVo);

        System.out.println(list);
    }

}
