package com.jake.stackqueue;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Staque<T> implements Collection<T> {
    Stack<T> temp = new Stack<T>();
    Stack<T> queue = new Stack<T>();
    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean contains(Object o) {
        return queue.contains(o);
    }

    public Iterator<T> iterator() {
        return queue.iterator();
    }

    public Object[] toArray() {
        return queue.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return queue.toArray(a);
    }

    public boolean add(T t) {
        while (!queue.isEmpty()) {
            temp.push(queue.pop());
        }
        temp.push(t);
        while (!temp.isEmpty()) {
            queue.push(temp.pop());
        }
        return true;
//        return false;
    }

    public boolean remove(Object o) {
        return queue.remove(o);
//        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return new HashSet<>(queue).containsAll(c);
//        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        while(!queue.isEmpty()) {
            temp.push(queue.pop());
        }
        queue.addAll(c);
        while(!temp.isEmpty()) {
            queue.push(temp.pop());
        }
        return true;
//        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return queue.removeAll(c);
//        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return queue.retainAll(c);
//        return false;
    }

    public void clear() {
        queue.clear();
        temp.clear();
    }

    public Spliterator<T> spliterator() {
        return queue.spliterator();
    }

    @Override
    public Stream<T> stream() {
        return queue.stream();
    }

    @Override
    public Stream<T> parallelStream() {
        return queue.parallelStream();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        queue.forEach(action);
    }

    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        return queue.toArray(generator);
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return queue.removeIf(filter);
    }

    public boolean enqueue(T t) {
        add(t);
        return true;
    }

    public T dequeue() {
        return queue.pop();
    }

    public T peek() {
        return queue.peek();
    }
}
