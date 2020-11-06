package parsing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @Title：读取属性文件
 * @Author：wangchenggong
 * @Date 2020/11/6 10:57
 * @Description
 * @Version
 */
public class TestPropertiesLoad {

    public static void main(String[] args) {

        //通过调用Properties的load方法加载
        //loadByInputstream();

        //通过ResourceBundle的getBundle方法 方法获取使用指定的基本名称，默认的语言环境和调用者的类加载器获取资源包
        ResourceBundle resource = ResourceBundle.getBundle("cardInfo");
        String bankcardNo = resource.getString("bankCardNo");
        System.out.println("bankCardNo: " + bankcardNo);
    }


    /**
     * 使用java.util.Properties类的load()方法加载properties文件
     */
    private static void loadByInputstream() {
        try {
            // 获取文件流
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("cardInfo.properties");
            //加载格式化后的流
            Properties prop = new Properties();
            prop.load(new InputStreamReader(inputStream, "UTF-8"));

            String bankcardNo = prop.getProperty("bankCardNo");

            System.out.println("bankCardNo: " + bankcardNo);

        } catch (FileNotFoundException e) {
            System.out.println("properties文件路径有误！");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
