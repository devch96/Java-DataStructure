package list;

public class MyLinkedList<T> implements IList<T>{

    private int size;
    private Node head;

    public MyLinkedList(){
        this.size=0;
        this.head = new Node(null); // dummy head node
    }
    private class Node{
        T data;
        Node next;
        Node(T data){
            this.data = data;
        }

        Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void add(T t) {
        Node curr = this.head;
        while(curr.next != null){
            curr = curr.next;
        }
        Node node = new Node(t);
        curr.next = node;
        this.size++;
    }

    @Override
    public void insert(int index, T t) {
        Node prev = this.head;
        Node curr = prev.next;
        int i = 0;
        while(i++<index){
            prev = prev.next;
            curr = curr.next;
        }
        Node node = new Node(t, curr);
        prev.next=node;
        this.size++;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head.next = null;
    }

    @Override
    public boolean delete(T t) {
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(T t) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T t) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
