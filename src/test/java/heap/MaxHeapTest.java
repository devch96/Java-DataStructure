package heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MaxHeapTest {
    @Test
    public void basic() {
        IHeap<Integer> given = new MaxHeap<>(300);
        given.insert(3);
        given.insert(1);
        given.insert(5);
        given.insert(4);
        given.insert(0);

        assertTrue(given.contains(0));
        assertTrue(given.contains(1));
        assertFalse(given.contains(2));
        assertTrue(given.contains(3));
        assertTrue(given.contains(4));
        assertTrue(given.contains(5));

        assertEquals(5, given.size());
        assertEquals(5, given.pop());
        assertEquals(4, given.pop());
        assertEquals(3, given.pop());
        assertEquals(1, given.pop());
        assertEquals(0, given.pop());
    }
}
