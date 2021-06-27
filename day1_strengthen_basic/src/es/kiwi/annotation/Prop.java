package es.kiwi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述要执行的类名和方法名
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Prop {

    String className();
    String methodName();
}
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
