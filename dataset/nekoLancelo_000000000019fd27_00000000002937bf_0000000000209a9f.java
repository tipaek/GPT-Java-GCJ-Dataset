import java.io.*;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
			in.nextLine();
			for(int i= 1 ; i <= t; i++) {
				String output = "";
				char c0 = '0';
				String input = in.nextLine();
				for(int j = 0; j < input.length(); j++) {
					int cur = (input.charAt(j)) - c0;
					if(cur == 0)
						output += "0";
					else{
						for(int k = 0 ; k < cur; k++) {
							int length = output.length();
							if(length > 1 && output.charAt(length-1) == ')') {
								output = output.substring(0, length -1);
							}
							else{
								output += "(";
							}
						}
						output += (char)((int)c0 + cur);
						for(int k = 0 ; k < cur; k++) {
							output += ")";
						}
					}
				}
				System.out.println("Case #" + i + ": " + output );
			}
		    in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	   
	    
	}
}
