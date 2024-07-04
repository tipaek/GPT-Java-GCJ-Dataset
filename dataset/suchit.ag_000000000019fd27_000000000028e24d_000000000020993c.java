import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int a[][] = new int[n][n];
			int k = 0, r = 0, c = 0;
			for (int x = 0; x < n; x++) {
				Set<Integer> rowSet = new HashSet<>();
				boolean flag = false;
				for (int y = 0; y < n; y++) {
					a[x][y] = sc.nextInt();
					if (x == y)
						k += a[x][y];
					if (!rowSet.contains(a[x][y]))
						rowSet.add(a[x][y]);
					else
						flag = true;
				}
				if (flag)
					r++;
			}
			for (int x = 0; x < n; x++) {
				Set<Integer> colSet = new HashSet<>();
				boolean flag = false;
				for (int y = 0; y < n; y++) {
					if (!colSet.contains(a[y][x]))
						colSet.add(a[y][x]);
					else
						flag = true;
				}
				if (flag)
					c++;
			}
			System.out.println("Case #" + (i+1) + ": " + k + " " + r + " " + c);
		}
		sc.close();
	}

}
