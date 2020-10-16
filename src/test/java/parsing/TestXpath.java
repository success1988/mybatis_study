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
        String resource = "mybatis.xml";
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//        Document document = documentBuilder.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));
        Document document = documentBuilder.parse(TestXpath.class.getResourceAsStream(resource));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        XPathExpression xPathExpression = xPath.compile("mappers/*[1]");
        System.out.println(xPathExpression.evaluate(document));


    }

}
