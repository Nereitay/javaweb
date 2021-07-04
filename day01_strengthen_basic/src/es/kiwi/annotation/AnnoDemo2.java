package es.kiwi.annotation;

import java.util.Date;

/**
 * java 3个预定义注解
 *   @Override：检测被该注解标注的方法是否是继承自父类(接口)的
 * 	 @Deprecated：该注解标注的内容，表示已过时
 * 	 @SuppressWarnings：压制警告
 * 		-> 一般传递参数all  @SuppressWarnings("all")
 */
public class AnnoDemo2 {

    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1() {
        //有缺陷
    }

    @SuppressWarnings("all")
    public void show2() {
        //替代show1方法
    }

    public void demo() {
        show1();
        Date date = new Date();
    }
}
