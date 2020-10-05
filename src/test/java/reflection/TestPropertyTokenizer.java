package reflection;

import org.apache.ibatis.reflection.property.PropertyTokenizer;

/**
 * @Title：属性标记器,用于解析属性表达式
 * @Author：wangchenggong
 * @Date 2020/10/3 10:09
 * @Description
 * @Version
 */
public class TestPropertyTokenizer {

    public static void main(String[] args) {
        PropertyTokenizer propertyTokenizer = new PropertyTokenizer("user[2].address.city");
        //这里会发生OOM 堆内存溢出
        //System.out.println(JSON.toJSONString(propertyTokenizer));

        //用以下方式代替
        printPropertyTokenizer(propertyTokenizer);



    }

    public static void printPropertyTokenizer(PropertyTokenizer propertyTokenizer){
        if(propertyTokenizer.hasNext()){
            System.out.println("name="+propertyTokenizer.getName()+",indexedName="+propertyTokenizer.getIndexedName()+",index="+propertyTokenizer.getIndex()+",children="+propertyTokenizer.getChildren());
            printPropertyTokenizer(propertyTokenizer.next());
        }
    }

}
