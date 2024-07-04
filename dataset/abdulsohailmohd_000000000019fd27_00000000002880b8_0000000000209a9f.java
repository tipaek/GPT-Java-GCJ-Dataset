import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
	
	public static String res = "";
	public static int opened = 0;

	public static void openBrackets(int num) {
		// System.out.println("Opening "+num);
		opened += num;
		while (num > 0) {
			res += "(";
			num--;
		}
	}
	public static void closeBrackets(int num) {
		opened -= num;
		while (num > 0) {
			res += ")";
			num--;
		}
	}
	public static String balanceIt(String nums) {

		res = "";
		opened = 0;

		int i = 0;
		int len = nums.length();
		for (i = 0; i < len; i++) {
			openBrackets(nums.charAt(i) - '0' - opened);
			res += nums.charAt(i);
			if (i+1 < len && nums.charAt(i) > nums.charAt(i + 1)) {
				closeBrackets(nums.charAt(i) - nums.charAt(i + 1));
			}
		}
		// System.out.println(len - 1);
		closeBrackets(nums.charAt(len - 1) - '0');

		return res;
	}

    public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(""));

        int testCases = scanner.nextInt();//.split(" ");

        for (int i = 1; i <= testCases; i++) {
			
			String input = scanner.next(); //.nextInt();

			// System.out.println("Input "+ input);

			String res = balanceIt(input);

			System.out.println("Case #"+i+": "+res);
        }
    }
}
