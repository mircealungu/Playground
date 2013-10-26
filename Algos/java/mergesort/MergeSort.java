import java.util.*;

public class MergeSort {
	ArrayList <Integer> list;
	public static ArrayList <Integer> exampleList1()
	{
		ArrayList <Integer> example = new ArrayList <Integer>();
		example.add(10);
		example.add(8);
		example.add(11);
		example.add(3);
		example.add(410);
	}
	public static void main (String [] args) {
		MergeSort sorter = new MergeSort (exampleList1());
		sorter.print();
		}

	public MergeSort (ArrayList<Integer> list) {
		this.list = list;
		mergeSort(list, 0, list.size() - 1);
	}

	public mergeSort(ArrayList <Integer> list, int left, int right)
	{
		if (left < right) {
			int middle = list.size() / 2;
			mergeSort(list, left, middle);
			mergeSort(list, middle+1, right);
			merge(list, left, middle, right);
		}
	}
}


