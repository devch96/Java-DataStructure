package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MyLinkedQueueTest {

    @Test
    public void basic() {
        IQueue<Integer> given = new MyLinkedQueue<>();
        assertEquals(given.size(), 0);
        assertTrue(given.isEmpty());

        for (int i = 0; i < 10; i++) {
            given.offer(i);
            assertEquals(given.size(), i + 1);
        }

        for (int i = 0; i < 10; i++) {
            int currentSize = given.size();
            int peek = given.peek();
            assertEquals(given.size(), currentSize);
            assertEquals(peek, i);
            int poll = given.poll();
            assertEquals(peek, poll);
            assertEquals(given.size(), currentSize - 1);
        }

        assertEquals(given.size(), 0);
        assertTrue(given.isEmpty());
    }

    @Test
    public void offer_remove_offer() {
        IQueue<Integer> given = new MyLinkedQueue<>();
        assertEquals(given.size(), 0);
        assertTrue(given.isEmpty());

        for (int i = 0; i < 10; i++) {
            given.offer(i);
            assertEquals(given.size(), i + 1);
        }

        for (int i = 0; i < 10; i++) {
            given.poll();
        }

        for (int i = 10; i < 20; i++) {
            given.offer(i);
        }

        for (int i = 10; i < 20; i++) {
            int peek = given.peek();
            assertEquals(peek, i);
            assertEquals(peek, given.poll());
        }

        assertEquals(given.size(), 0);
        assertTrue(given.isEmpty());
    }

    @Test
    public void clear() {
        IQueue<Integer> given = new MyLinkedQueue<>();
        assertEquals(given.size(), 0);
        assertTrue(given.isEmpty());

        for (int i = 0; i < 10; i++) {
            given.offer(i);
            assertEquals(given.size(), i + 1);
        }

        given.clear();
        assertEquals(given.size(), 0);
        assertTrue(given.isEmpty());
        assertThrows(IllegalStateException.class, given::poll);
        assertThrows(IllegalStateException.class, given::peek);
    }
}
