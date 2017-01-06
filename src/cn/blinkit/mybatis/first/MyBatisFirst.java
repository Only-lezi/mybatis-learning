package cn.blinkit.mybatis.first;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import cn.blinkit.mybatis.po.User;

/**
 * @Author: Only-lezi
 * @Date: 2017-01-03 14:11
 * @Description: MyBatis入门程序   使用sqlMap/User.xml这个文件
 */

public class MyBatisFirst {
    /**
     * 获取SqlSession的方法
     */
    public SqlSession getSession() throws IOException {
        //MyBatis配置文件
        String resource = "SqlMapConfig.xml";

        //得到配置文件流
        InputStream inputStream =  Resources.getResourceAsStream(resource);

        //创建会话工厂，传入MyBatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession;
    }

    //根据id查询用户信息，得到一条记录
    @Test
    public void testFindUserById() throws IOException {

        //获取SqlSession
        SqlSession sqlSession = getSession();

        //通过SqlSession操作数据库
        //第一个参数：映射文件中statement的id，= namespace + statement的id
        //第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        //sqlSession.selectOne()结果是与映射文件中所匹配的resultType类型的对象
        User user = sqlSession.selectOne("test.findUserById", 1);
        System.out.println(user);

        //释放资源，最好放在finally中，这里只是测试程序，就不弄了
        sqlSession.close();
    }

    //根据用户名称模糊查询用户列表
    @Test
    public void testFindUserByName() throws IOException {
        //获取SqlSession
        SqlSession sqlSession = getSession();

        //list中的user和映射文件中的resultType所指定的类型一致
        List<User> userList = sqlSession.selectList("test.findUserByName", "明");
        System.out.println(userList);

        //释放资源，最好放在finally中，这里只是测试程序，就不弄了
        sqlSession.close();
    }

    //添加用户信息
    @Test
    public void testInsertUser() throws IOException {
        //获取SqlSession
        SqlSession sqlSession = getSession();

        //插入用户对象
        User user = new User();
        user.setUsername("Only-lezi");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("河南省南阳市");

        //传入user对象
        sqlSession.insert("test.insertUser", user);

        //提交事务
        sqlSession.commit();

        //获取用户信息主键
        System.out.println(user.getId());

        //释放资源，最好放在finally中，这里只是测试程序，就不弄了
        sqlSession.close();
    }

    //根据id删除用户信息
    @Test
    public void testDeleteUser() throws IOException {
        //获取SqlSession
        SqlSession sqlSession = getSession();

        //传入id删除用户
        sqlSession.delete("test.deleteUser", 14);

        //提交事务
        sqlSession.commit();

        //释放资源，最好放在finally中，这里只是测试程序，就不弄了
        sqlSession.close();
    }

    //更新用户信息
    @Test
    public void testUpdateUser() throws IOException {
        //获取SqlSession
        SqlSession sqlSession = getSession();

        //更新用户的信息
        User user = new User();
        //必须设置id
        user.setId(5);
        user.setUsername("Only");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("河南省南阳市");

        //传入user对象
        sqlSession.update("test.updateUser", user);

        //提交事务
        sqlSession.commit();

        //释放资源，最好放在finally中，这里只是测试程序，就不弄了
        sqlSession.close();
    }
}
