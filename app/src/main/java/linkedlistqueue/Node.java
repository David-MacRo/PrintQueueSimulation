package linkedlistqueue;
class Node<E> {
    private Node<E> next;
    private Node<E> previous;
    private E data;

    protected Node(Node<E> previous, E data){
        next = null;
        this.previous = previous;
        this.data = data;
        if(this.previous != null) this.previous.linkTo(this);
    }
    
    private void linkTo(Node<E> next){
        this.next = next;
    }

    protected Node<E> getNext(){
        return next;
    }
    protected Node<E> getPrevious(){
        return previous;
    }
    protected E getData(){
        return data;
    }

    //helps garbage-collector destroy linked nodes.
    protected void destruct(){
        next = null;
        previous = null;
        data = null;
    }
}
