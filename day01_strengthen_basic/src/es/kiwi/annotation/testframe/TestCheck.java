package es.kiwi.annotation.testframe;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 简单的测试框架
 *
 * 当主方法执行后，会自动自行被检测的所有方法(加了Check注解的方法)，判断方法是否有异常，记录到文件中
 *
 * * 小结：
 * 	1. 以后大多数时候，我们会使用注解，而不是自定义注解
 * 	2. 注解给谁用？
 * 		1. 编译器
 * 		2. 给解析程序用
 * 	3. 注解不是程序的一部分，可以理解为注解就是一个标签
 */
public class TestCheck {

    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        Class<? extends Calculator> aClass = calculator.getClass();
        Method[] methods = aClass.getMethods();

        int counter = 0; // 出现异常的次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));


        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    method.invoke(calculator);

                } catch (Exception e) {// 捕获异常，记录到文件中
                    counter ++;

                    bw.write(method.getName() + "方法出现异常");
                    bw.newLine();
                    bw.write("异常的名称：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因：" + e.getCause().getMessage());
                    bw.newLine();
                    //it's negative number -2, means the information is unavailable
                    /*bw.write("异常出现行号：" + e.getStackTrace()[0].getLineNumber());
                    bw.newLine();*/
                    bw.write("---------------------------");
                    bw.newLine();
                }
            }
        }

        bw.write("本次测试一共出现" + counter + "次异常");
//        bw.flush();
        bw.close();

    }

}
