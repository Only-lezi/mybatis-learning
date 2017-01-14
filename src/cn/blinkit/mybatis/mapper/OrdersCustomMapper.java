package cn.blinkit.mybatis.mapper;

import java.util.List;

import cn.blinkit.mybatis.po.Orders;
import cn.blinkit.mybatis.po.OrdersCustom;
import cn.blinkit.mybatis.po.User;

/**
 * @Author: Only-lezi
 * @Date: 2017-01-08 13:00
 * @Description: 订单的Mapper
 */

public interface OrdersCustomMapper {
    //查询订单 关联查询用户信息
    public List<OrdersCustom> findOrdersUser() throws Exception;

    //查询订单关联查询用户使用resultMap
    public List<Orders> findOrdersUserResultMap() throws  Exception;

    //查询订单（关联用户）及订单明细
    public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;

    //查询用户购买的商品信息
    public List<User> findUserAndItemsResultMap() throws Exception;

    //
    public List<Orders> findOrdersUserLazyLoading() throws Exception;
}
