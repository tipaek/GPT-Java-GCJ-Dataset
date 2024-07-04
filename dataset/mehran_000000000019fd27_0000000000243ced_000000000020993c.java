import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class S1_1 {
	public static int sum(int [] arr) {
		int ret = 0;
		for (int i=0; i<arr.length; i++)
			ret+=arr[i];
		return ret;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int it = 1; it <= t; ++it) {
			int n = in.nextInt();
			int cols[][] = new int[n][n];
			int r=0,c=0,k = 0;
			for (int i = 0; i < n; i++) {
				int row[] = new int[n];
				for (int j = 0; j < n; j++) {
					int item = in.nextInt();
					if (i==j)
						k += item;
					row[item-1] = 1;
					cols[j][item-1] = 1;
				}
				if (sum(row) < n)
					r++;
			}
			for (int i=0; i<n; i++)
				if (sum(cols[i]) < n)
					c++;
			System.out.println("Case #" + it + ": " + (k) + " " + (r) + " " + (c));
		}
	}
}
