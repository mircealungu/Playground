class Node {
	int value;
	Node next;
	public Node (int value) {
		this.value= value;
	}
}

class EmptyQueueException extends Exception {
}

public class Queue {
	Node head = null;
	Node tail = null;
	
	public void enqueue (int value) {
		Node newNode = new Node (value);
		if (head == null && tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	public int dequeue () throws EmptyQueueException {
		if (head == null && tail == null) 
			throw new EmptyQueueException(); 
		int tailValue = tail.value;
		
		if (head == tail ) {
			head = null;
			tail = null;
			return tailValue;
		}
		
		Node newTail = head;
		while (newTail.next != tail) 
			newTail = newTail.next;
		tail = newTail;
		return tailValue;
	}
	
	public boolean isEmpty () {
		return (head == null && tail == null);
	}
	
	public void print() {
		Node iter = head;
		while (iter != tail) {
			System.out.println(iter.value + " ");
			iter = iter.next;
		}
		System.out.println(iter.value + " ");
		
	}
	
	private static Queue pi () {
		Queue pi = new Queue ();
		pi.enqueue(3);
		pi.enqueue(1);
		pi.enqueue(4);
		pi.enqueue(1);
		pi.enqueue(5);
		return pi;
	}
	
	public static void main (String [] args) throws EmptyQueueException {
		Queue pi = pi();
		pi.print();	
		while (!pi.isEmpty())
			System.out.println(pi.dequeue() + " ");
	}
}
