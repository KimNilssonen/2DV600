package kn222gp_assign2.exercise4;

public interface QueueInterface<E> extends Iterable<E> {

    int size();                          // current queue size 
    
    boolean isEmpty();                   // true if queue is empty
    
    void enqueue(E element);        // add element at end of queue
    
    E dequeue() throws IndexOutOfBoundsException;     // return and remove first element.
    
    E first() throws IndexOutOfBoundsException;       // return (without removing) first element
    
    E last() throws IndexOutOfBoundsException;        // return (without removing) last element
}
