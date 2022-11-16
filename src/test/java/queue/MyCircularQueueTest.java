package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MyCircularQueueTest {
    @Test
    public void basic() {
        IQueue<Integer> given = new MyCircularQueue<>(30);
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
    public void offer_too_much() {
        IQueue<Integer> given = new MyCircularQueue<>(30);
        for (int i = 0; i < 30; i++) {
            given.offer(i);
            assertEquals(i + 1, given.size());
        }
        assertThrows(IllegalStateException.class, () -> given.offer(100));
    }

    @Test
    public void offer_remove_offer() {
        IQueue<Integer> given = new MyCircularQueue<>(30);
        assertEquals(given.size(), 0);
        assertTrue(given.isEmpty());

        for (int i = 0; i < 10; i++) {
            given.offer(i);
            assertEquals(given.size(), i + 1);
        }

        for (int i = 0; i < 10; i++) {
            int ret = given.poll();
            assertEquals(i, ret);
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
        IQueue<Integer> given = new MyCircularQueue<>(30);
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
