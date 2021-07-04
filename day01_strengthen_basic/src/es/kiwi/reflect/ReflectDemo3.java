package es.kiwi.reflect;

import es.kiwi.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * * Constructor:构造方法
 * 	* 创建对象：
 * 		* T newInstance(Object... initargs)
 *
 * 		* 如果使用空参数构造方法创建对象，操作可以简化：Class对象的newInstance方法
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;

        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        Person person = constructor.newInstance("Apple", 16);
        System.out.println(person);

        // 如果使用空参数构造方法创建对象，操作可以简化：Class对象的newInstance方法
        Person person1 = personClass.newInstance();
        System.out.println(person1);
    }
}
