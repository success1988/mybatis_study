package reflection;

import bean.Father;
import bean.Son;
import org.apache.ibatis.reflection.property.PropertyCopier;

/**
 * @Title：属性操作测试
 * @Author：wangchenggong
 * @Date 2020/10/3 8:41
 * @Description
 * @Version
 */
public class TestProperty {


    public static void main(String[] args) {
        /*Son son = new Son();
        son.setAge(18);
        son.setName("张三");*/
        Father father = new Father();
        father.setAge(18);
        father.setName("张三");

        Son son2 = new Son();
        PropertyCopier.copyBeanProperties(Son.class, father, son2);
        System.out.println(son2.getName()+","+son2.getAge());
    }

}


