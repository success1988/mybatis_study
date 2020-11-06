package parsing;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
/**
 * @Title：利用Xpath查找xml中的元素
 * @Author：wangchenggong
 * @Date 2020/10/16 7:55
 * @Description
 * @Version
 */
public class TestXpath {

    /**
     * 如何读取类路径下的文件？ 一、利用Class(支持相对路径和绝对路径）  二、利用ClassLoader（仅支持绝对路径，从classpath的根路径下查找，但路径开头不加斜杠）
     * 方式一：
     * 利用Class(支持相对路径和绝对路径）获取类路径或读取类路径下的文件
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String resource = "info.xml";

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        //a)   利用Class的getResource获取类路径的资源文件的绝对路径
        //注意： TestXpath.class.getResource("/")取的是 classes目录的绝对路径
        System.out.println(TestXpath.class.getResource("/").getPath());
        //      TestXpath.class.getResource("")取的是  当前TestXpath.class文件所在包的绝对路径
        System.out.println(TestXpath.class.getResource("").getPath());


        //b)   利用Class的getResourceAsStream将资源文件读取为输入流
        //注意： TestXpath.class.getResourceAsStream("aaa.xml")取的是 TestXpath.class文件的相对路径，即TestXpath.class文件同级目录下的aaa.xml文件
        //      TestXpath.class.getResourceAsStream("/aaa.xml")取的是 类路径（classes目录）下的aaa.xml文件
        Document document = documentBuilder.parse(TestXpath.class.getResourceAsStream("/"+resource));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        XPathExpression xPathExpression = xPath.compile("/members/user[id=1]");
        System.out.println(xPathExpression.evaluate(document));

    }

}
