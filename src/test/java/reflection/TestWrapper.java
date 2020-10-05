package reflection;

import bean.Address;
import bean.SuperStar;
import bean.User;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.BeanWrapper;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title：对象的包装，方便对对象属性进行操作
 * @Author：wangchenggong
 * @Date 2020/10/3 16:04
 * @Description
 * @Version
 */
public class TestWrapper {

    public static void main(String[] args) {

       // testBeanWrapper();

       // testCollectionWrapper();

        testMapWrapper();
    }

    private static void testMapWrapper() {

        Address beijingAddress = new Address();
        beijingAddress.setProvince("北京市");
        beijingAddress.setCity("北京");
        beijingAddress.setStreet("回龙观");

        Address zhengzhouAddress = new Address();
        zhengzhouAddress.setProvince("河南省");
        zhengzhouAddress.setCity("郑州市");
        zhengzhouAddress.setStreet("紫荆山");

        Map<String,Address> addressMap = new HashMap<>();
        addressMap.put("beijing",beijingAddress);
        addressMap.put("zhengzhou",zhengzhouAddress);

        /*SuperStar superStar = new SuperStar();
        superStar.setAddressMap(addressMap);*/


        ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
        ObjectFactory objectFactory = new DefaultObjectFactory();
        ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();

        //MetaObject metaObject = MetaObject.forObject(superStar, objectFactory, objectWrapperFactory, reflectorFactory);
        MetaObject metaObject = MetaObject.forObject(addressMap, objectFactory, objectWrapperFactory, reflectorFactory);

        Object result = metaObject.getValue("zhengzhou.street");
        System.out.println(result);

    }

    private static void testCollectionWrapper() {
        Address address = new Address();
        address.setProvince("北京市");
        address.setCity("北京");
        address.setStreet("回龙观");

        User user = new User();
        user.setName("成功");
        user.setSex("男");
        user.setAddress(address);


        SuperStar superStar = new SuperStar();
        superStar.setUsers(Arrays.asList(user));


        ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
        ObjectFactory objectFactory = new DefaultObjectFactory();
        ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();

        MetaObject metaObject = MetaObject.forObject(superStar, objectFactory, objectWrapperFactory, reflectorFactory);

        Object result = metaObject.getValue("users[0].address.city");
        System.out.println(result);



    }


    private static void testBeanWrapper() {
        /*Father father = new Father();
        father.setAge(18);
        father.setName("张三");*/

        Address address = new Address();
        address.setProvince("北京市");
        address.setCity("北京");
        address.setStreet("回龙观");

        User user = new User();
        user.setName("成功");
        user.setSex("男");
        user.setAddress(address);

        ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
        ObjectFactory objectFactory = new DefaultObjectFactory();
        ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();

        MetaObject metaObject = MetaObject.forObject(user, objectFactory, objectWrapperFactory, reflectorFactory);

        /*Object result = metaObject.getValue("address.city");
        System.out.println(result);*/

        ObjectWrapper objectWrapper = new BeanWrapper(metaObject, user);
        /*String property = objectWrapper.findProperty("address.city", true);
        System.out.println(property);*/

        Class<?> clazz = objectWrapper.getGetterType("address.city");
        System.out.println(clazz);

    }
}
