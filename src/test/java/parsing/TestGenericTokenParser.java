package parsing;

import org.apache.ibatis.parsing.PropertyParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @Title：测试通用标记解析器的解析方法
 * @Author：wangchenggong
 * @Date 2020/11/6 14:42
 * @Description
 * @Version
 */
public class TestGenericTokenParser {

    public static void main(String[] args) throws Exception {

        // 获取文件流
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("cardInfo.properties");
        //加载格式化后的流
        Properties prop = new Properties();
        prop.load(new InputStreamReader(inputStream, "UTF-8"));

        String result = PropertyParser.parse("I hava a bank card.It is of ${bankCode}.The card no is ${bankCardNo}", prop);
        System.out.println(result);
    }
}
