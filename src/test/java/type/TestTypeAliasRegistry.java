package type;

import org.apache.ibatis.type.TypeAliasRegistry;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2020/10/9 7:30
 * @Description
 * @Version
 */
public class TestTypeAliasRegistry {

    public static void main(String[] args) {
        TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();
        typeAliasRegistry.registerAliases("bean");
        System.out.println(typeAliasRegistry.getTypeAliases());
    }
}
