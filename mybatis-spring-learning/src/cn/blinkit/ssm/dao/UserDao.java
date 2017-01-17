package cn.blinkit.ssm.dao;

import cn.blinkit.ssm.po.User;

/**
 * @Author: Only-lezi
 * @Date: 2017-01-04 13:07
 * @Description: dao接口，用户管理
 */

public interface UserDao {
    //根据id查询用户信息
    public User findUserById(int id) throws Exception;
}
