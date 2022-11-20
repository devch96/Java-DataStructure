package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Trie {

    private Node root = new Node();

    public void add(String data) {
        Node current = this.root;
        for (Character ch : data.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                current.children.put(ch, new Node());
            }
            current = current.children.get(ch);
        }
        current.data = data;
    }

    public List<String> findPrefix(String prefix) {
        Node current = this.root;
        for (Character ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return List.of();
            }
            current = current.children.get(ch);
        }

        List<String> ret = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(current);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.data != null) {
                ret.add(node.data);
            }
            for (Character nn : node.children.keySet()) {
                q.add(node.children.get(nn));
            }
        }
        return ret;
    }

    public boolean contains(String data) {
        Node current = this.root;
        for (Character ch : data.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }
        return data.equals(current.data);
    }

    private class Node {
        private String data;
        private Map<Character, Node> children;

        public Node() {
            this.data = null;
            this.children = new TreeMap<>();
        }

        public Node(String data) {
            this.data = data;
            this.children = new TreeMap<>();
        }
    }
}
