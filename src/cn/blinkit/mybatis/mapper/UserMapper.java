package cn.blinkit.mybatis.mapper;

import java.util.List;

import cn.blinkit.mybatis.po.User;
import cn.blinkit.mybatis.po.UserCustom;
import cn.blinkit.mybatis.po.UserQueryVo;

/**
 * @Author: Only-lezi
 * @Date: 2017-01-04 13:07
 * @Description: Mapper接口，相当于dao接口，用户管理
 */

public interface UserMapper {

    //根据id查询用户信息，使用resultMap输出
    public User findUserByResultMap(int id) throws Exception;

    //用户信息综合查询
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

    //用户信息综合查询总数
    public int findUserCount(UserQueryVo userQueryVo) throws Exception;

    //根据id查询用户信息
    public User findUserById(int id) throws Exception;

    //根据username查询结果集
    public List<User> findUserByName(String name) throws Exception;

    //添加用户信息
    public void insertUser(User user) throws Exception;

    //删除用户信息
    public void deleteUser(int id) throws Exception;

    //更新用户
    public void updateUser(User user) throws Exception;

}
