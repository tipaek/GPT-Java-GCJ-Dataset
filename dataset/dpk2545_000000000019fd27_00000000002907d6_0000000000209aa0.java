import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int t = in.nextInt();
			int count = 1;
			while (t > 0) {
				int n = in.nextInt();
				int k = in.nextInt();
				printLatin(n, k, count);
				if(t>1)
				System.out.println();
				count++;
				t--;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public static void printLatin(int n, int k, int count) {
		if (n * n < k) {
			System.out.print("Case #" + count + ": IMPOSSIBLE");
			return;
		}
		boolean flag = false;
		int x = -1;
		for (int i = 1; i <= n; i++) {
			if (n * i == k) {
				flag = true;
				x = i;
				break;
			}
		}
		if (!flag) {
			System.out.print("Case #" + count + ": IMPOSSIBLE");
			return;
		}
		System.out.print("Case #" + count + ": POSSIBLE");
		int y = x;
		for (int i = 0; i < n; i++) {
			System.out.println();
			y = y == 0 ? n : y;
			x = y;
			for (int j = 0; j < n; j++) {
				System.out.print(x > n ? (x++) % n + " " : x++ + " ");
			}
			y--;
		}
	}
}