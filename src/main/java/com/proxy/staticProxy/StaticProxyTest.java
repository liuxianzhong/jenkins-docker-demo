package com.proxy.staticProxy;

/**
 * 描述:
 *    静态代理测试类
 *
 * @outhor Calebit
 * @create 2020-09-25 8:46
 */
public class StaticProxyTest {

    public static void main(String[] args) {

        //房东
        Landlord landlordA = new Landlord("保利001号", 3000000, 2000, 6);

        //中介（代理 需要传入 房东对象）
        Intermediary proxy = new Intermediary(landlordA);
        String res = proxy.sell(3010000);

        System.out.println("购房者得到的结果:" + res);
        String res2 = proxy.lease(5, 1998);
        System.out.println("购房者得到的结果:" + res2);
    }


}
