package DataStructures.DepthFirstSearch;

public class QueueNode<T> {
    private T data;
    private QueueNode<T> next;

    public QueueNode() {
    }

    public QueueNode(T data) {
        this.data = data;
        this.next = null;
    }

    public QueueNode(T data, QueueNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public QueueNode<T> getNext() {
        return this.next;
    }

    public void setNext(QueueNode<T> next) {
        this.next = next;
    }

    public QueueNode<T> data(T data) {
        setData(data);
        return this;
    }

    public QueueNode<T> next(QueueNode<T> next) {
        setNext(next);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " data='" + getData() + "'" +
            ", next='" + getNext() + "'" +
            "}";
    }

}
