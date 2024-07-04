import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; i++) {
			solve(i, in);
		}
	}

	public static void solve(int t, Scanner in){
		int C = in.nextInt();
		int D = in.nextInt();

		// shift indices by 1 (be careful!)
		int[] inv_order = new int[100];
		int[] order = new int[100];
		int[] times = new int[100];
		
		for (int i = 0; i < C; i++){
			inv_order[i] = -1000001;
			order[i] = -1000001;
			times[i] = -1000001;
		}
		
		times[0] = 0;
		order[0] = 0;
		inv_order[0] = 0;
		
		List<Pair> Positives = new ArrayList<Pair>();
		
		int X = 0, tmp = 0;
		for (int i = 0; i < C - 1; i++){
			X = in.nextInt();
			if (X < 0){
				tmp = -X;
				while (order[tmp] >= 0){
					tmp++;
				}
				order[tmp] = i + 1;
				times[tmp] = -X;
				inv_order[i + 1] = tmp;
			} else {
				Positives.add(new Pair(X, i + 1));
			}
		}
		
		SortPairsByX(Positives);
		
		tmp = 0;
		int time = 0;
		int K = 0;
		Pair top;
		while (!Positives.isEmpty()){
			if (order[tmp] >= 0){
				K = -times[tmp];
				time++;
				while (times[tmp] == -K){
					times[tmp] = time;
					tmp++;
				}
			} else {
				top = Positives.remove(0);
				order[tmp] = top.y;
				inv_order[top.y] = tmp;
				times[tmp] = top.x;
				time = top.x;
			}
		}
		
		System.out.print("Case #" + t + ": ");
		tmp = 0;
		int u, v;
		for (int i = 0; i < D; i++){
			u = in.nextInt() - 1;
			v = in.nextInt() - 1;
			tmp = Math.max(1, Math.abs(times[inv_order[u]] - times[inv_order[v]]));
			System.out.print(tmp + " ");
		}
		System.out.print("\n");
	}

	public static class Pair {
		int x;
		int y;

		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void SortPairsByX(List<Pair> list){
		Collections.sort(list, new Comparator<Pair>() { 
			public int compare(Pair pair1, Pair pair2){
				Integer X = pair1.x;
				Integer Y = pair2.x;
				return X.compareTo(Y);
			}
		});
	}
}