import java.util.*;

public class MinHeap {
	ArrayList <Integer> list;

	public static MinHeap example1 () {
		MinHeap heap = new MinHeap ();
		heap.insert (100);
		heap.insert (20);
		heap.insert (13);
		heap.insert (7);
		heap.insert (90);
		heap.insert (10);
		heap.insert (11);
		heap.insert (110);
		heap.insert (1000);
		return heap;
	}

	public static void main (String [] args) {
		MinHeap heap = example1();

		while (!heap.isEmpty())
			heap.printExtractRoot();
	}

	public MinHeap ()
	{
		list = new ArrayList <Integer> ();
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

	public Integer root()
	{
		return list.get(0);
	}

	public void printExtractRoot() {
		System.out.print("Extracting... ");
		System.out.println(extractRoot());
		System.out.print("What remains: ");
		print();
	}

	public Integer extractRoot()
	{
		int root = root();//save the root

		Integer last = list.get(list.size()-1); //save the last
		list.remove(list.size()-1); //remove the last

		if (isEmpty())
			return root;

		list.set(0,last);//replace the root
		bubble_down(0);
		return root;
	}

	public void insert (Integer elem)
	{
		/* 
		 * Example:
		 * inserting
		 * 13 in 
		 * 5 70 10 9
		 * results in
		 *
		 * bubble down 5 90 10 9 13
		 * and ten bubble up
		 5 13 10 9 90 
		 */
		list.add(elem);
		bubble_up(list.size()-1);
		print();
	}

	public void print () {
		for (int i = 0; i < list.size(); i++) {
			System.out.print (list.get(i));
			System.out.print (" ");
		}
		System.out.println();
	}

	private int first_child_index(int position)
	{
		return position * 2 + 1;
	}
	/* test whether the
	 * element can be
	 * inserted at
	 * position, and if
	 * not try to insert
	 * at double the
	 * position */
	private void bubble_down (int position) {
		Integer elem = list.get(position);
		int dominant_idx = -1;
		Integer min = elem;
		
		for (int i = first_child_index(position); i<= first_child_index(position) + 1; i++)
			if (i < list.size())
				if (list.get(i) < min)
				{
					dominant_idx = i;
					min = list.get(i);
				}
				
		if (min != elem)
		{	
			swap(dominant_idx, position);
			bubble_down(dominant_idx);
		}
	}

	private void swap (int i, int j) {
		int aux;
		aux = list.get (i);
		list.set(i, list.get(j));
		list.set(j, aux);
	}

	private void bubble_up (int position) {
		if (position >= 1) {
			int iparent = position / 2;
			if (list.get(position) < list.get(iparent)) {
				swap(position, iparent);
				bubble_up(iparent);
			}
		}
	}
}

