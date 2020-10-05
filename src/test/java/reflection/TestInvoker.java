package reflection;

import bean.Father;
import org.apache.ibatis.reflection.invoker.GetFieldInvoker;
import org.apache.ibatis.reflection.invoker.Invoker;
import org.apache.ibatis.reflection.invoker.MethodInvoker;
import org.apache.ibatis.reflection.invoker.SetFieldInvoker;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Title：属性的获取和设置、方法的执行
 * @Author：wangchenggong
 * @Date 2020/10/3 8:41
 * @Description
 * @Version
 */
public class TestInvoker {

    public static void main(String[] args) throws Exception {
        Father father = new Father();
        father.setAge(18);
        father.setName("张三");

        Field nameField = Father.class.getDeclaredField("name");
        Invoker getInvoker = new GetFieldInvoker(nameField);
        Object name = getInvoker.invoke(father, null);
        System.out.println("test GetFieldInvoker, result:"+father);


        Field ageField = Father.class.getDeclaredField("age");
        Invoker setInvoker = new SetFieldInvoker(ageField);
        setInvoker.invoke(father, new Object[]{20});
        System.out.println("test SetFieldInvoker, result:"+father);

        Method getAgeMethod =  Father.class.getDeclaredMethod("getAge");
        Invoker methodInvoker = new MethodInvoker(getAgeMethod);
        System.out.println(methodInvoker.getType());
        Object result = methodInvoker.invoke(father, null);
        System.out.println("test MethodInvoker, result:"+result);

    }
}
