package es.kiwi.annotation;

import java.lang.reflect.Method;

/**
 * 框架类
 *  注解大多时候是为了替换配置文件的
 */
@Prop(className = "es.kiwi.annotation.Demo2", methodName = "show")
public class ReflectAnnoTest {
    public static void main(String[] args) throws Exception {
        // 1. 解析注解
        // 1.1 获取该类的字节码文件对象
        Class<ReflectAnnoTest> annoTestClass = ReflectAnnoTest.class;
        //2. 获取上边注解对象
        //起始就是在内存中生成了该注解接口的子类实现对象
        Prop prop = annoTestClass.getAnnotation(Prop.class);
        /*
        public class PropImpl implements Pro {
            public String className(){
                return "es.kiwi.annotation.Demo1";
            }

            public String methodName(){
                return ""show;
            }
        }
        */
        //3. 调用注解对象中的定义的抽象方法，获取返回值
        String className = prop.className();
        String methodName = prop.methodName();

        System.out.println(className + " " + methodName);

        Class<?> aClass = Class.forName(className);
        Method method = aClass.getDeclaredMethod(methodName);
        Object instance = aClass.getConstructor().newInstance();
        method.invoke(instance);

    }

}
