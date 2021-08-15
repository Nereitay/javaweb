package es.kiwi.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 5. 过滤器链(配置多个过滤器)
 * 		* 执行顺序：如果有两个过滤器：过滤器1和过滤器2
 * 			1. 过滤器1
 * 			2. 过滤器2
 * 			3. 资源执行
 * 			4. 过滤器2
 * 			5. 过滤器1
 *
 * 		* 过滤器先后顺序问题：
 * 			1. 注解配置：按照类名的字符串比较规则比较，值小的先执行
 * 				* 如： AFilter 和 BFilter，AFilter就先执行了。
 * 			2. web.xml配置： <filter-mapping>谁定义在上边，谁先执行
 */
@WebFilter("/*")
//@Slf4j //引入注解同时需要在pom文件中引入slf4j-api依赖
public class FilterDemo6 implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo6....");
        chain.doFilter(request, response);
        System.out.println("filterDemo6 coming back");
    }
}
