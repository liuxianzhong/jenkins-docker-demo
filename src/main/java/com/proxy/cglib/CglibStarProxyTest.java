package com.proxy.cglib;

/**
 * 描述:
 *
 * @outhor Calebit
 * @create 2020-09-25 9:05
 */
public class CglibStarProxyTest {

    public static void main(String[] args) {
        CglibStarProxy starProxy = new CglibStarProxy();
        //DanceStar ssyy=new DanceStar("三上悠亚");//模拟JDK动态代理
        DanceStar ssyy2 = null;
        ssyy2 = starProxy.getObjByEnhancer(DanceStar.class);
        //ssyy2= (DanceStar) starProxy.getObjByEnhancer(ssyy);//模拟JDK动态代理
        String res = ssyy2.dancing("钢管舞");
        System.out.println("甲方得到的结果：" + res);

    }

}
