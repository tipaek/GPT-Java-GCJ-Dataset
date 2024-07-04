import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// observation: graph doesn't matter?
public class Solution {
	static int inf = 1000000;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int C = in.nextInt(), D = in.nextInt();
			int[] cs = new int[C];
			for (int i = 1; i < cs.length; i++) {
				cs[i] = in.nextInt();
			}
			
			int[] us = new int[D], vs = new int[D];
			for (int i = 0; i < D; i++) {
				us[i] = in.nextInt()-1;
				vs[i] = in.nextInt()-1;
			}
			
			
			int[] dists = new int[C];
			ArrayList<Integer> done = new ArrayList<>();
			done.add(0);
			for (int dist=1;dist<=1001;dist++) {
				ArrayList<Integer> current = new ArrayList<>();
				for(int i=0;i<C;i++) {
					if ((cs[i] < 0 && -cs[i] == done.size()) || (cs[i] > 0 && cs[i] == dist)) {
						current.add(i);
						dists[i] = dist;
					}
				}
				done.addAll(current);
			}
			
			System.out.printf("Case #%d:", t);
			for (int i = 0; i < D; i++) {
				System.out.print(" " + Math.max(1, Math.abs(dists[us[i]] - dists[vs[i]])));
			}
			System.out.println();
		}
	}

	static class Edge {
		int v, i;

		public Edge(int v, int i) {
			this.v = v;
			this.i = i;
		}
	}
}
