package es.kiwi.web.filter;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
//@Slf4j //引入注解同时需要在pom文件中引入slf4j依赖
public class FilterDemo17 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo7....");
        chain.doFilter(request, response);
        System.out.println("filterDemo7 coming back");
    }
}
