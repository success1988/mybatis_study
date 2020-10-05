package reflection;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Title：对象工厂测试
 * @Author：wangchenggong
 * @Date 2020/10/2 10:06
 * @Description
 * @Version
 */
public class TestDefaultObjectFactory {

    public static void main(String[] args) {
        ObjectFactory objectFactory = new DefaultObjectFactory();
        List list = objectFactory.create(List.class);
        list.add("zhangsan");
        System.out.println(list);
    }



    public static void main2(String[] args) {
        List<Object> constructorArgs = null;
        /**
         * 1.Optional的用法：
         */
        List<Object> a = Optional.ofNullable(constructorArgs).orElse(Collections.emptyList());
        List<Object> b = Optional.ofNullable(constructorArgs).orElseGet(Collections::emptyList);
        /**
         *2. ::的用法:  String::valueOf   等价于lambda表达式 (s) -> String.valueOf(s)
         */

        String argValues = Optional.ofNullable(constructorArgs).orElseGet(Collections::emptyList)
                //map():用于映射每个元素到对应的结果
                //Collectors类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串
                .stream().map(String::valueOf).collect(Collectors.joining(","));

        /**
         * 3.stream的用法
         */
        System.out.println(argValues);
    }
}
