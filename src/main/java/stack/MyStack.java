package stack;

public class MyStack<T> implements IStack<T>{

    private Node head;
    private int size;

    public MyStack(){
        this.size = 0;
        this.head = new Node(null);
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
    public void push(T data) {
        Node node = new Node(data, this.head.next);
        this.head.next = node;
        this.size++;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            return null;
        }
        Node curr = this.head.next;
        this.head.next = curr.next;
        curr.next = null;
        this.size--;
        return curr.data;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            return null;
        }
        return this.head.next.data;
    }

    private boolean isEmpty() {
        return this.head.next == null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
