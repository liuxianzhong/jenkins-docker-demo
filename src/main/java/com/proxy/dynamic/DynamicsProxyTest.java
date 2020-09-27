package com.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * 描述:
 *
 * @outhor Calebit
 * @create 2020-09-25 8:58
 */
public class DynamicsProxyTest {

    public static void main(String[] args) {
        Star taylorSwift = new SingingStar();
        DynamicsStarProxy starProxy = new DynamicsStarProxy(taylorSwift);
        Star proxy = (Star) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), taylorSwift.getClass().getInterfaces(), starProxy);

        //甲方找霉霉演唱Mean
        String singRes = proxy.sing("Mean");
        System.out.println("甲方得到的结果：" + singRes);

        //甲方又想找霉霉演戏
        String actRes = proxy.acting();
        System.out.println("甲方得到的结果：" + actRes);

    }

}
