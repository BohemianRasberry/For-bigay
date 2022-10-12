import java.util.Collection;

/**
 * 
 * @author SagingConYelo
 * @param <E>
 *
 * @param <E>
 * 
 * Dear UPM,
 *      This is me trying :'>>
 */

public class Linked_Queue<E> implements Queue<E>{
	
	public Node front = null;
	public Node rear = null;
	public int length = 0;
	
	public Linked_Queue() {
		
	}
		
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		if (front == null) {
			return true;
		}
		
		return false;
	}
	
	public E front() throws QueueEmptyExceptions{
		if (front == null) {
			throw new QueueEmptyExceptions("Your queue is empty");
		}
		
		return (E) this.front.getKey();
	}
	
	public void enqueue(E element) {
		Node temp = new Node(element);
		
		if (rear == null) {
			this.front = this.rear = temp;
			this.length += 1;
			return;
		}
		this.rear.setNext(temp);
		
		this.rear = temp;
		
		this.length += 1;
		System.out.println(this.length);
	}
	
	public void dequeue() throws QueueEmptyExceptions{
		
		if (front == null) {
			throw new QueueEmptyExceptions("Your queue is empty");
		}
		
		this.front = this.front.getNext();
		
		this.length -= 1;
		System.out.println(this.length);
		
	}


}
