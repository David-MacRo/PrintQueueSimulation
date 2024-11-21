package linkedlistqueue;
public class LinkedListQueue<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    public LinkedListQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(E element){
        if(size == 0){
            head = new Node<E>(null, element);
            tail = head;
        }else{
            tail = new Node<E>(tail,element);
        }
        size++;
    }

    public E deque(){
        if(size == 0){
            throw new IllegalStateException("The queue is empty");
        }else{
            E output = head.getData();
            head = head.getNext();
            if(head != null && head.getPrevious() != null)
                head.getPrevious().destruct();
            size--;
            return output;
        }
    }
    public int size(){
        return size;
    }
}
