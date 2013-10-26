import java.util.*;

public class Subsets {
	public static int SVSIZE = 8;

	public static void main(String[] args) {
		int [] sv = new int[SVSIZE];
		backtrack(sv, 0, 7);
		
	}

	public static boolean solution(int[] sv, int k, int n) { 
		return k == n;
	}

	public static void process_solution (int [] sv, int k, int n) {
		for (int i = 0; i < n; i++) {
			if (sv[i] == 1) 
				System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void computeCandidates (int [] sv, int k, int n, ArrayList <Integer> candidates) {
		candidates.add(0);
		candidates.add(1);
	}

	public static void backtrack(int[] sv, int k, int n) {

		if (solution(sv, k, n)) {
			process_solution(sv, k, n);
		}
		else {
			ArrayList<Integer> candidates = new ArrayList<Integer>();
			k = k + 1;
			computeCandidates (sv, k, n, candidates);
			for (int c :candidates) {
				sv[k] = c;
				backtrack(sv, k, n);
			}
		}
	}
}

