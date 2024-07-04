import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			String line = in.nextLine();
			String output = "";
			int lastNum = -1;
			for (char c : line.toCharArray()) {
				int num = Character.getNumericValue(c);
				if (lastNum < 0) {
					for (int j = 0; j < num; j++) {
						output = output + "(";
					}
					output = output + num;
					lastNum = num;
				}
				else {
					if (lastNum == num) {
						output = output + num;
					}
					else if (num < lastNum) {
						for (int j = 0; j < lastNum - num; j++) {
							output = output + ")";
						}
						output = output + num;
						lastNum = num;
					}
					else {
						for (int j = 0; j < num - lastNum; j++) {
							output = output + "(";
						}
						output = output + num;
						lastNum = num;
					}
				}
			}
			
			for (int j = 0; j < lastNum; j++) {
				output = output + ")";
			}
			System.out.println("Case #" + i + ": " + output);
		}
		in.close();
	}
}