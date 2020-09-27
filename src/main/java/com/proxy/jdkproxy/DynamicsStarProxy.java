package com.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 描述:
 *
 * @outhor Calebit
 * @create 2020-09-25 9:14
 */
public class DynamicsStarProxy implements InvocationHandler {

    Object obj;

    DynamicsStarProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("sing".equals(method.getName())) {//判断是否为sing方法
            for (Object o : args) {//sing方法c传入的就是代理生成的对象
                System.out.println(proxy == o);//判断地址是否相同
            }
        }
        Object res = method.invoke(obj, args);
        return res;
    }


}
