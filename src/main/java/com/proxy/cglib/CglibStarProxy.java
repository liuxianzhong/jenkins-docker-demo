package com.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 描述:
 *
 * @outhor Calebit
 * @create 2020-09-25 9:03
 */
public class CglibStarProxy implements MethodInterceptor {

    /**
     * 自定义方法：利用Enhancer类生成代理类
     * @param clazz
     * @param <T>
     * @return
     */
    public  <T> T getObjByEnhancer(Class<T> clazz){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        T res = (T) enhancer.create();
        return res;
    }

    /**
     * 自定义方法：利用Enhancer类生成代理类(模拟JDK代理的用法)
     * @param target
     * @return
     */
    private Object object;

    public Object getObjByEnhancer(Object target){
        this.object=target;
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        Object res = enhancer.create();
        return res;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Cglib动态明星代理和甲方协商出演的酬劳");
        Object res=null;
        res = proxy.invokeSuper(obj,args);
        //res = method.invoke(object, args);//模拟JDK代理的用法
        System.out.println("Cglib动态明星代理得到明星的决定，并告知甲方");
        return res;
    }



}
