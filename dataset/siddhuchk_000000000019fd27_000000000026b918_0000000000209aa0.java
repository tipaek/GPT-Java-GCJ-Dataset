import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int ca = 1;
		while (t-- > 0) {
			String[] nums = br.readLine().split("\\s+");
			int n = Integer.parseInt(nums[0]);
			int k = Integer.parseInt(nums[1]);
			int found = -1;
			for (int i = 1; i <= n; i++) {
				if (i * n == k) {
					found = i;
					break;
				}
			}
			if (found != -1) {
				System.out.println("Case #" + (ca++) + ": POSSIBLE");
				printLatin(found, n);
			} else {
				System.out.println("Case #" + (ca++) + ": IMPOSSIBLE");
			}
		}
	}

	static void printLatin(int start, int n) {
		int k = start;
		for (int i = 1; i <= n; i++) {
			int temp = k;
			while (temp <= n) {
				System.out.print(temp + " ");
				temp++;
			}
			for (int j = 1; j < k; j++)
				System.out.print(j + " ");

			k--;
			if (k == 0) {
				k = n;
			}
			System.out.println();
		}
	}
}