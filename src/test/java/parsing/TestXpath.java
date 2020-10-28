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
        String resource = "info2.xml";

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        //如何读取
        //方式一：利用Class的getResourceAsStream
        //注意： TestXpath.class.getResourceAsStream("aaa.xml")取的是 TestXpath.class文件的相对路径，即TestXpath.class文件同级目录下的aaa.xml文件
        //      TestXpath.class.getResourceAsStream("/aaa.xml")取的是 类路径（classes目录）下的aaa.xml文件
        Document document = documentBuilder.parse(TestXpath.class.getResourceAsStream("/"+resource));





        //Document document = documentBuilder.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));
        //Document document = documentBuilder.parse(TestXpath.class.getResourceAsStream(resource));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        XPathExpression xPathExpression = xPath.compile("/members/user[id=1]");
        System.out.println(xPathExpression.evaluate(document));

    }

}
