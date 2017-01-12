package cn.blinkit.mybatis.po;

/**
 * @author Only-lezi
 * @date: 2017-01-08 12:52
 * @description: 订单的扩展类
 */
//通过此类映射订单和用户查询的结果，让此类集成包括字段较多的pojo类
public class OrdersCustom extends Orders {
    //继承Orders类，已经有了Orders类的所有属性了
    // 添加用户属性
    /*
      `user`.username,
      `user`.sex,
      `user`.address
     */

    private String username;
    private String sex;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
