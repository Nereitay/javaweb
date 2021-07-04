package es.kiwi.reflect;

import es.kiwi.domain.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * * Method：方法对象
 * 	* 执行方法：
 * 		* Object invoke(Object obj, Object... args)
 *
 * 	* 获取方法名称：
 * 		* String getName:获取方法名
 */
public class ReflectDemo4 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Person person = new Person();

        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
        }
        System.out.println("===========================");
        Method eat = personClass.getMethod("eat");
        eat.invoke(person);
        Method eat1 = personClass.getMethod("eat", String.class);
        eat1.invoke(person, "vegetable");

        System.out.println("===========================");
        String className = personClass.getName();// 全类名
        System.out.println(className);

    }
}
