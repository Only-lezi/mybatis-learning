package cn.blinkit.ssm.mapper;

import java.util.List;

import cn.blinkit.ssm.po.User;

/**
 * @Author: Only-lezi
 * @Date: 2017-01-04 13:07
 * @Description: Mapper接口，相当于dao接口，用户管理
 */

public interface UserMapper {

    //根据id查询用户信息，使用resultMap输出
    public User findUserById(int id) throws Exception;

}
