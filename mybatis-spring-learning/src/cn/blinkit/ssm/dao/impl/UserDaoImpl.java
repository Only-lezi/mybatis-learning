package cn.blinkit.ssm.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.blinkit.ssm.dao.UserDao;
import cn.blinkit.ssm.po.User;


/**
 * @Author: Only-lezi
 * @Date: 2017-01-04 13:13
 * @Description: dao的接口实现类,,,用的配置还是sqlMap/User.xml
 */

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    @Override
    public User findUserById(int id) throws Exception {
        //继承SqlSessionDaoSupport,通过继承得到SqlSession
        SqlSession sqlSession = this.getSqlSession();

        User user = sqlSession.selectOne("test.findUserById", id);

        return user;
    }

}
