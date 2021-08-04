package es.kiwi.cookie;

import sun.util.resources.cldr.cs.CalendarData_cs_CZ;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 案例：记住上一次访问时间
 * 	1. 需求：
 * 		1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
 * 		2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
 *  2. 分析：
 * 		1. 可以采用Cookie来完成
 * 		2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 * 			1. 有：不是第一次访问
 * 				1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:01
 * 				2. 写回Cookie：lastTime=2018年6月10日11:50:20
 * 			2. 没有：是第一次访问
 * 				1. 响应数据：您好，欢迎您首次访问
 * 				2. 写回Cookie：lastTime=2018年6月10日11:50:01
 */
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的消息体的数据格式以及编码
        response.setContentType("text/html; charset=UTF-8");

        //1.获取所有Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        //2.遍历cookie数组
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                //3.获取cookie的名称
                //4.判断名称是否是：lastTime
                if ("lastTime".equals(cookie.getName())) {
                    //有该Cookie，不是第一次访问
                    flag = true;

                    //获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
                    addLastTimeCookie(response, cookie);

                    //响应数据
                    //获取Cookie的value，时间
                    String value = cookie.getValue();

                    System.out.println("解码前：" + value);
                    //URL解码：
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后：" + value);

                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为:" + value + "</h1>");

                    break;
                }
            }
        }

        if (cookies == null || cookies.length == 0 || !flag) {
            Cookie cookie = new Cookie("lastTime", "");
            addLastTimeCookie(response, cookie);
            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }
    }

    /**
     * 获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
     *
     * @param response
     * @param cookie
     * @throws UnsupportedEncodingException
     */
    private void addLastTimeCookie(HttpServletResponse response, Cookie cookie) throws UnsupportedEncodingException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);

        System.out.println("编码前：" + str_date);
        //URL编码
        str_date = URLEncoder.encode(str_date, "utf-8");
        System.out.println("编码后：" + str_date);

        //设置Cookie的value
        cookie.setValue(str_date);
        //设置cookie的存活时间
        cookie.setMaxAge(60 * 60 * 24 * 30); // 一个月
//        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
