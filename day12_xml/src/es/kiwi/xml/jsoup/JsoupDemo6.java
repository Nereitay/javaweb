package es.kiwi.xml.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 *
 * 2. XPath：XPath即为XML路径语言，它是一种用来确定XML（标准通用标记语言的子集）文档中某部分位置的语言
 * 			* 使用Jsoup的Xpath需要额外导入jar包。
 * 			* 查询w3cshool参考手册，使用xpath的语法完成查询
 *
 *
 */
public class JsoupDemo6 {

    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = JsoupDemo6.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.根据document对象，创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("================================");

        List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }
        System.out.println("================================");

        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }
        System.out.println("================================");

        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id='kiwi']");
        for (JXNode jxNode : jxNodes4) {
            System.out.println(jxNode);
        }
    }
}
