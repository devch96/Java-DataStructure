package tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TrieTest {
    @Test
    public void basic() {
        Trie t = new Trie();
        t.add("HelloFoobar");
        t.add("HelloWorld");
        t.add("WorldHello");
        t.add("WorldFoobar");

        assertTrue(t.contains("HelloFoobar"));
        assertTrue(t.contains("HelloWorld"));
        assertTrue(t.contains("WorldHello"));
        assertTrue(t.contains("WorldFoobar"));

        assertFalse(t.contains("HelloFoo"));
        assertFalse(t.contains("HelloWorl"));
        assertFalse(t.contains("World"));
        assertFalse(t.contains("WorldFoobar1234"));

        List<String> prefix = t.findPrefix("Hello");
        assertEquals(2, prefix.size());
        assertEquals("HelloWorld", prefix.get(0));
        assertEquals("HelloFoobar", prefix.get(1));
    }
}
