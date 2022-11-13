package list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

class MyArrayListTest {
    @Test
    public void add() {
        IList<Integer> given = new MyArrayList<>();
        for (int i = 0; i < 50; i++) {
            given.add(i);
            assertEquals(i + 1, given.size());
            assertEquals(i, given.get(i));
        }
    }

    @Test
    public void clear() {
        IList<Integer> given = new MyArrayList<>();
        for (int i = 0; i < 100; i++) {
            given.add(i);
        }
        assertEquals(100, given.size());
        assertFalse(given.isEmpty());
        given.clear();
        assertEquals(0, given.size());
        assertTrue(given.isEmpty());
    }

    @Test
    public void deleteByIndex() {
        IList<Integer> given = new MyArrayList<>();
        for (int i = 0; i < 100; i++) {
            given.add(i);
        }
        Random random = new Random();
        int givenIndex = random.nextInt(99);
        int expected = given.get(givenIndex + 1);
        given.deleteByIndex(givenIndex);
        assertEquals(expected, given.get(givenIndex));
    }

    @Test
    public void delete() {
        IList<Integer> given = new MyArrayList<>();
        for (int i = 0; i < 100; i++) {
            given.add(i);
        }
        Random random = new Random();
        Integer target = random.nextInt(99);
        assertEquals(100, given.size());
        assertTrue(given.contains(target));
        assertEquals(target, given.indexOf(target));
        given.delete(target);
        assertEquals(99, given.size());
        assertFalse(given.contains(target));
        assertEquals(-1, given.indexOf(target));
    }
}
