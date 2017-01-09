package cn.blinkit.mybatis.mapper;

import java.util.List;

import cn.blinkit.mybatis.po.OrdersCustom;

/**
 * @Author: Only-lezi
 * @Date: 2017-01-08 13:00
 * @Description: 订单的Mapper
 */

public interface OrdersCustomMapper {
    //查询订单关联查询用户信息
    public List<OrdersCustom> findOrdersUser() throws Exception;
}
