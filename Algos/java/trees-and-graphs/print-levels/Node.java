import java.util.*;

public class Node {
	Node left;
	Node right;
	int value;
	public Node (int value) {
		this.value = value;
	}
	
	// a tree with three levels
	public static Node exampleTree() {
		Node one = new Node (1);
		Node two = new Node (2);
		Node three = new Node (3);
		Node four = new Node (4);
		Node five = new Node (5);
		one.left = two;
		one.right = three;
		three.left = four;
		two.right = five;
		return one;
	}
	
	public ArrayList<LinkedList<Node>> nodesByLevel () {
		int levelCount = 0;
		LinkedList <Node> level = new LinkedList <Node>();
		ArrayList <LinkedList<Node>> levels = new ArrayList <LinkedList <Node>> () ;
		level.add(this);
		levels.add(levelCount, level);
		while (true) {
			System.out.println("working on level " + levelCount);
			level = new LinkedList <Node> ();
			for (Node eachNode: levels.get (levelCount)) {
				if (eachNode.left != null) level.add(eachNode.left);
				if (eachNode.right != null) level.add(eachNode.right);
			}		
			if (level.isEmpty())
				break;
			levelCount = levelCount +1;
			levels.add(levelCount, level);
		}
		return levels;
	}
	
	public static void main (String [] args) {
		Node root = exampleTree ();
		for (LinkedList<Node> level: root.nodesByLevel()) {
			for (Node node: level)
				System.out.print (node.value + " ");
			System.out.println();
		}
	}
}
