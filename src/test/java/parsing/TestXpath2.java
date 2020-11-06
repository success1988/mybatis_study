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
public class TestXpath2 {
    /**
     * 如何读取类路径下的文件？ 一、利用Class(支持相对路径和绝对路径）  二、利用ClassLoader（仅支持绝对路径，从classpath的根路径下查找，但路径开头不加斜杠）
     * 方式二：
     * 利用ClassLoader（仅支持绝对路径，从classpath的根路径下查找，但路径开头不加斜杠）获取类路径或读取类路径下的文件
     * 【注意】：【建议使用Thread.currentThread().getContextClassLoader()，其他方式获取类加载器可能会导致和当前线程所运行的类加载器不一致】
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String resource = "info.xml";

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        //a)   利用ClassLoader的getResource获取类路径的资源文件的绝对路径
        System.out.println(TestXpath2.class.getClassLoader().getResource(resource).getPath());
        System.out.println(ClassLoader.getSystemClassLoader().getResource(resource).getPath());
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(resource).getPath());

        //b)  利用ClassLoader的getResourceAsStream将资源文件读取为输入流
        //Document document = documentBuilder.parse(TestXpath.class.getClassLoader().getResourceAsStream(resource));
        //Document document = documentBuilder.parse(ClassLoader.getSystemClassLoader().getResourceAsStream(resource));
        Document document = documentBuilder.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));


        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        XPathExpression xPathExpression = xPath.compile("/members/user[id=1]");
        System.out.println(xPathExpression.evaluate(document));

    }

}
