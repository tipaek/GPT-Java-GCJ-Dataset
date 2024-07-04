import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	private static void test() throws IOException {
		String s;
		BufferedReader read = new BufferedReader(new FileReader("data/testIn"));
		String total = "";
		while((s = read.readLine())!= null) total += s + "\n";
		InputStream testInput = new ByteArrayInputStream( total.getBytes("UTF-8") );
		System.setIn(testInput);
		read.close();
	}

	
	public static void main(String[] args) throws IOException {
//		test();
		final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final int t = Integer.parseInt(in.nextLine());
		for (int c = 1; c <= t; ++c) {
			System.out.println("Case #" + c + ": " + getResult(toIntArray(in.nextLine())));
		}
		in.close();
	}
	
	private static int[] toIntArray(final String s) {
		char[] chars = s.toCharArray();
		final int n = chars.length;
		int[] ints = new int[n];
		for(int i = 0; i < n; i++) ints[i] = (int)(chars[i] - '0');
		return ints;
	}


	// Sounds simple... I think?
	// Feels like a two-pronged parentheses-opening approach should lead to the minimum.
	// Will revisit if the small data set fails, as the theory should hold for both sizes,
	// even though that 0/1 input isn't very helpful for testing.
	// Validated with samples as well as text testsets 021, 312, 4, and 221
	// Also tested some paper ones - 132451 and 131245
	private static String getResult(final int[] nums) {
		final int n = nums.length;
		final int[] openingParentheses = new int[n];
		final int[] closingParentheses = new int[n];
		int localMin = 0;
		for (int i = 0; i < n; i++) {
			int diff = Math.max(0, nums[i] - localMin);
			openingParentheses[i] = diff;
			localMin = nums[i];
		}
		localMin = 0;
		for (int i = n-1; i >= 0; i--) {
			closingParentheses[i] = Math.max(0, nums[i] - localMin);
			localMin = nums[i]; 
		}
		
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < n; i++) {
			final int opening = openingParentheses[i];
			final int closing = closingParentheses[i];
			for (int j = 0; j < opening; j++) res.append("(");
			res.append(nums[i]);
			for (int j = 0; j < closing; j++) res.append(")");
		}
			
		return res.toString();
	}

}
