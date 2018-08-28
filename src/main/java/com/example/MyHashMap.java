package com.example;

import java.util.NoSuchElementException;

public class MyHashMap {
    private int size = 0;
    private int tableSize = 8;
    private HashEntry[] table;

    MyHashMap() {
        clear();
    }

    MyHashMap(int tableSize) {
        this.tableSize = tableSize;
        clear();
    }

    int get(int key) {
        int index = getHashCode(key);
        HashEntry entry = table[index];

        if (entry == null) {
            throw new NoSuchElementException();
        }

        while (entry != null && entry.key != key) {
            entry = entry.next;
        }

        if (entry == null)
            throw new NoSuchElementException();
        else
            return entry.value;
    }

    void put(int key, int value) {
        int index = getHashCode(key);
        HashEntry newEntry = new HashEntry(key, value);

        if (table[index] == null) {
            table[index] = newEntry;
            size++;
            return;
        }

        HashEntry entry = table[index];
        HashEntry prevEntry = entry;

        while (entry != null && entry.key != key) {
            prevEntry = entry;
            entry = entry.next;
        }

        if (entry == null) {
            prevEntry.next = new HashEntry(key, value);
            size++;
        } else {
            entry.value = value;
        }
    }

    private int getHashCode(int key) {
        return (key & Integer.MAX_VALUE) % tableSize;
    }

    boolean containsKey(int key) {
        int index = getHashCode(key);
        HashEntry entry = table[index];

        if (entry == null) {
            return false;
        }

        while (entry != null && entry.key != key) {
            entry = entry.next;
        }

        return entry != null;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void clear() {
        table = new HashEntry[tableSize];
        size = 0;
    }

    int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < table.length; i++) {
            str.append("[").append(i).append("] ");
            HashEntry entry = table[i];

            while (entry != null) {
                str.append(entry);
                entry = entry.next;
            }
        }

        return str + "\n";
    }

    private class HashEntry {
        private int key;
        private int value;
        private HashEntry next;

        HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ") ";
        }
    }
}
