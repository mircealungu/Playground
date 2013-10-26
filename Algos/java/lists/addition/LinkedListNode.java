public class LinkedListNode {
	int value;
	LinkedListNode next;
	
	public LinkedListNode (int value) {
		next = null;
		this.value = value;
	}
	public void append (LinkedListNode next) {
		this.next = next;
	}
	public LinkedListNode plus (LinkedListNode op2) {
		// op1 number is longer than the second
		//  1.2 + 9.4.5
		LinkedListNode op1 = this;

		if (op1 == null || op2 == null) 
		{
			System.out.println("invalid format for one the numbers");
			System.exit(1);
		}

		LinkedListNode result = 
new LinkedListNode ((op1.value+op2.value) % 10);
		int carry = (int) (op1.value + op2.value) / 10;

LinkedListNode currentDigit = result;
		op1 = op1.next;
		op2 = op2.next;

		while (op1 != null && op2 !=null) {
			LinkedListNode nextcurrentDigit =
new LinkedListNode((op1.value + op2.value + carry) % 10);
			carry = (int) (op1.value + op2.value + carry ) / 10;
			currentDigit.append(nextcurrentDigit);
			currentDigit = nextcurrentDigit;
	op1 = op1.next;
			op2 = op2.next;
		}

		while (op1 != null) {
			LinkedListNode nextcurrentDigit =
new LinkedListNode((op1.value + carry) % 10);
			carry = (int) (op1.value + carry) / 10;
			currentDigit.append(nextcurrentDigit);
			currentDigit = nextcurrentDigit;
			op1 = op1.next;
		}
		
while (op2 != null) {
			LinkedListNode nextcurrentDigit =
new LinkedListNode((op2.value + carry) % 10);
			carry = (int) (op2.value + carry) / 10;
			currentDigit.append(nextcurrentDigit);
			currentDigit = nextcurrentDigit;
			op2 = op2.next;
		}
		if (carry != 0) {
			LinkedListNode finalCarry = new LinkedListNode (1);
			currentDigit.append (finalCarry);
		}
		return result;		
	}

	public void print() {
		LinkedListNode iter = this;
		while (iter != null) {
			System.out.print("" + iter.value);
			iter = iter.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedListNode one = example1();
		one.plus(one).print();
	}

	public static LinkedListNode example1() {
		LinkedListNode op1 = new LinkedListNode(1);
		LinkedListNode second = new LinkedListNode(5);
		LinkedListNode third = new LinkedListNode(8);
		op1.append (second);
		second.append(third);
		return op1;
	}
}
