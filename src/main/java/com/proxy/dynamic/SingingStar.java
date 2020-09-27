package com.proxy.dynamic;

/**
 * 描述:
 *
 * @outhor Calebit
 * @create 2020-09-25 8:56
 */
public class SingingStar implements Star {

    @Override
    public String sing(String song) {
        System.out.println("明星本人表示愿意唱:《"+song+"》");
        return "愿意唱:《"+song+"》";
    }

    @Override
    public String acting() {
        System.out.println("明星本人表示不愿意演戏");
        return "不愿意演戏";
    }

}
