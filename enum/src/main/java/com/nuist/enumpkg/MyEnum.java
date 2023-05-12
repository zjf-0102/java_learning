package com.nuist.enumpkg;

public class MyEnum {
}

//自定义枚举类
class Season {
    private String name;
    private String des;

    //内部创建固定的值
    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season SUMMER = new Season("夏天", "炎热");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season WINTER = new Season("冬天", "寒冷");

    //构造器私有化
    private Season(String name, String des) {
        this.name = name;
        this.des = des;
    }

    //不要set
    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

}

//使用enum关键字
enum Season2 {
    //简化写法，这些常量必须写在开头且用逗号隔开
    SPRING("春天", "温暖"), SUMMER("夏天", "炎热"), AUTUMN("秋天", "凉爽"), WINTER("冬天", "寒冷");

    private String name;
    private String des;

    //构造器私有化
    private Season2(String name, String des) {
        this.name = name;
        this.des = des;
    }

    //不要set
    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

}