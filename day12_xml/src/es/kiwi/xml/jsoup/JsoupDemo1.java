package es.kiwi.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Jsoup快速入门
 *  * 步骤：
 * 				1. 导入jar包
 * 				2. 获取Document对象
 * 				3. 获取对应的标签Element对象
 * 				4. 获取数据
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //2. 获取Document对象，根据xml文档获取
        //2.1 获取student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2 解析xml文档，加载文档进内存，获取dom树 -> Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3. 获取元素对象
        Elements elements = document.getElementsByTag("name");

        System.out.println(elements.size());
        //3.1 获取第一个name的element对象
        Element element = elements.get(0);
        //3.2 获取数据
        String name = element.text();
        System.out.println(name);

    }
}
