package es.kiwi.reflect;

import es.kiwi.domain.Person;

import java.lang.reflect.Field;

/**
 * Class对象功能：
 *          * 获取功能：
 *          1. 获取成员变量们
 *              * Field[] getFields()
 *              * Field getField(String name)
 *
 *              * Field[] getDeclaredFields()
 *              * Field getDeclaredField(String name)
 *          2. 获取构造方法们
 *              * Constructor<?>[] getConstructors()
 *              * Constructor<T> getConstructor(类<?>... parameterTypes)
 *
 *              * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
 *              * Constructor<?>[] getDeclaredConstructors()
 *          3. 获取成员方法们：
 *              * Method[] getMethods()
 *              * Method getMethod(String name, 类<?>... parameterTypes)
 *
 *              * Method[] getDeclaredMethods()
 *              * Method getDeclaredMethod(String name, 类<?>... parameterTypes)
 *
 *          4. 获取类名
 *              * String getName()
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;

        Person person = new Person("Cherry", 45);

        // 成员变量
        Field[] fields = personClass.getFields();// public
        for (Field field : fields) {
            System.out.println(field);
        }
        Field field = personClass.getDeclaredField("name");
        System.out.println(field.getName());
        //忽略访问权限修饰符的安全检查
        field.setAccessible(true);//暴力反射
        Object value = field.get(person); // 参数为对象
        System.out.println(value);
    }
}
