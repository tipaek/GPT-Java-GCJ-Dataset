import java.util.Arrays;
import java.util.Scanner;

class Work implements Comparable<Work> {
	int start, end, idx;
	public Work(int s, int e, int i) {
		start = s; end = e; idx = i;
	}
	public int compareTo(Work o) {
		return start - o.start;
	}
}

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();	// # of activities
			Work[] works = new Work[N];
			for(int i = 0; i < N; i++) {
				int S = sc.nextInt(), E = sc.nextInt();
				works[i] = new Work(S, E, i);
			}
			Arrays.sort(works);
			int[] assign = new int[N];
			boolean possible = true;
			int j_end = 0, c_end = 0;
			for(int i = 0; i < N; i++) {
				if(j_end <= works[i].start) {
					j_end = works[i].end;
					assign[works[i].idx] = 0;
				} else if(c_end <= works[i].start) {
					c_end = works[i].end;
					assign[works[i].idx] = 1;
				} else {
					possible = false;
					break;
				}
			}
			System.out.print("Case #" + t + ": ");
			if(possible) {
				for(int i = 0; i < N; i++) System.out.print((assign[i] == 0) ? "J" : "C");
				System.out.println();
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}
}