package com.jake.stackqueue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.IntFunction;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class StaqueTest {
    @Test
    public void testDequeue() {
        String expectedOne = "Hello";
        String expectedTwo = "World";

        Staque<String> staque = new Staque<>();
        staque.enqueue(expectedOne);
        staque.enqueue(expectedTwo);

        assertEquals(expectedOne, staque.dequeue());
        assertEquals(expectedTwo, staque.dequeue());
    }

    @Test
    public void testEnqueueAndPeek() {
        String expected = "Hello world!";

        Staque<String> staque = new Staque<>();

        assertTrue(staque.enqueue(expected));

        assertEquals(expected, staque.peek());
    }

    @Test
    public void testRemove() {
        String str = "I don't wanna be here";

        Staque<String> staque = new Staque<>();

        staque.enqueue(str);

        assertTrue(staque.contains(str));

        staque.remove(str);

        assertFalse(staque.contains(str));
    }

    @Test
    public void testSize() {
        String dummy = "";
        Staque<String> staque = new Staque<>();

        assertEquals(0, staque.size());

        staque.enqueue(dummy);

        assertEquals(1, staque.size());
    }

    @Test
    public void testClear() {
        String dummy = "";
        Staque<String> staque = new Staque<>();
        staque.enqueue(dummy);
        staque.enqueue(dummy);
        assertEquals(2, staque.size());

        staque.clear();
        assertEquals(0, staque.size());
    }

    @Test
    public void testAddAllFromEmpty() {
        ArrayList<String> strings = new ArrayList<>(List.of(new String[]{"", "", ""}));
        Staque<String> staque = new Staque<>();
        assertEquals(0, staque.size());

        staque.addAll(strings);

        assertEquals(strings.size(), staque.size());
    }

    @Test
    public void testAddAllFromNotEmpty() {
        ArrayList<String> strings = new ArrayList<>(List.of(new String[]{"", "", ""}));
        Staque<String> staque = new Staque<>();
        staque.enqueue("");
        assertEquals(1, staque.size());

        staque.addAll(strings);

        assertEquals(strings.size() + 1, staque.size());
    }

    @Test
    public void testRemoveAll() {
        ArrayList<String> words = new ArrayList<>(List.of("I", "AM", "A", "LIST", "OF", "WORDS"));
        Staque<String> staque = new Staque<>();
        staque.enqueue("i am lowercase");
        staque.addAll(words);
        assertEquals(words.size() + 1, staque.size());

        staque.removeAll(words);

        assertEquals(1, staque.size());
    }

    @Test
    public void testRetainAll() {
        ArrayList<String> words = new ArrayList<>(List.of("I", "AM", "A", "LIST", "OF", "WORDS"));
        Staque<String> staque = new Staque<>();
        staque.enqueue("i am lowercase");
        staque.addAll(words);
        assertEquals(words.size() + 1, staque.size());

        staque.retainAll(words);

        assertEquals(words.size(), staque.size());
    }

    @Test
    public void testContainsAll() {
        ArrayList<String> words = new ArrayList<>(List.of("I", "AM", "A", "LIST", "OF", "WORDS"));
        Staque<String> staque = new Staque<>();
        staque.enqueue("i am lowercase");
        staque.addAll(words);
        assertTrue(staque.containsAll(words));
    }

    @Test
    public void testSpliterator() {
        Staque<String> staque = new Staque<>();

        assertTrue(staque.spliterator() instanceof Spliterator);
        assertNotNull(staque.spliterator());
    }

    @Test
    public void testStream() {
        Staque<String> staque = new Staque<>();

        assertNotNull(staque.stream());
        assertTrue(staque.stream() instanceof Stream);
    }

    @Test
    public void testParallelStream() {
        Staque<String> staque = new Staque<>();

        assertNotNull(staque.parallelStream());
        assertTrue(staque.parallelStream() instanceof Stream);
    }

    @Test
    public void testToObjectArray() {
        Staque<String> staque = new Staque<>();
        staque.enqueue("");

        assertTrue(staque.toArray() instanceof Object[]);
        assertFalse(staque.toArray() instanceof String[]);
    }

    @Test
    public void testToTArrayWithArrayParam() {
        Staque<String> staque = new Staque<>();
        staque.enqueue("");

        assertTrue(staque.toArray(new String[0]) instanceof String[]);
    }

    @Test
    public void testToTArrayWithIntGeneratorParam() {
        Staque<String> staque = new Staque<>();
        staque.enqueue("");

        assertTrue(staque.toArray(value -> new String[0]) instanceof String[]);
    }

    @Test
    public void testIterator() {
        Staque<String> staque = new Staque<>();
        staque.enqueue("");

        assertTrue(staque.iterator() instanceof Iterator);
    }

    @Test
    public void testIsEmpty() {
        Staque<String> staque = new Staque<>();
        assertTrue(staque.isEmpty());

        staque.enqueue("");

        assertFalse(staque.isEmpty());
    }
}
