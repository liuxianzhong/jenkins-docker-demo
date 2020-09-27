package com.proxy.jdkproxy;

/**
 * 描述:
 *
 * @outhor Calebit
 * @create 2020-09-25 8:58
 */
public interface Star {

    /**
     * 唱歌
     * @param song 此处用对象封装，可以将代理生成的对象传入
     * @return
     */
    Object sing(Object song);
}
