package type;

/**
 * @Title：测试TypeReference如何查找理器的目标类型
 * @Author：wangchenggong
 * @Date 2020/10/6 11:09
 * @Description
 * @Version
 */
public class TestTypeReference {
    public static void main2(String[] args) {
        //实例化类型处理器时，就会触发TypeReference中的getSuperclassTypeParameter方法的执行
        //参见org.apache.ibatis.type.TypeReference
        MyIntegerTypeHandler myIntegerTypeHandler = new MyIntegerTypeHandler();
    }


}

