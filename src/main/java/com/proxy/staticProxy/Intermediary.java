package com.proxy.staticProxy;

/**
 * 描述:
 *   中介
 * @outhor Calebit
 * @create 2020-09-25 8:45
 */
public class Intermediary implements ILandlord {

    /**
     * 静态代理要求代理类必须继承被代理对象的接口。
     * 相当于中介(代理类)知道房东(被代理对象)有哪几个方面的要求（方法）。
     */
    private ILandlord obj;

    Intermediary(ILandlord obj) {
        super();
        this.obj = obj;
    }

    @Override
    public String sell(int price) {
        System.out.println("中介将购房人的出价告知房东（购房人出价：" + price + "元）");
        String res = obj.sell(price);
        System.out.println("房东:" + res);
        System.out.println("中介将房东的结果告知购房人");
        return "房东:" + res;
    }

    @Override
    public String lease(int leaseTime, int price) {
        System.out.println("中介将租房人的出价告知房东");
        String res = obj.lease(leaseTime, price);
        System.out.println("房东:" + res);
        System.out.println("中介将房东的结果告知租房人");
        return "房东:" + res;
    }


}
