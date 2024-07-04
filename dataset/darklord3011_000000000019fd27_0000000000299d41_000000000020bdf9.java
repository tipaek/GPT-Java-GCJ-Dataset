import java.util.*;

public class Solution{
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int l = 0; l < t; l++) {
			int n = scan.nextInt();
			int a[] = new int[n];
			int d[] = new int[n];

			int c[][] = new int[n][2];
			for (int i = 0; i < n; i++) {
				c[i][0] = scan.nextInt();
				c[i][1] = scan.nextInt();
			}

			Arrays.sort(c, (m, x) -> m[0] - x[0]);
			for (int i = 0; i < n; i++) {
				a[i] = c[i][0];
				d[i] = c[i][1];
			}

			for (int i = 0; i < n; i++) {
				System.out.println(a[i] + " " + d[i]);
			}
			int count = 0;
			int i = 0;
			int j = 0;
			String ans = "";
			while (i < n && j < n) {
				if (a[i] < d[j]) {
					count++;
					i++;

				} else {
					count--;
					j++;
				}
				if (count == 1 && ans.length() < n) {
					ans = ans + "C";
				} else if (count == 2 && ans.length() < n) {
					ans = ans + "J";
				}
			}
			if (count > 2) {
				ans = "IMPOSSIBLE";
			}
			System.out.println("Case #" + (l+1) + ": " +ans);
		}

	}


}