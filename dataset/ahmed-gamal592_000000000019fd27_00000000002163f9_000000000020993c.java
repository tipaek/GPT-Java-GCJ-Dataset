import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static String solution(int n, int[][] a) {
		HashMap<Integer, Set<Integer>> rows = new HashMap<>();
		HashMap<Integer, Set<Integer>> cols = new HashMap<>();

		int k = 0;
		for (int i = 0; i < n; i++) {
			k += a[i][i];

			rows.put(i, new HashSet<>());
			cols.put(i, new HashSet<>());
		}
		int r = 0;
		int c = 0;
		
		Set<Integer> rc = new HashSet<Integer>();
		Set<Integer> cc = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (rows.get(i).contains(a[i][j])&& !rc.contains(i)) {
					rc.add(i);
					r++;
				}
				rows.get(i).add(a[i][j]);

				if (cols.get(j).contains(a[i][j]) && !cc.contains(j)) {
					cc.add(j);
					c++;
				}

				cols.get(j).add(a[i][j]);
			}
		}
		
		//System.out.println(rows);
		//System.out.println(cols);

		return k + " " + r + " " + c;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		int caaa = 1;

		while (tests > 0) {
			tests--;

			int n = in.nextInt();
			in.nextLine();
			int[][] a = new int[n][n];
			for (int i = 0; i < n; ++i) {
				String line = in.nextLine();
				// 2 1 3
				String[] sp = line.split(" ");
				for (int j = 0; j < sp.length; j++) {
					a[i][j] = Integer.parseInt(sp[j]);
				}
			}

			System.out.println("Case #" + caaa++ + ": " + solution(n, a));
		}
		
		/*int [][] a= {
				{2, 2 ,2 ,2},
				{2, 3,2,3},
				{2,2,2,3},
				{2,2,2,2}
		};
				System.out.println(solution(4, a));
		*/

	
	}
}
