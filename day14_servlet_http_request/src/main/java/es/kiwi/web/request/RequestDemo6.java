package es.kiwi.web.request;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * 1. 获取请求参数通用方式：不论get还是post请求方式都可以使用下列方法来获取请求参数
 * 				1. String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
 * 				2. String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game 多用于复选框
 * 				3. Enumeration<String> getParameterNames():获取所有请求的参数名称
 * 				4. Map<String,String[]> getParameterMap():获取所有参数的map集合
 */
@WebServlet(name = "RequestDemo6", value = "/requestDemo6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get获取请求参数

        // 根据参数名称获取参数值
        /*String username = request.getParameter("username");
        System.out.println("get");
        System.out.println(username);*/

        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // post获取请求参数

        // 根据参数名称获取参数值
        String username = request.getParameter("username");
        System.out.println(request.getMethod());
        System.out.println("username : " + username);

        // 根据参数名称获取参数值的数组
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println("hobby : " + hobby);
        }

        // 获取所有请求的参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = request.getParameter(name); // 不能获取数组，只能返回一个
            System.out.println(value);
            System.out.println("--------------------");
        }

        // 获取所有参数map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for (String key : keySet) {
            String[] values = parameterMap.get(key);
            System.out.println(key);
            for (String value : values) {
                System.out.println(value);
            }

            System.out.println("------------------------");
        }

    }
}
