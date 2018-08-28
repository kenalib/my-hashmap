package com.example;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void shouldWork() {
        MyHashMap map = new MyHashMap();
        testMap(map);
    }

    @Test
    public void shouldWorkSmall() {
        MyHashMap map = new MyHashMap(2);
        testMap(map);
    }

    private void testMap(MyHashMap map) {
        assertTrue(map.isEmpty());
        assertEquals(map.size(), 0);

        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);

        assertFalse(map.isEmpty());
        assertEquals(map.size(), 3);

        assertTrue(map.containsKey(1));
        assertFalse(map.containsKey(5));

        assertEquals(map.get(1), 10);
        assertEquals(map.get(2), 20);
        assertEquals(map.get(3), 30);

        // overwrite
        map.put(2, 50);

        assertFalse(map.isEmpty());
        assertEquals(map.size(), 3);
        assertEquals(map.get(2), 50);

        map.clear();

        assertTrue(map.isEmpty());
        assertEquals(map.size(), 0);
    }

    @Test
    public void shouldPrint() {
        MyHashMap map = new MyHashMap();
        assertEquals("[0] [1] [2] [3] [4] [5] [6] [7]", map.toString().trim());

        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);

        assertEquals("[0] [1] (1, 10) [2] (2, 20) [3] (3, 30) [4] [5] [6] [7]", map.toString().trim());
    }

    @Test
    public void shouldPrint2() {
        MyHashMap map = new MyHashMap(2);
        assertEquals("[0] [1]", map.toString().trim());

        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);

        assertEquals("[0] (2, 20) [1] (1, 10) (3, 30)", map.toString().trim());
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldError() {
        MyHashMap map = new MyHashMap();
        map.get(1);
    }
}
