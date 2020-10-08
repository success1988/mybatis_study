package type;

import org.apache.ibatis.type.SimpleTypeRegistry;

import java.math.BigDecimal;

/**
 * @Title：类型注册表测试类
 * @Author：wangchenggong
 * @Date 2020/10/7 7:40
 * @Description
 * @Version
 */
public class TestTypeRegistry {

    public static void main(String[] args) {
        //testSimpleTypeRegistry();


    }

    private static void testSimpleTypeRegistry() {
        boolean isExist = SimpleTypeRegistry.isSimpleType(BigDecimal.class);
        System.out.println(isExist);

    }
}
