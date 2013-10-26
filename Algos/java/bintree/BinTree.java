import java.util.*;

public class BinTree implements Comparable {
	BinTree left, right;
	BinTree parent;
	int value;

	public int compareTo (Object other)
	{
		return (value - ((BinTree)other).value());
	}
	public BinTree right() {
		return right;
	}
	public BinTree left() {return left;};
	public int value() {return value;};

	public void printInOrder() {
		Queue <BinTree> toVisit = new LinkedList <BinTree> ();

		toVisit.add(this);
		while (!toVisit.isEmpty())
		{
			BinTree head = toVisit.remove();
			if (head.left() != null)
				toVisit.add(head.left());
			if (head.right()!= null)
				toVisit.add(head.right());
			System.out.print(head.value() + " " );

			if (head.isARightChild())
				System.out.println("");
		}

	}

	// all my parents are
	// the right
	// children... then i
	// am the last on the
	// level
	public boolean isARightChild()
	{
		if (parent == null) 
			return true;
		if ((parent.right() == this) && (parent.isARightChild()))
			return true;
		return false;
	}


	private int level()
	{
		if (parent == null)
			return 0;
		return 1 + parent.level();

	}

	public BinTree (int value)
	{
		this.value = value;
	}

	public BinTree (int value, BinTree left, BinTree right)
	{
		this.value = value;
		this.left = left;
		this.right = right;
		left.parent = this;
		right.parent = this;
	}

	public static BinTree example () {
		BinTree five2 = new BinTree (52);
		BinTree eight = new BinTree (8);
		BinTree six= new BinTree (6);
		BinTree nine = new BinTree (9, six, eight);
		BinTree three= new BinTree (3);
		BinTree four = new BinTree (4, three, five2);
		BinTree root = new BinTree (5, four, nine);
		System.out.println(nine.isARightChild());
		return root;
	}

	public static void main(String[] args)
	{
		BinTree example = example();
		example.printInOrder();
		
	}

}

