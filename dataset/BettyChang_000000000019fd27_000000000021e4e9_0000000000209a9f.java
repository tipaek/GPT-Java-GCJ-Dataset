import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //test cases
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        // read test cases
		for (int i = 1; i <= t; ++i) {
			String s = in.next();
			String output = "";
			int closeCount = 0;
			int prevInt = 0;
			//loop through string
			for(int s_index = 0; s_index< s.length(); s_index++) {
				char c = s.charAt(s_index);
				int currInt = Integer.parseInt(String.valueOf(c));
				if(s_index == 0) {
					//first character
					output = appendOpen(output, currInt);
					closeCount = currInt;
				}else{
						if(currInt > prevInt) {
							output = appendOpen(output, currInt - prevInt);
						}else if(currInt < prevInt) {
							output = appendClose(output, prevInt - currInt);
						}
						closeCount += (currInt - prevInt);
				}
				output += currInt;
				prevInt = currInt;
				
			}
			// close up
			output = appendClose(output, closeCount);
			System.out.println("Case #" + i + ": " + output );
        }

	}


	private static String appendClose(String output, int closeCount) {
		for(int i = 0; i< closeCount; i++) {
			output += ")";
		}
		return output;
	}


	private static String appendOpen(String output, int currInt) {
		for(int i = 0; i< currInt; i++) {
			output += "(";
		}
		return output;
		
	}

}
