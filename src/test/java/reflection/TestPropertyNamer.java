package reflection;

import org.apache.ibatis.reflection.property.PropertyNamer;

/**
 * @Title：属性名称操作测试
 * @Author：wangchenggong
 * @Date 2020/10/3 10:02
 * @Description
 * @Version
 */
public class TestPropertyNamer {

    public static void main(String[] args) {
        String field = PropertyNamer.methodToProperty("getAge");
        System.out.println(field);
    }
}
