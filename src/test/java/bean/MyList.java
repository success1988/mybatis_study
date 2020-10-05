package bean;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2020/10/5 6:12
 * @Description
 * @Version
 */
public class MyList implements List<User> {
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
    public Iterator<User> iterator() {
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
    public boolean add(User user) {
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
    public boolean addAll(@NotNull Collection<? extends User> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends User> c) {
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
    public User get(int index) {
        return null;
    }

    @Override
    public User set(int index, User element) {
        return null;
    }

    @Override
    public void add(int index, User element) {

    }

    @Override
    public User remove(int index) {
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
    public ListIterator<User> listIterator() {
        return null;
    }

    @NotNull
    @Override
    public ListIterator<User> listIterator(int index) {
        return null;
    }

    @NotNull
    @Override
    public List<User> subList(int fromIndex, int toIndex) {
        return null;
    }
}
