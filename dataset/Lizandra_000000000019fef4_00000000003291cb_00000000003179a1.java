import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static final String CASE = "Case #";
	public static String minPath = "";

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCaseNumber = in.nextInt();
		int U = 1;
		int max = 10000;
		RNum[] nums;
		String[] parts;
		ArrayList<String> digits = new ArrayList<>();
		ArrayList<String> digitsWithZero = new ArrayList<>();

		for (int currentTestCase = 1; currentTestCase <= testCaseNumber; ++currentTestCase) {
			U = in.nextInt();
			nums = new RNum[max];
			String output = CASE + currentTestCase + ": ";
			in.nextLine();
			for (int j = 0; j < max; j++) {
				parts = in.nextLine().split(" ");
				nums[j] = new RNum(Integer.parseInt(parts[0]), parts[1]);
			}
			calculate(max, nums, digits, digitsWithZero, output, U);
		}
		in.close();
	}

	private static void calculate(int max, RNum[] nums, ArrayList<String> digits, ArrayList<String> digitsWithZero,
			String output, int U) {
		StringBuilder sb;
		Arrays.sort(nums);
		String f, l, ld;
		int ind;
		for (int j = 0; j < max; j++) {
			if (digits.size() == nums[j].M) { // already found all 1-M digits, need to jump
				continue;
			}

			f = nums[j].firstDigit();
			if (!digits.contains(f) && (((nums[j].M > 0) && (nums[j].M < 9)) || (nums[j].len > 1))) { // 1-9
				digits.add(f);
			}

			if (digitsWithZero.contains(f)) {
				digitsWithZero.remove(digitsWithZero.indexOf(f));
			}

			ind = digits.indexOf(f);
			if ((nums[j].len == 2) && (nums[j].M > (ind * 10)) && ((nums[j].M < ((ind + 1) * 10)))) { // 11-19, 21-29, 31-39 ...
				l = nums[j].lastDigit(); // last digit is ordered
				if (!digits.contains(l)) {
					digits.add(l);
				}
			}

			if (U > 2) {
				ld = nums[j].lastDigits();
				for (int k = 0; k < ld.length(); k++) {
					if (k == (ld.length() - 1)) { // last one
						l = ld.substring(k);
					} else {
						l = ld.substring(k, k + 1);
					}
					if (!digits.contains(l) && !digitsWithZero.contains(l) // 0-9
							&& ((nums[j].M > 9) || (nums[j].M < 0)) && (nums[j].len > 1)) {
						digitsWithZero.add(l);
					}
				}
			} else {
				l = nums[j].lastDigit();
				if (!digits.contains(l) && !digitsWithZero.contains(l) // 0-9
						&& ((nums[j].M > 9) || (nums[j].M < 0)) && (nums[j].len > 1)) {
					digitsWithZero.add(l);
				}
			}

			if ((digits.size() == 9) && (digitsWithZero.size() == 1)) { // found all
				break;
			}
		}

		sb = new StringBuilder(); // only zero left there
		for (String digit : digits) {
			sb.append(digit);
			if (!digitsWithZero.isEmpty() && digitsWithZero.contains(digit)) {
				digitsWithZero.remove(digitsWithZero.indexOf(digit));
			}
		}

		System.out.println(output + digitsWithZero.get(0) + sb.toString());
	}

	static class RNum implements Comparable<RNum> {
		int M;
		String N;
		int len;

		public RNum(int M, String N) {
			this.M = M;
			this.N = N;
			this.len = N.length();
		}

		public String lastDigit() { // can be zero
			return N.substring(len - 1);
		}

		public String lastDigits() { // all these can be zero
			return N.substring(1);
		}

		public String firstDigit() { // cannot be zero
			if (len == 1) {
				return N;
			}
			return N.substring(0, 1);
		}

		@Override
		public int compareTo(RNum that) {
			if (M > that.M) {
				return 1;
			} else if (M < that.M) {
				return -1;
			}
			return len - that.len;
		}

		@Override
		public String toString() {
			return this.M + "," + this.N;
		}
	}

}
