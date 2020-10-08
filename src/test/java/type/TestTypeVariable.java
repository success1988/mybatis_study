package type;

import bean.User;

import java.lang.annotation.*;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Map;

/**
 * @Title：类型变量测试类
 * @Author：wangchenggong
 * @Date 2020/10/6 13:34
 * @Description
 * @Version
 */
public class TestTypeVariable {

    public static void main2(String[] args) {
        Class<?> clazz = Map.class;
        TypeVariable<? extends Class<?>>[] typeParameters = clazz.getTypeParameters();
        System.out.println(Arrays.toString(typeParameters));
        AnnotatedType[] annotatedBounds = typeParameters[0].getAnnotatedBounds();
        System.out.println(Arrays.toString(annotatedBounds));
    }

    public static void main(String[] args) {
        Class<Supper> subClass = Supper.class;
        TypeVariable<Class<Supper>>[] typeParameters = subClass.getTypeParameters();
        for (TypeVariable<Class<Supper>> typeVariable : typeParameters) {
            System.out.println("getBounds --> " + Arrays.toString(typeVariable.getBounds()));
            System.out.println("getGenericDeclaration  --> " + typeVariable.getGenericDeclaration());
            System.out.println("getName --> " + typeVariable.getName());
            /**
             * 在java1.8之前,注解能放的地方为
             *      TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE,ANNOTATION_TYPE,PACKAGE这些地方，
             * 在1.8之后加入了TYPE_PARAMETER和TYPE_USE两种类型，
             * 表示在其他位置可以用注解，因此在泛型定义的位置加上的注解可以用getAnnotatedBounds获取对应的泛型上的注解
             */
            AnnotatedType[] annotatedBounds = typeVariable.getAnnotatedBounds();
            StringBuilder stringBuilder = new StringBuilder("getAnnotatedBounds --> ");
            for (AnnotatedType annotatedType : annotatedBounds) {
                java.lang.annotation.Annotation[] annotations = annotatedType.getAnnotations();
                for (java.lang.annotation.Annotation annotation : annotations) {
                    stringBuilder.append(annotation).append(",");
                }
            }
            System.out.println(stringBuilder.toString());
            System.out.println("===================");
        }
    }

    public static abstract class Supper<T extends @Anno User & Runnable, E extends Annotation> {

    }
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Documented
@interface Anno{

}