import java.util.*;

/*


1 6 9 4 88 22 55 10

partition
1 6 9 4 

1 4 9 6

5 6 7 1 4
pivot 4
ilarger = 1
ipivot = 4

…

i = 5
swap list(i) list (ilarge)
1 6 7 5 4
ilarge = 2



*/
public class QuickSort {

	ArrayList <Integer> list;
	
	public static ArrayList <Integer> example1() {
		ArrayList <Integer> example = new ArrayList<Integer>();
		example.add(1);
		example.add(6);
		example.add(9);
		example.add(5);
		example.add(4);
		example.add(12);
		example.add(27);
		example.add(17);
		example.add(70);
		example.add(57);
		example.add(7);
		return example;
	}

	public static void main(String[] args)
	{
		QuickSort qs = new QuickSort(example1());
		qs.print("the sorted list is");
	}
	public void print (String message)
	{	
		System.out.println(message);
		for (int i = 0; i < list.size(); i++)
			{
				System.out.print(list.get(i));
				System.out.print(" ");
			}
		System.out.println();
	}
	public ArrayList <Integer> getsList() {
		return list;
	}

	public QuickSort (ArrayList<Integer> list)
	{
		this.list = list;
		quicksort(list, 0, list.size()-1);
	}

	/* 
		returns a sorted list 
	*/
	private void quicksort (ArrayList<Integer> list, int left, int right)
	{
		if (left < right)
		{
			int pindex = partition (list, left, right);
			quicksort (list, left, pindex - 1);
			quicksort (list, pindex + 1, right);
		}

	}

	/* 
		partitions the list with respect to the pivot 
		specified by pindex
		to the left the smaller elements, to the right
		the larger elements
	*/
	private int partition (ArrayList<Integer> list, int ileft, int iright)
	{
		int pivot = list.get(iright); // get value of pivot
		int ileftmostlarge = ileft; // starting of the large partition of the array

		// if i find something which is smaller i swap it 
		for (int i = ileft; i < iright; i++)
		{
			if (pivot > list.get(i)) { // found an element smaller than the pivot
				swap(list, i, ileftmostlarge);
				ileftmostlarge = ileftmostlarge + 1;
			}
		}
		swap (list, ileftmostlarge, iright);
		return ileftmostlarge;		
	}

	private void swap (ArrayList<Integer> list, int i, int j)
	{
		int aux = list.get(i);
		list.set(i, list.get(j));
		list.set(j, aux);
	}
}