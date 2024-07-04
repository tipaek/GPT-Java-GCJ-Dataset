import java.util.Scanner;
public class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		for (int i = 0; i < t; i++) {
			String inputS = in.nextLine();
			String output = "";
			int len = inputS.length();
			int currNleft = 0;
			for (int j = len - 1; j >= 0; j--) {
				int digit = (int)(inputS.charAt(j)) - 48;
				if(digit == 0) {
					output = "0" + output;
					currNleft = 0;
				} else {
					int newCurrNLeft = 0;
					if (currNleft <= digit) {
						String someVal = String.valueOf(digit);
						for (int k = 0; k < digit - currNleft; k++){
							someVal = "(("+someVal+")";
							newCurrNLeft++;
						}
						output = output.substring(0,currNleft) + someVal + output.substring(currNleft);
						currNleft += newCurrNLeft;
					} else {
						output = output.substring(0, digit) + String.valueOf(digit) + output.substring(digit);
						currNleft = digit;
					}
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + output);
		}
	}
}