package tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TreeTest {
    @Test
    public void basic() {
        ITree<Integer> given = new BinarySearchTree<>();
        given.insert(3);
        given.insert(1);
        given.insert(5);
        given.insert(4);
        given.insert(0);

        assertEquals(5, given.size());
        assertTrue(given.contains(0));
        assertTrue(given.contains(1));
        assertFalse(given.contains(2));
        assertTrue(given.contains(3));
        assertTrue(given.contains(4));
        assertTrue(given.contains(5));

        given.delete(5);
        given.delete(0);
        given.delete(-1);
        given.delete(10);
        assertEquals(3, given.size());
        assertFalse(given.contains(0));
        assertTrue(given.contains(1));
        assertFalse(given.contains(2));
        assertTrue(given.contains(3));
        assertTrue(given.contains(4));
        assertFalse(given.contains(5));
    }

    @Test
    public void inorder() {
        BinarySearchTree<Integer> given = new BinarySearchTree<>();
        given.insert(3);
        given.insert(1);
        given.insert(5);
        given.insert(4);
        given.insert(0);

        List<Integer> visited = given.inOrder();
        assertEquals(5, visited.size());
        assertEquals(List.of(0, 1, 3, 4, 5), visited);
    }

    @Test
    public void preorder() {
        BinarySearchTree<Integer> given = new BinarySearchTree<>();
        given.insert(3);
        given.insert(1);
        given.insert(5);
        given.insert(4);
        given.insert(0);

        List<Integer> visited = given.preOrder();
        assertEquals(5, visited.size());
        assertEquals(List.of(3, 1, 0, 5, 4), visited);
    }

    @Test
    public void postorder() {
        BinarySearchTree<Integer> given = new BinarySearchTree<>();
        given.insert(3);
        given.insert(1);
        given.insert(5);
        given.insert(4);
        given.insert(0);

        List<Integer> visited = given.postOrder();
        assertEquals(5, visited.size());
        assertEquals(List.of(0, 1, 4, 5, 3), visited);
    }

    @Test
    public void min() {
        BinarySearchTree<Integer> given = new BinarySearchTree<>();
        given.insert(3);
        given.insert(1);
        given.insert(5);
        given.insert(4);
        given.insert(0);
        given.insert(-1);

        assertEquals(-1, given.min());
    }

    @Test
    public void max() {
        BinarySearchTree<Integer> given = new BinarySearchTree<>();
        given.insert(3);
        given.insert(1);
        given.insert(5);
        given.insert(4);
        given.insert(0);
        given.insert(10);
        given.insert(15);

        assertEquals(15, given.max());
    }
}
