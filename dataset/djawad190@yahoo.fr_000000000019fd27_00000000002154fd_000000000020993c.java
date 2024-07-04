import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		int r, c, value;
		long trace;
		int N;

		HashSet<Integer> rSet = new HashSet<Integer>();
		List<HashSet<Integer>> cSet = new ArrayList<>();
		for (int i = 1; i <= T; i++) {
			r = 0;
			c = 0;
			trace = 0;
			N = in.nextInt();
			cSet.clear();
			for (int j = 0; j < N; j++) {
				rSet.clear();
				for (int k = 0; k < N; k++) {
					if (j == 0)
						cSet.add(new HashSet<>());
					value = in.nextInt();
					rSet.add(value);
					cSet.get(k).add(value);
					if (k == j)
						trace += value;
				}
				if (rSet.size() < N)
					r++;
			}
			for (HashSet<Integer> hashSet : cSet) {
				if (hashSet.size() < N)
					c++;
			}

			System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
		}
	}

}