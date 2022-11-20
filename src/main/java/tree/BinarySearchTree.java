package tree;


import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements ITree<T> {

    private Node root;
    private int size;

    private class Node{
        T data;
        Node left;
        Node right;

        Node(T data) {
            this.data = data;
        }
        Node(T data, Node left , Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public BinarySearchTree() {
        this.size = 0;
    }

    private T minNode(Node node) {
        T minData = node.data;
        while(node.left != null){
            minData = node.left.data;
            node = node.left;
        }
        return minData;
    }

    private T maxNode(Node node){
        T maxData = node.data;
        while(node.right != null){
            maxData = node.right.data;
            node = node.right;
        }
        return maxData;
    }

    public T min() {
        return this.minNode(this.root);
    }

    public T max() {
        return this.maxNode(this.root);
    }

    private Node insertNode(Node node, T val){
        if(node == null){
            return new Node(val);
        }
        if(val.compareTo(node.data) < 0 ){
            node.left = insertNode(node.left, val);
        } else if(val.compareTo(node.data) > 0) {
            node.right = insertNode(node.right, val);
        }
        return node;
    }

    @Override
    public void insert(T val) {
        this.root = this.insertNode(this.root, val);
        this.size++;
    }

    private Node deleteNode(Node node, T val){
        if(node == null) return null;
        if (val.compareTo(node.data) < 0 ){
            node.left = deleteNode(node.left, val);
        } else if (val.compareTo(node.data) > 0 ) {
            node.right = deleteNode(node.right, val);
        } else{
            this.size--;
            if(node.left == null){
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.data = this.minNode(node.right);
            node.right = deleteNode(node.right, node.data);
        }
        return node;
    }
    @Override
    public void delete(T val) {
        this.deleteNode(this.root,val);
    }

    private boolean containsNode(Node node, T val){
        if(node == null){
            return false;
        }
        if (val.compareTo(node.data) == 0){
            return true;
        }

        if(val.compareTo(node.data) < 0){
            return containsNode(node.left, val);
        }

        return containsNode(node.right, val);
    }

    @Override
    public boolean contains(T val) {
        return this.containsNode(this.root, val);
    }

    @Override
    public int size() {
        return this.size;
    }
    private List<T> preorderTree(Node node, List<T> visited){
        if (node == null) return visited;
        visited.add(node.data);
        preorderTree(node.left, visited);
        preorderTree(node.right, visited);

        return visited;
    }

    private List<T> inorderTree(Node node, List<T> visited){
        if (node == null) return visited;
        inorderTree(node.left, visited);
        visited.add(node.data);
        inorderTree(node.right, visited);
        return visited;
    }

    private List<T> postorderTree(Node node, List<T> visited){
        if(node == null) return visited;
        postorderTree(node.left, visited);
        postorderTree(node.right, visited);
        visited.add(node.data);
        return visited;
    }

    public List<T> preOrder() {
        return this.preorderTree(root, new ArrayList<>());
    }

    public List<T> inOrder() {
        return this.inorderTree(root, new ArrayList<>());
    }

    public List<T> postOrder() {
        return this.postorderTree(root, new ArrayList<>());
    }
}
