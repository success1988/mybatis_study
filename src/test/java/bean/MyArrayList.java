package bean;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2020/10/6 20:58
 * @Description
 * @Version
 */
public class MyArrayList<E extends Comparable<E>> extends ArrayList<E> {

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return super.addAll(c);
    }
}
