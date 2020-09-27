package com.proxy.staticProxy;

/**
 * 描述:
 * 房东接口
 * @outhor Calebit
 * @create 2020-09-25 8:42
 */
public interface ILandlord {
    //出售
    String sell(int price);
    //出租
    String lease(int leaseTime,int price);
}
