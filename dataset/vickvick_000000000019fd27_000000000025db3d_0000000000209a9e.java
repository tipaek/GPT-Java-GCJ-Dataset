
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

	private static void cal(int size) {
		if (size == 10) {
			int[] nums = new int[11];
			for (int c = 1; c <= 10; ++c) {
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
			String y = scan.next("[A-Z]");
		} else {
			int[] set1 = new int[size / 4];
			int[] set2 = new int[size / 4];
			int[] set3 = new int[size / 4];
			int[] set4 = new int[size / 4];

			int[] num1 = new int[size / 4];
			int[] num2 = new int[size / 4];
			int[] num3 = new int[size / 4];
			int[] num4 = new int[size / 4];
			// 1-5
			for (int ask = 1, i = 0; ask <= size / 4; ++ask) {
				System.out.println(ask);
				set1[i++] = scan.nextInt();
			}
			// 16-20
			for (int ask = size * 3 / 4 + 1, i = 0; ask <= size; ++ask) {
				System.out.println(ask);
				set4[i++] = scan.nextInt();
			}
			// 6-10
			for (int ask = size / 4 + 1, i = 0; ask <= size / 2; ++ask) {
				System.out.println(ask);
				set2[i++] = scan.nextInt();
			}
			// 11-15
			for (int ask = size / 2 + 1, i = 0; ask <= size * 3 / 4; ++ask) {
				System.out.println(ask);
				set3[i++] = scan.nextInt();
			}
			// 1-5
			for (int ask = 1, i = 0; ask <= size / 4; ++ask) {
				System.out.println(ask);
				num1[i++] = scan.nextInt();
			}
			// 6-10
			for (int ask = size / 4 + 1, i = 0; ask <= size / 2; ++ask) {
				System.out.println(ask);
				num2[i++] = scan.nextInt();
			}

			if (compare(set1, num1)) {
				num4 = set4;
			} else if (compare(set1, cmpl(num1))) {
				num4 = cmpl(set4);
			} else if (compare(num1, revs(set4))) {
				num4 = revs(set1);
			} else {
				num4 = revs(cmpl(set1));
			}

			if (compare(set2, num2)) {
				num3 = set3;
			} else if (compare(set2, cmpl(num2))) {
				num3 = cmpl(set3);
			} else if (compare(num2, revs(set3))) {
				num3 = revs(set2);
			} else {
				num3 = revs(cmpl(set2));
			}

			// populate result
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < num1.length; ++i)
				res.append(num1[i]);
			for (int i = 0; i < num1.length; ++i)
				res.append(num2[i]);
			for (int i = 0; i < num1.length; ++i)
				res.append(num3[i]);
			for (int i = 0; i < num1.length; ++i)
				res.append(num4[i]);
			System.out.println(res.toString());
			String y = scan.next("[A-Z]");
			if (!"Y".equals(y)) {
				System.exit(0);
			}
		}
	}

	private static boolean compare(int[] nums1, int[] nums2) {
		for (int i = 0; i < nums1.length; ++i)
			if (nums1[i] != nums2[i])
				return false;
		return true;
	}

	private static int[] revs(int[] nums) {
		int r[] = new int[nums.length];
		for (int i = 0; i < nums.length; ++i)
			r[nums.length - i - 1] = nums[i];
		return r;
	}

	private static int[] cmpl(int[] nums) {
		int r[] = new int[nums.length];
		for (int i = 0; i < nums.length; ++i)
			r[i] = nums[i] == 1 ? 0 : 1;
		return r;
	}

}