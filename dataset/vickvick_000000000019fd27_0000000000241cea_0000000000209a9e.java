
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long t = scan.nextInt();
		int b = scan.nextInt();
		for (long it = 1; it <= t; ++it) {
			cal(b);
		}
		scan.close();
	}

	private static void cal(int b) {
		if (b == 10) {
			int[] nums = new int[11];
			for (int c = 1; c <= 13; ++c) {
				int ask = c;
				if (c > 10) {
					ask = 1;
				}
				System.out.println(ask);
				int a = scan.nextInt();
				nums[ask] = a;
			}
			StringBuilder res = new StringBuilder();
			for (int i = 1; i <= 10; ++i) {
				res.append(nums[i]);
			}
			System.out.println(res.toString());
		}
		System.exit(0);
	}

}