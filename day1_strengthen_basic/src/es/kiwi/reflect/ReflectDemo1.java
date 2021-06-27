package es.kiwi.reflect;

import es.kiwi.domain.Person;

/**
 * 反射：框架设计灵魂
 *      框架：半成品软件，可以在框架基础上进行软件开发，简化编码
 *      反射：将类的各个组成部分（成员变量、构造方法、成员方法）封装为其他对象，这就是反射机制
 *
 * 获取Class对象的方式：
 *             1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象  -- 多用于配置文件，将类名定义在配置文件中。读取文件，加载类
 *             2. 类名.class：通过类名的属性class获取   -- 多用于参数传递
 *             3. 对象.getClass()：getClass()方法在Object类中定义着。-- 用于对象获取字节码文件
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. Class.forName("全类名")
        Class<?> aClass = Class.forName("es.kiwi.domain.Person");
        System.out.println(aClass);

        //2. 类名.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        //3. 对象.getClass()
        Person person = new Person();
        Class<? extends Person> aClass1 = person.getClass();
        System.out.println(aClass1);

        // 比较三个对象
        // 同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，无论通过哪一种方式获取的Class对象都是同一个
        System.out.println(aClass == aClass1); // true
        System.out.println(aClass == personClass); // true

    }

}
