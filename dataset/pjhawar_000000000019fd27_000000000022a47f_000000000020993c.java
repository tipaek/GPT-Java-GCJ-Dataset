import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					a[j][k] = sc.nextInt();
				}
			}
			int[] ans = getAns(a);
			System.out.println("Case #" + i + ": " + ans[0] + " " + ans[1] + " " + ans[2]);
		}
		sc.close();
	}

	private static int[] getAns(int[][] a) {
		int[] res = new int[3];
		int n = a.length;
		for(int i = 0; i < n; i++) {
			res[0] += a[i][i];
			Set<Integer> set = new HashSet<Integer>();
			for(int j = 0; j < n; j++) {
				if(set.contains(a[i][j])) {
					res[1]++;
					break;
				}
				set.add(a[i][j]);
			}
			set.clear();
			for(int j = 0; j < n; j++) {
				if(set.contains(a[j][i])) {
					res[2]++;
					break;
				}
				set.add(a[j][i]);
			}
		}
		return res;
	}
}
