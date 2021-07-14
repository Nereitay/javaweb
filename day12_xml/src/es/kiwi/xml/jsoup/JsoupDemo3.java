package es.kiwi.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
/**
 * Document/Element对象功能
 */
public class JsoupDemo3 {

    public static void main(String[] args) throws IOException {
        //1.获取student.xml的path
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        //2.获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.获取元素对象了。
        //3.1获取所有student对象
        Elements students = document.getElementsByTag("student");
        System.out.println(students);

        System.out.println("-----------------");

        //3.2 获取属性名为id的元素对象们
        Elements ids = document.getElementsByAttribute("id");
        System.out.println(ids);

        System.out.println("-----------------");

        //3.2获取 number属性值为heima_0001的元素对象
        Elements number = document.getElementsByAttributeValue("number", "kiwi_0001");
        System.out.println(number);


        //3.3获取id属性值的元素对象
        Element kiwi = document.getElementById("kiwi");
        System.out.println(kiwi);


    }
}
