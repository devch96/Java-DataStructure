package hashtable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MyHashTableTest {
    @Test
    public void put() {
        IHashTable<String, Integer> given = new MyLinkedHashTable<>(3);
        given.put("hello", 1);
        given.put("world", 3);
        given.put("korea", 10);
        given.put("awesome", 5);
        given.put("data", 3);
        given.put("hard", 111);

        assertEquals(6, given.size());
        assertTrue(given.contains("hello"));
        assertEquals(1, given.get("hello"));
        assertTrue(given.contains("world"));
        assertEquals(3, given.get("world"));
        assertTrue(given.contains("korea"));
        assertEquals(10, given.get("korea"));
        assertTrue(given.contains("awesome"));
        assertEquals(5, given.get("awesome"));
        assertTrue(given.contains("data"));
        assertEquals(3, given.get("data"));
        assertTrue(given.contains("hard"));
        assertEquals(111, given.get("hard"));
    }

    @Test
    public void delete() {
        IHashTable<String, Integer> given = new MyLinkedHashTable<>(3);
        given.put("hello", 1);
        given.put("world", 3);
        given.put("korea", 10);
        given.put("awesome", 5);
        given.put("data", 3);
        given.put("hard", 111);

        assertEquals(6, given.size());
        given.delete("world");
        assertEquals(5, given.size());
        assertTrue(given.contains("hello"));
        assertEquals(1, given.get("hello"));
        assertFalse(given.contains("world"));
        assertEquals(null, given.get("world"));
        assertTrue(given.contains("korea"));
        assertEquals(10, given.get("korea"));
        assertTrue(given.contains("awesome"));
        assertEquals(5, given.get("awesome"));
        assertTrue(given.contains("data"));
        assertEquals(3, given.get("data"));
        assertTrue(given.contains("hard"));
        assertEquals(111, given.get("hard"));
    }

    @Test
    public void update() {
        IHashTable<String, Integer> given = new MyLinkedHashTable<>(3);
        given.put("hello", 1);
        given.put("world", 3);
        given.put("korea", 10);
        given.put("awesome", 5);
        given.put("data", 3);
        given.put("hard", 111);

        assertEquals(6, given.size());
        assertTrue(given.contains("hello"));
        assertEquals(1, given.get("hello"));
        assertTrue(given.contains("world"));
        assertEquals(3, given.get("world"));
        assertTrue(given.contains("korea"));
        assertEquals(10, given.get("korea"));
        assertTrue(given.contains("awesome"));
        assertEquals(5, given.get("awesome"));
        assertTrue(given.contains("data"));
        assertEquals(3, given.get("data"));
        assertTrue(given.contains("hard"));
        assertEquals(111, given.get("hard"));

        given.put("data", 95);
        given.put("hard", 0);
        assertTrue(given.contains("data"));
        assertEquals(95, given.get("data"));
        assertTrue(given.contains("hard"));
        assertEquals(0, given.get("hard"));
        assertEquals(6, given.size());
    }
}
