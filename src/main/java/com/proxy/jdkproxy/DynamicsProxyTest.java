package com.proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * 描述:
 *
 * @outhor Calebit
 * @create 2020-09-25 9:15
 */
public class DynamicsProxyTest {


    public static void main(String[] args) {
        Star taylorSwift = new SingingStar();
        DynamicsStarProxy starProxy = new DynamicsStarProxy(taylorSwift);
        Star proxy = (Star) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), taylorSwift.getClass().getInterfaces(), starProxy);
        Object singRes = proxy.sing(proxy);

    }


}
