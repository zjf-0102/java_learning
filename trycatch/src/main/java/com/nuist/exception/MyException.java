package com.nuist.exception;

public class MyException {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            person = null;
            person.getName();
            int x = 1, y = 0;
            System.out.println(x / y);
        } catch (NullPointerException  e) {//子类写在上面，父类写在下面
            System.out.println("空指针异常捕获");
        } catch (ArithmeticException e){
            System.out.println("算数异常捕获");
        } catch (Exception e){
            System.out.println("总的异常捕获");
        }
    }
}

class Person {
    private final String name = "jack";

    public String getName() {
        return name;
    }
}

/*
编写代码时，系统会自动处理运行时异常，即方法后会默认自带throws RuntimeException
           但时不会自动处理编译时异常，需要显式处理，比如FileNotFoundException
 */