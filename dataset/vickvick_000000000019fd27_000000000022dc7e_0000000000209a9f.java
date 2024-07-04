
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long t = scan.nextInt(); // Scanner has functions to read ints, longs,
									// strings, chars, etc.
		scan.nextLine();
		for (long it = 1; it <= t; ++it) {
			String s = scan.nextLine();
			int nums[] = new int[s.length()];
			for (int in = 0; in < s.length(); ++in) {
				nums[in] = Integer.parseInt(String.valueOf(s.charAt(in)));
			}
			String res = cal(nums);
			System.out.println("Case #" + it + ": " + res);
		}
		scan.close();
	}

	private static String cal(int[] nums) {
		int len = nums.length;
		int origNums[] = new int[len];
		for (int i = 0; i < len; ++i)
			origNums[i] = nums[i];
		List<Integer> before = new ArrayList<>();
		List<Integer> after = new ArrayList<>();
		for (int i = 0; i < len; ++i) {
			nums[i] = nums[i] + 1;
		}
		for (;;) {
			boolean end = true;
			for (int i = 0; i < len; ++i) {
				if (nums[i] != 0) {
					nums[i] = nums[i] - 1;
				}
				if (nums[i] != 0) {
					end = false;
				}
			}
			if (end)
				break;
			int p0 = 0;
			do {
				int p1 = 0;
				int i = p0;
				for (i = p0; i < len; ++i) {
					if (nums[i] != 0) {
						p0 = i;
						break;
					}
				}
				if (i == len) {
					break;
				}
				if (p0 == len - 1 || nums[p0 + 1] == 0) {
					p1 = p0;
				} else {
					for (i = p0 + 1; i < len; ++i) {
						if (nums[i] == 0) {
							p1 = i - 1;
							break;
						}
					}
					if (i == len) {
						p1 = i - 1;
					}
				}
				before.add(p0);
				after.add(p1);
				p0 = p1 + 1;
			} while (p0 < len);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; ++i) {
			final int index = i;
			long count1 = before.stream().filter(e -> e == index).count();
			for (int c = 0; c < count1; ++c) {
				sb.append('(');
			}
			sb.append(origNums[i]);
			long count2 = after.stream().filter(e -> e == index).count();
			for (int c = 0; c < count2; ++c) {
				sb.append(')');
			}
		}
		return sb.toString();
	}

}