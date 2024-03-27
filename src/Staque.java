import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

public class Staque<T> implements Collection<T> {
    Stack<T> tempStack;
    Stack<T> staque;
    @Override
    public int size() {
        return staque.size();
    }

    @Override
    public boolean isEmpty() {
        return staque.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return staque.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return staque.iterator();
    }

    @Override
    public Object[] toArray() {
        return staque.toArray();
//        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return staque.toArray(a);
//        return null;
    }

    @Override
    public boolean add(T t) {
        return staque.add(t);
//        return false;
    }

    @Override
    public boolean remove(Object o) {
        return staque.remove(o);
//        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return staque.containsAll(c);
//        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return staque.addAll(c);
//        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return staque.removeAll(c);
//        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return staque.retainAll(c);
//        return false;
    }

    @Override
    public void clear() {
        staque.clear();
    }
}
