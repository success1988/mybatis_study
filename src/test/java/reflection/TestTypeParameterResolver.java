package reflection;

import bean.MyHardList;
import bean.MyList;
import bean.SuperStar;
import org.apache.ibatis.reflection.ArrayUtil;
import org.apache.ibatis.reflection.TypeParameterResolver;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * @Title：泛型参数解析器 测试类
 * @Author：wangchenggong
 * @Date 2020/10/5 6:14
 * @Description
 * @Version
 */
public class TestTypeParameterResolver {

    public static void main(String[] args) throws Exception {

        //解析返回值的泛型
        //testReturnType();
        //testReturnType2();

        //解析入参的泛型
       // testParamType();

        //解析属性的泛型
        testFieldType();

    }

    private static void testFieldType() throws NoSuchFieldException {
        //addressMap
        Class<SuperStar> superStarclazz = SuperStar.class;
        Field addressMap = superStarclazz.getDeclaredField("addressMap");

        Type fieldType = TypeParameterResolver.resolveFieldType(addressMap, superStarclazz);
        //ParameterizedTypeImpl [rawType=interface java.util.Map, ownerType=null, actualTypeArguments=[class java.lang.String, class bean.Address]]
        System.out.println(fieldType);
    }

    private static void testParamType() throws NoSuchMethodException {
        //subList
        Class<MyHardList> myHardListclazz = MyHardList.class;
        Method addAllMethod = myHardListclazz.getDeclaredMethod("addAll", Collection.class);

        Type[] paramTypes = TypeParameterResolver.resolveParamTypes(addAllMethod, myHardListclazz);
        //ParameterizedTypeImpl [rawType=interface java.util.Collection, ownerType=null, actualTypeArguments=[org.apache.ibatis.reflection.TypeParameterResolver$WildcardTypeImpl@66048bfd]]
        System.out.println(ArrayUtil.toString(paramTypes));
    }

    private static void testReturnType() throws NoSuchMethodException {
        //subList
        Class<MyList> myListclazz = MyList.class;
        Method subListMethod = myListclazz.getDeclaredMethod("subList", int.class, int.class);

        Type returnType = TypeParameterResolver.resolveReturnType(subListMethod, myListclazz);
        //ParameterizedTypeImpl [rawType=interface java.util.List, ownerType=null, actualTypeArguments=[class bean.User]]
        System.out.println(returnType);
    }


    private static void testReturnType2() throws NoSuchMethodException {
        //subList
        Class<MyHardList> myHardListclazz = MyHardList.class;
        Method subListMethod = myHardListclazz.getDeclaredMethod("subList", int.class, int.class);

        Type returnType = TypeParameterResolver.resolveReturnType(subListMethod, myHardListclazz);
        //ParameterizedTypeImpl [rawType=interface java.util.List, ownerType=null, actualTypeArguments=[class bean.User]]
        System.out.println(returnType);
    }
}


