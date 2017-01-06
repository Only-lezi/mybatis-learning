package cn.blinkit.mybatis.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.blinkit.mybatis.dao.UserDao;
import cn.blinkit.mybatis.po.User;

/**
 * @Author: Only-lezi
 * @Date: 2017-01-04 13:13
 * @Description: dao的接口实现类,,,用的配置还是sqlMap/User.xml
 */

public class UserDaoImpl implements UserDao {

    //需要向dao实现类中注入SqlSessionFactory
    //这里通过构造方法注入
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("test.findUserById", id);

        //释放资源
        sqlSession.close();

        return user;
    }

    @Override
    public void insertUser(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.insert("test.insertUser", user);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Override
    public void deleteUser(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("test.deleteUser", id);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }
}
