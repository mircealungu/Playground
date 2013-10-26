import java.util.*;

enum State { VISITED, NOT_VISITED }

class Node {
	String name;
	LinkedList <Node> neighbours;
	State state;
	public Node (String name) {
		this.name = name;
		neighbours = new LinkedList <Node> ();
	}
	
	public LinkedList <Node> neighbours () {
		return neighbours;
	}
	
	public void addNeighbour (Node neighbour ) {
		neighbours.add(neighbour);
	}
}

public class Graph {
	LinkedList <Node> nodes = new LinkedList <Node> ();
	
	public static Graph switzerland () {
		Node zurich = new Node ("Zurich");
		Node lugano = new Node ("Lugano");
		Node bern = new Node ("Bern");
		Node geneva = new Node ("Geneva");
		Node milano = new Node ("Milano");
		Node torino = new Node ("Torino");
		milano.addNeighbour (lugano);
		lugano.addNeighbour (milano);
		lugano.addNeighbour (zurich);
		zurich.addNeighbour(bern);
		zurich.addNeighbour(lugano);
		bern.addNeighbour(zurich);
		bern.addNeighbour(geneva);
		geneva.addNeighbour(bern);
		
		Graph switzerland = new Graph ();
		switzerland.addNode(zurich);
		switzerland.addNode(geneva);
		switzerland.addNode(bern);
		switzerland.addNode(milano);
		switzerland.addNode(lugano);
		switzerland.addNode(torino);
		return switzerland;
	}

	public void addNode (Node node) {
		nodes.add(node);
	}

	public Node nodeNamed (String nodeName ) {
		for (Node each: nodes) 
			if (each.name.equals (nodeName) )
				return each;
		return null;
	}
	
	public boolean pathExistsBetween (String from, String to) {
		LinkedList <Node> q = new LinkedList <Node> ();
		q.addFirst(nodeNamed(from));
		
		for (Node n: this.nodes) {
			n.state = State.NOT_VISITED;
		}
		
		while (!q.isEmpty()) {
			Node cur = q.removeFirst();
			cur.state = State.VISITED;
			if (cur == nodeNamed(to)) return true;
			for (Node each: cur.neighbours()) {
				if (each.state == State.NOT_VISITED)
					q.addFirst (each);
			}
		}
		return false;
	}

	public static void main ( String [] args ) {
		Graph ch = switzerland ();
		// Tests
		System.out.println("bern-bern: " + ch.pathExistsBetween ("Bern", "Bern"));
		System.out.println("bern-lugano: " + ch.pathExistsBetween ("Bern", "Lugano"));
		System.out.println("bern-torino: " + ch.pathExistsBetween ("Bern", "Torino"));
	}
}
