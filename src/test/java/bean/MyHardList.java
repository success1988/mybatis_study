package bean;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2020/10/5 6:28
 * @Description
 * @Version
 */
public class MyHardList implements List<Map<String,Address>> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @NotNull
    @Override
    public Iterator<Map<String, Address>> iterator() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return null;
    }

    @Override
    public boolean add(Map<String, Address> stringAddressMap) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends Map<String, Address>> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends Map<String, Address>> c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Map<String, Address> get(int index) {
        return null;
    }

    @Override
    public Map<String, Address> set(int index, Map<String, Address> element) {
        return null;
    }

    @Override
    public void add(int index, Map<String, Address> element) {

    }

    @Override
    public Map<String, Address> remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @NotNull
    @Override
    public ListIterator<Map<String, Address>> listIterator() {
        return null;
    }

    @NotNull
    @Override
    public ListIterator<Map<String, Address>> listIterator(int index) {
        return null;
    }

    @NotNull
    @Override
    public List<Map<String, Address>> subList(int fromIndex, int toIndex) {
        return null;
    }
}
