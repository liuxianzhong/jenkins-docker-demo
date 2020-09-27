package com.proxy.cglib;

/**
 * 描述:
 *
 * @outhor Calebit
 * @create 2020-09-25 9:03
 */
public class DanceStar {

    private String name;//艺名

    DanceStar() {
        super();
    }

    DanceStar(String name) {
        super();
        this.name = name;
    }

    //跳舞方法
    public String dancing(String typeName) {
        System.out.println(name + "表示愿意跳" + typeName);
        return name + "愿意跳" + typeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
