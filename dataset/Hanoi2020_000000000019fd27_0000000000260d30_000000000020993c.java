import java.util.*;
import java.io.*;

//Pylons
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i1 = 1; i1 <= t; ++i1) {
			int N = in.nextInt();
			int[][] m = new int[N][N];
			int v = 0, r = 0, c = 0;
			HashMap<Integer, HashSet<Integer>> cmap = new HashMap<>();
			HashMap<Integer, HashSet<Integer>> rmap = new HashMap<>();

			for (int i =0; i < N ; i++){
				HashSet<Integer> temp = new HashSet<>();
				HashSet<Integer> temp1 = new HashSet<>();
				cmap.put(i,temp);
				rmap.put(i,temp1);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					m[i][j] = in.nextInt();
					if (i == j) v += m[i][j];
					rmap.get(i).add(m[i][j]);
					cmap.get(j).add(m[i][j]);
				}
			}

			for (int i = 0 ; i < N ; i ++) {
				if (rmap.get(i).size() != N) r++;
				if (cmap.get(i).size() != N) c++;
				System.out.println(cmap.get(i));
			}

			System.out.println("Case #" + i1 + ": " + v + " " + r + " " + c);

		}
		in.close();
	}

}