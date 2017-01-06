package cn.blinkit.mybatis.po;

/**
 * @Author: Only-lezi
 * @Date: 2017-01-04 22:25
 * @Description: 用户  包装类型
 */

public class UserQueryVo {
    //在这里包装所需要的查询条件

    //用户查询条件
    private UserCustom userCustom;

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    //可以包装其他的查询条件，订单、商品


}
