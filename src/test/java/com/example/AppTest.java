package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void shouldWork() {
        MyHashMap map = new MyHashMap();

        assertTrue(map.isEmpty());
        assertEquals(map.size(), 0);

        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);

        assertFalse(map.isEmpty());
        assertEquals(map.size(), 3);

        assertTrue(map.containsKey(1));
        assertFalse(map.containsKey(5));

        assertEquals((int)map.get(1), 10);
        assertEquals((int)map.get(2), 20);
        assertEquals((int)map.get(3), 30);

        map.clear();

        assertTrue(map.isEmpty());
        assertEquals(map.size(), 0);
    }
}
