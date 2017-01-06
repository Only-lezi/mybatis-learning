package cn.blinkit.mybatis.dynamicSQL;

import java.util.List;

import cn.blinkit.mybatis.po.UserCustom;
import cn.blinkit.mybatis.po.UserQueryVo;

/**
 * @Author: Only-lezi
 * @Date: 2017-01-06 18:36
 * @Description:
 */

public interface UserMapper1 {
    //用户信息综合查询
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

    //用户信息综合查询总数
    public int findUserCount(UserQueryVo userQueryVo) throws Exception;

}
