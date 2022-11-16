package queue;

public class MyCircularQueue<T> implements IQueue<T> {

    private T[] elements;
    private int front;
    private int rear;
    private int maxSize;

    public MyCircularQueue(int size) {
        this.elements = (T[]) new Object[size + 1];
        this.front = 0;
        this.rear = 0;
        this.maxSize = size + 1;
    }

    @Override
    public void offer(T data) {
        if (isFull()) {
            throw new IllegalStateException();
        }

        this.rear = (this.rear + 1) % this.maxSize;
        this.elements[this.rear] = data;
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        this.front = (this.front + 1) % this.maxSize;
        return this.elements[this.front];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return this.elements[this.front + 1];
    }

    @Override
    public int size() {
        if (this.front <= this.rear) {
            return this.rear - this.front;
        }
        return this.maxSize - this.front + this.rear;
    }

    @Override
    public void clear() {
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    private boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;
    }
}
