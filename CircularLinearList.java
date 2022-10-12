/**
 * 
 * @author SagingConYelo
 *
 * @param <E>
 * 
 * I got it :o
 * 
 * Btw, sir, I think mali po yung output sa baba
 */
public class CircularLinearList<E> {
	
	private Node first = null;
	private Node last = null;
	private Node temp = null;
	private int length;	
	
//insert needed instances here
	
	//this method should print the elements of the list from left to right
	public String toString() {
		
		Node temp = first; 
		String str = "";
		
		if (first == null) {
			System.out.println("Your list is empty");
			return null;
		}
		
		do {
			//System.out.print(temp.getKey() + " ");
			str = str + temp.getKey() + " ";
			temp = temp.getNext();
		}while (temp != last);
		
		//System.out.print(temp.getKey());
		str = str + temp.getKey();
		
		//complete this method
		return str;
	}

	public void leftInsert(E key) {
		Node node = new Node(key);
		
		if (first == null) {
			this.first = this.last = node;
			this.length += 1;
			this.first.setNext(last);
			this.last.setNext(first);
			return;
		}
		
		node.setNext(first);
		
		this.first = node;
		
		last.setNext(first);
		this.length += 1;
		//complete this method
	}
	
	public void rightInsert(E key) {
		Node node = new Node(key);
		
		if (first == null) {
			this.first = this.last = node;
			this.length += 1;
			this.first.setNext(last);
			this.last.setNext(first);
			return;
		}
		
		this.last.setNext(node);
		this.last = node;
		this.last.setNext(first);
		this.length += 1;
		//complete this method
	}
	
	public E deleteLeft() throws QueueEmptyExceptions{
		if (first == null) {
			throw new QueueEmptyExceptions("Your list is empty");
		}
		
		String stemp = first.getKey().toString();
		
		this.first = first.getNext();
		this.last.setNext(first);
		
		//complete this method
		return (E) stemp;
	}

	public E deleteRight() throws QueueEmptyExceptions{
		
		if (last == null) {
			throw new QueueEmptyExceptions("Your list is empty");
		}
		
		String stemp = last.getKey().toString();
		
		if (first != last) {
			Node temp = first;
			while(temp.getNext() != last) {
				temp = temp.getNext();
			}
			
			this.last = temp;
			this.last.setNext(first);
		}
		
		//complete this method
		return (E) stemp;
	}
	
	
	public static void main(String[] args) throws QueueEmptyExceptions{
		
		
		CircularLinearList<String> list = new CircularLinearList<String>();
		list.leftInsert("Hello");
		list.rightInsert("World");
		
		System.out.println(list);
		//Should print : (Hello, World)
		
		list.leftInsert("Computer");
		list.rightInsert("Science");
		
		System.out.println(list.deleteLeft()); 
		//Should print : Computer
		
		list.deleteRight();
		System.out.println(list);
		//Should print : Science
		
		
	}

}
