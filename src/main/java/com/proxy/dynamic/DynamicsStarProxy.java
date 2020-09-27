package com.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 描述:
 *
 * @outhor Calebit
 * @create 2020-09-25 8:57
 */
public class DynamicsStarProxy implements InvocationHandler {

    Object obj;

    DynamicsStarProxy(Object obj){
        this.obj=obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态明星代理和甲方协商出演的酬劳");
        Object res = method.invoke(obj, args);
        System.out.println("动态明星代理得到明星的决定，并告知甲方");
        return res;
    }



}
