package es.kiwi.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 2. 动态代理：在内存中形成代理类
 * * 实现步骤：
 * 1. 代理对象和真实对象实现相同的接口
 * 2. 代理对象 = Proxy.newProxyInstance();
 * 3. 使用代理对象调用方法。
 * 4. 增强方法
 */
public class ProxyTest {
    public static void main(String[] args) {
        //1. 创建真实对象
        Lenovo lenovo = new Lenovo();

        //2. 动态代理增强lenovo对象
        /*
         * 三个参数：
         *  1. 类加载器：真实对象.getClass().getClassLoader()
         *  2. 接口数组：真实对象.getClass().getInterfaces()
         *  3. 处理器：new InvocationHandler()
         */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(),
                lenovo.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 代理逻辑编写方法:代理对象调用的所有方法都会触发该方法执行
                     * @param proxy 代理对象
                     * @param method 代理对象调用的方法，被封装为对象
                     * @param args 代理方法时，传递的实际参数
                     * @return
                     * @throws Throwable
                     *
                     *增强方式：
                     * 		1. 增强参数列表
                     * 		2. 增强返回值类型
                     * 		3. 增强方法体执行逻辑
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /*System.out.println("该方法执行了....");
                        System.out.println(method.getName());
                        System.out.println(args[0]);*/


                        if (method.getName().equals("sale")) {
                            //1. 增强参数
                            double money = (double) args[0];
                            money = money * 0.85;

                            System.out.println("专车接...");

                            //使用真实对象调用该方法
                            String obj = (String) method.invoke(lenovo, money);

                            System.out.println("免费送货...");

                            //增强返回值
                            return obj + "_鼠标垫";
                        } else {
                            Object obj = method.invoke(lenovo, args);
                            return obj;
                        }

                    }
                });

        //2. 调用方法
        String computer = proxy_lenovo.sale(8000);
        System.out.println(computer);

//        proxy_lenovo.show();
    }

}
