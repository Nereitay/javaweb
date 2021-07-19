package es.kiwi.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 输出字符数据
 *
 * 服务器输出字符数据到浏览器
 * 		* 步骤：
 * 			1. 获取字符输出流
 * 			2. 输出数据
 *
 * 		* 注意：
 * 			* 乱码问题：
 * 				1. PrintWriter pw = response.getWriter();获取的流的默认编码是ISO-8859-1
 * 				2. 设置该流的默认编码
 * 				3. 告诉浏览器响应体使用的编码
 *
 * 				//简单的形式，设置编码，是在获取流之前设置
 *     			response.setContentType("text/html;charset=utf-8");
 */
@WebServlet(name = "ResponseDemo4", value = "/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo4...........");
        // 获取流对象之前，设置流的默认编码：ISO-8859-1 设置为：GBK
//        response.setCharacterEncoding("GBK");
//        response.setCharacterEncoding("utf-8");

        //告诉浏览器,服务器发送的消息体数据的编码，建议浏览器使用该编码解码
        response.setContentType("text/html;charset=utf-8");
//        response.setHeader("content-type","text/html;charset=utf-8");


        // 1 获取字符输出流
        PrintWriter pw = response.getWriter();//response在一次响应完成后会自动被销毁，获取的流也会自动关闭，不需要刷新
//        pw.write("<h1>Hello Response</h1>");
        pw.write("<h1>你好, Response</h1>");
    }
}
