class Node {
	Node next;
	int value;
	public Node (int value) {
		this.value = value;
	}
}

class EmptyStackException extends Exception {
}

public class Stack  {
	Node head = null;

	public void push (int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
	}

	public int pop () throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException();
		int toReturn = head.value;
		head = head.next;
		return toReturn;
	}

	public int peek () {
		return head.value;
	}

	public boolean isEmpty () {
		return (head == null);
	}

	public void sort() throws EmptyStackException {
		// use another stack in which all the elements are sorted
		// asscending at any moment
		Stack sorted = new Stack();

		while (!isEmpty()) {
			int headValue = pop();
			while (!sorted.isEmpty() && sorted.peek() > headValue) {
				push(sorted.pop());
			}
			sorted.push(headValue);
		}
		head = sorted.head;
	}

	public void print() throws EmptyStackException {
		while (!isEmpty())
			System.out.print(pop() + " ");
		System.out.println();
	}


	// Tests
	private static Stack pi() {
		Stack pi = new Stack();
		pi.push(3);
		pi.push(1);
		pi.push(4);
		pi.push(1);
		pi.push(5);
		return pi;
	}

	public static void main(String [] args) throws EmptyStackException {
		Stack pi = pi();
		pi.sort();
		pi.print();
	}
}
