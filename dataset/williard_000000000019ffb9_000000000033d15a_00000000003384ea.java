import java.io.*;
import java.util.*;

public class Solution {
	static long L, R;
	static long x, y, x_sum, y_sum;
	static boolean valid_x(long target) {
		long sum = (target * target + target) / 2;
		if (L >= R) {
			if (L - sum >= R)
				return true;
			else
				return false;
		}
		else {
			if (R - sum > L)
				return true;
			else
				return false;
		}
	}
	static void get_x() {
		long low = 0;
		long high = 3000000000L;
		long mid = (high + low) / 2;
		// System.out.printf("get_x:\n");
		while (low < high) {
			mid = (high + low) / 2;
			// if (mid < 1000)
			// 	System.out.printf("%d %d %d\n", low, mid, high);
			if (valid_x(mid)) {
				low = mid + 1;
			}
			else {
				high = mid;
			}
		}
		low--;
		// System.out.printf("%d %d %d\n", low, mid, high);
		x = low;
		x_sum = (x * x + x) / 2;
		if (L >= R)
			L -= x_sum;
		else
			R -= x_sum;
	}
	static boolean valid_y(long temp) {
		long target = temp * 4 + x;
		long y_sum = (target * target + target) / 2;
		long diff = y_sum - x_sum;
		long half = diff / 2;
		if (L >= R) {
			if (half + temp <= R)
				return true;
			else
				return false;
		}
		else {
			if (half <= L)
				return true;
			else
				return false;
		}
	}
	static void get_y() {
		long low = 0;
		long high = 1500000000L;
		long mid = (high + low) / 2;
		// System.out.printf("get_y:\n");
		while (low < high) {
			mid = (high + low) / 2;
			// if (mid < 1000)
			// 	System.out.printf("%d %d %d\n", low, mid, high);
			if (valid_y(mid)) {
				low = mid + 1;
			}
			else {
				high = mid;
			}
		}
		low -= 1;
		// System.out.printf("%d %d %d\n", low, mid, high);

		if (low > 0)

		y = low * 4 + x;
		y_sum = (y * y + y) / 2;
		
		if (L >= R) {
			L -= (y_sum - x_sum) / 2 - low;
			R -= (y_sum - x_sum) / 2 + low;
		}
		else {
			L -= (y_sum - x_sum) / 2 + low;
			R -= (y_sum - x_sum) / 2 - low;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int casenum = 1; casenum <= T; casenum++) {
			long left = sc.nextInt();
			long right = sc.nextInt();
			L = left;
			R = right;
			get_x();
			// System.out.printf("x: %d    y: %d    L: %d    R: %d\n", x, y, L, R);
			get_y();
			// System.out.printf("x: %d    y: %d    L: %d    R: %d\n", x, y, L, R);
			long ans = y;
			for(long temp = y + 1; true; temp++) {
				if (L >= R) {
					if (L >= temp) {
						L -= temp;
						ans = temp;
					}
					else
						break;
				}
				else {
					if (R >= temp) {
						R -= temp;
						ans = temp;
					}
					else
						break;
				}
			}
			System.out.printf("Case #%d: %d %d %d\n", casenum, ans, L, R);
			// System.out.printf("x: %d    y: %d\n", x, y);
		}
	}
}
