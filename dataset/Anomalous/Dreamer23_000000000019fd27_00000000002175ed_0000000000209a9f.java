import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Solution {

	private static void test() throws IOException {
		StringBuilder total = new StringBuilder();
		try (BufferedReader read = new BufferedReader(new FileReader("data/testIn"))) {
			String line;
			while ((line = read.readLine()) != null) {
				total.append(line).append("\n");
			}
		}
		InputStream testInput = new ByteArrayInputStream(total.toString().getBytes(StandardCharsets.UTF_8));
		System.setIn(testInput);
	}

	public static void main(String[] args) throws IOException {
		// Uncomment the following line to run the test method
		// test();
		
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int t = Integer.parseInt(in.nextLine());
			for (int c = 1; c <= t; ++c) {
				System.out.println("Case #" + c + ": " + getResult(toIntArray(in.nextLine())));
			}
		}
	}

	private static int[] toIntArray(String s) {
		int n = s.length();
		int[] ints = new int[n];
		for (int i = 0; i < n; i++) {
			ints[i] = s.charAt(i) - '0';
		}
		return ints;
	}

	private static String getResult(int[] nums) {
		int n = nums.length;
		int[] openingParentheses = new int[n];
		int[] closingParentheses = new int[n];
		int localMin = 0;

		for (int i = 0; i < n; i++) {
			openingParentheses[i] = Math.max(0, nums[i] - localMin);
			localMin = nums[i];
		}

		localMin = 0;
		for (int i = n - 1; i >= 0; i--) {
			closingParentheses[i] = Math.max(0, nums[i] - localMin);
			localMin = nums[i];
		}

		StringBuilder res = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < openingParentheses[i]; j++) res.append("(");
			res.append(nums[i]);
			for (int j = 0; j < closingParentheses[i]; j++) res.append(")");
		}

		return res.toString();
	}
}