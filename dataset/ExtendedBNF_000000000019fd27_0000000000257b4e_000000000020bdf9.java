import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.print("Case #" + (i + 1) + ": ");
			solve(s);
		}

	}
	
	public static void solve(Scanner s) {
		int N = s.nextInt();
		int[] start = new int[N];
		int[] end = new int[N];
		for(int i = 0; i < N; i++) {
			start[i] = s.nextInt();
			end[i] = s.nextInt();
		}
		
		List<Integer>[] ad = new LinkedList[N];
		for(int i = 0; i < N; i++) {
			ad[i] = new LinkedList<Integer>();
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(start[i] <= start[j] && start[j] < end[i]) {
					ad[i].add(j);
					ad[j].add(i);
				}
			}
		}
		Set<Integer> visited = new HashSet();
		Set<Integer> J = new HashSet();
		Set<Integer> C = new HashSet();
		
		boolean[] possible = new boolean[1];
		possible[0] = true;
		
		for(int i = 0; i < N; i++) {
			if(!possible[0]) break;
			if(visited.contains(i)) continue;
			twoCol(possible, true, i, visited, J, C, ad);
		}
		
		if(possible[0]) {
			for(int i = 0; i < N; i++) {
				if(J.contains(i)) {
					System.out.print("J");
				} else {
					System.out.print("C");
				}
			}
		} else {
			System.out.print("IMPOSSIBLE");
		}
		System.out.println();
		
	}
	
	public static void twoCol (boolean[] possible, boolean f, int current, Set<Integer> visited, Set J, Set C, List<Integer>[] ad) {
		if(!possible[0]) return;
		if(f) {
			J.add(current);
		} else {
			C.add(current);
		}
		visited.add(current);
		
		for(int a : ad[current]) {
			if(!visited.contains(a)) {
				twoCol(possible, !f, a, visited, J, C, ad);
			} else {
				if(f && J.contains(a) || !f && C.contains(a)) {
					possible[0] = false;
				}
			}
		}
	}

}
