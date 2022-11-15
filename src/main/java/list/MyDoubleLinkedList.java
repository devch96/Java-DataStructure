package list;

public class MyDoubleLinkedList<T> implements IList<T>{

    private Node head;
    private Node tail;
    private int size;

    public MyDoubleLinkedList() {
        this.size = 0;
        this.head = new Node(null);
        this.tail = new Node(null);
        this.head.next = tail;
        this.tail.prev = head;
    }
    private class Node{
        T data;
        Node prev;
        Node next;
        Node(T data) {
            this.data = data;
        }
        Node(T data, Node prev, Node next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    @Override
    public void add(T t) {
        Node last = this.tail.prev;
        Node node = new Node(t, last, tail);
        last.next = node;
        this.tail.prev = node;
        this.size++;
    }

    @Override
    public void insert(int index, T t) {

    }

    @Override
    public void clear() {
        this.size=0;
        this.head = new Node(null);
        this.tail = new Node(null);
        this.head.next = tail;
        this.tail.prev = head;
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
        if(index >= this.size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        Node curr = null;
        if (index < this.size / 2) { // index 가 head 에 더 가까움
            curr = this.head.next;
            while(i++<index){
                curr = curr.next;
            }
        }else{ // index 가 tail 에 더 가까움
            curr = this.tail.prev;
            while(i++<this.size-index-1){
                curr = curr.prev;
            }
        }
        return curr.data;
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
        return this.size;
    }
}
