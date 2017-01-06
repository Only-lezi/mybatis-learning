package cn.blinkit.mybatis.dao;

import cn.blinkit.mybatis.po.User;

/**
 * @Author: Only-lezi
 * @Date: 2017-01-04 13:07
 * @Description: dao接口，用户管理
 */

public interface UserDao {
    //根据id查询用户信息
    public User findUserById(int id) throws Exception;

    //添加用户信息
    public void insertUser(User user) throws Exception;

    //删除用户信息
    public void deleteUser(int id) throws Exception;


}
