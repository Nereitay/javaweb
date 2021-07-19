package es.kiwi.web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *3. 获取请求体数据:
 * 			* 请求体：只有POST请求方式，才有请求体，在请求体中封装了POST请求的请求参数
 * 			* 步骤：
 * 				1. 获取流对象
 * 					*  BufferedReader getReader()：获取字符输入流，只能操作字符数据
 * 					*  ServletInputStream getInputStream()：获取字节输入流，可以操作所有类型数据
 * 						* 在文件上传知识点后讲解
 *
 * 				2. 再从流对象中拿数据
 */
@WebServlet(name = "RequestDemo5", value = "/requestDemo5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取字符流
        BufferedReader br = request.getReader();

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
