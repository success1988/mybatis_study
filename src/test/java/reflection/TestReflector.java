package reflection;

import bean.Son;
import org.apache.ibatis.reflection.Reflector;

import java.util.Arrays;

/**
 * @Title：反射器  单元测试
 * @Author：wangchenggong
 * @Date 2020/10/3 16:33
 * @Description
 * @Version
 */
public class TestReflector {

    public static void main(String[] args) {

        Reflector reflector = new Reflector(Son.class);
        String[] getablePropertyNames = reflector.getGetablePropertyNames();
        System.out.println(Arrays.toString(getablePropertyNames));
    }
}
