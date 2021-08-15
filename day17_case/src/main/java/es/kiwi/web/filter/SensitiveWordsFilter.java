package es.kiwi.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 敏感词汇过滤器
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    private List<String> list = new ArrayList<>();//敏感词汇集合

    public void init(FilterConfig config) throws ServletException {
        try {
            //1. 加载配置文件
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("WEB-INF/classes/敏感词汇.txt");
            //2. 读取文件
//            BufferedReader br = new BufferedReader(new FileReader(realPath));
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(realPath), "GBK"));
            //3. 将文件的每一行数据添加到list中
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }

            br.close();

            System.out.println(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException
            , IOException {
        //1. 创建代理对象，增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(),
                request.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        // getParameter方法
                        if (method.getName().equals("getParameter")) {
                            //增强返回值
                            String value = (String) method.invoke(request, args);
                            if (value != null) {
                                value = filterSensetiveWord(value);
                            }

                            return value;
                        }

                        //判断方法名是否是 getParameterMap no funciona?????
                        if (method.getName().equals("getParameterMap")) {
                            Map<String, String[]> map = (Map<String, String[]>) method.invoke(request, args);
                            if (map != null) {
                                Set<String> keySet = map.keySet();
                                for (String key : keySet) {
                                    String[] values = map.get(key);
                                    for (String value : values) {
                                        value = filterSensetiveWord(value);
                                    }
                                }
                            }

                            return map;
                        }

                        //判断方法名是否是 getParameterValue


                        return method.invoke(request, args);
                    }


                });

        chain.doFilter(proxy_req, response);
    }

    private String filterSensetiveWord(String value) {
        for (String str : list) {
            if (value.contains(str)) {
                value = value.replace(str, "***");
            }
        }
        return value;
    }
}
