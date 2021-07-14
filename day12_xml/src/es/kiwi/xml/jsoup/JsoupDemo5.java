package es.kiwi.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 *
 *
 * 快捷查询方式：
 * 		1. selector:选择器
 * 			* 使用的方法：Elements	select(String cssQuery)
 * 				* 语法：参考Selector类中定义的语法
 * 		2. XPath：XPath即为XML路径语言，它是一种用来确定XML（标准通用标记语言的子集）文档中某部分位置的语言
 *
 * 选择器查询
 *
 *
 */
public class JsoupDemo5 {

    public static void main(String[] args) throws IOException {
        String path = JsoupDemo5.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.查询name标签
        /*
            div{

            }
         */
        Elements name = document.select("name");
        System.out.println(name);
        System.out.println("=========================");

        //4.查询id值为itcast的元素
        Elements kiwi = document.select("#kiwi");
        System.out.println(kiwi);
        System.out.println("=========================");

        //5.获取student标签并且number属性值为heima_0001的age子标签
        //5.1.获取student标签并且number属性值为heima_0001
        Elements number = document.select("student[number='kiwi_0001']");
        System.out.println(number);
        System.out.println("=========================");

        //5.2获取student标签并且number属性值为heima_0001的age子标签
        Elements select2 = document.select("student[number='kiwi_0001'] > age");
        System.out.println(select2);
    }
}
