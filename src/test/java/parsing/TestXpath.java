package parsing;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2020/10/16 7:55
 * @Description
 * @Version
 */
public class TestXpath {

    public static void main(String[] args) throws Exception {
        String resource = "info.xml";

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        //如何读取类路径下的文件？ 一、利用Class(支持相对路径和绝对路径）  二、利用ClassLoader（仅支持绝对路径，从classpath的根路径下查找，但路径开头不加斜杠）
        //方式一：利用Class的getResourceAsStream
        //注意： TestXpath.class.getResourceAsStream("aaa.xml")取的是 TestXpath.class文件的相对路径，即TestXpath.class文件同级目录下的aaa.xml文件
        //      TestXpath.class.getResourceAsStream("/aaa.xml")取的是 类路径（classes目录）下的aaa.xml文件
        //Document document = documentBuilder.parse(TestXpath.class.getResourceAsStream("/"+resource));

        //方式二：利用ClassLoader的getResourceAsStream【建议使用Thread.currentThread().getContextClassLoader()，其他方式获取类加载器可能会导致和当前线程所运行的类加载器不一致】
        //Document document = documentBuilder.parse(TestXpath.class.getClassLoader().getResourceAsStream(resource));
        //Document document = documentBuilder.parse(ClassLoader.getSystemClassLoader().getResourceAsStream(resource));
        Document document = documentBuilder.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));


        //获取类路径的绝对路径
        System.out.println(TestXpath.class.getClassLoader().getResource("").getPath());
        System.out.println(ClassLoader.getSystemClassLoader().getResource("").getPath());
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());


        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        XPathExpression xPathExpression = xPath.compile("/members/user[id=1]");
        System.out.println(xPathExpression.evaluate(document));

    }

}
