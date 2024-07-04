import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 0; i < t; ++i) {		
			String inputString = in.next();
			solve(inputString, i+1);
		}
	}

	private static void solve(String input, int testCase) {
		int size = input.length();
		int checkArray[] = new int[size];
		int maximum = 0;
		int j,k;

		for(j = 0; j < size; j++) {
			checkArray[j] = input.charAt(j) - 48;
			if(checkArray[j] > checkArray[maximum])
				maximum = j;
		}
		String fString = "";
		fString = fString + input.charAt(maximum);
		int operand = checkArray[maximum];
		for(j = maximum + 1; j < size; j++) {
			int difference = operand - checkArray[j];
			if(difference > 0)
			{
				for(k = 0; k < difference; k++) {
					fString = fString+ ")";
				}
			}
			else
			{
				for(k = 0; k < -1*difference; k++) {
					fString = fString + "(";
				}
			}
			fString+=input.charAt(j);
			operand = checkArray[j];
		}

		for(k = 0; k<operand; k++) {
			fString = fString + ")";
		}
		
		operand = checkArray[maximum];
		for(j=maximum-1;j>=0;j--) {
			int difference = operand - checkArray[j];
			if(difference > 0)
			{
				for(k = 0; k<difference; k++) {
					fString = "(" + fString ;
				}
			}
			else
			{
				for(k = 0; k < -1*difference; k++) {
					fString = ")"+fString ;
				}
			}
			fString= input.charAt(j) + fString;
			operand = checkArray[j];
		}
		for(k = 0; k < operand; k++)
			fString = "("+fString ;

		System.out.println("Case #" + testCase+ ": " + fString);
	}
}