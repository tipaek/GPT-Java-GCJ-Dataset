import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int testCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    
		for(int tCase=1; tCase<=testCases; tCase++) {
			
			String inputString = in.next();
			String[] input = inputString.split("");
			StringBuffer output = new StringBuffer();
			int value = 0, previousValue = 0;
			for(int index = 0; index<input.length; index++) {
				value = Integer.parseInt(input[index]);
				if(value>previousValue) {
					for(int j = 0; j<value-previousValue; j++) {
						output.append("(");
					}
				} else if(value<previousValue) {
					for(int j=0; j<previousValue-value; j++) {
						output.append(")");
					}
				}
				output.append(value);
				previousValue=value;
			}
			for(int j=0;j<value;j++) {
				output.append(")");
			}
			
			System.out.println("Case #"+tCase+": "+output);
			
		}
		
		in.close();

	}

}
