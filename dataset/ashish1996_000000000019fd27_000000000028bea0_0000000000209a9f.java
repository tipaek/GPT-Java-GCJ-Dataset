import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String...ss) {
		Scanner s = new Scanner(System.in);
		int t1 = s.nextInt();
		int k = 1;
		while (t1-- != 0) {
			String input = s.next();
			String output = "";
			int count = Integer.valueOf(input.charAt(0)-48);
			
			for (int i = 0; i < input.length(); i++) {
				if (i == 0) {

					while (i < input.length() && count-- > 0) {
						output = output + "(";
					}
					count = Integer.valueOf(input.charAt(i)-48);
					output = output + input.charAt(i);
				}
				
				
				else if (Integer.valueOf(input.charAt(i)-48) <count ) {
					
					while (i < input.length() && count-Integer.valueOf(input.charAt(i)-48) > 0) {
						output = output + ")";
						count--;
					}
					output = output + input.charAt(i);
					}
				else if (Integer.valueOf(input.charAt(i)-48) >=count ) {
					while (i < input.length() && Integer.valueOf(input.charAt(i)-48)-count > 0) {
						output = output + "(";
						count++;
					}
					output = output + input.charAt(i);
					}
					
				 if (i==input.length()-1) {
					while (i < input.length() && count-- > 0) {
						output = output + ")";
					}	
				 }
				
				 
			}
			System.out.print("Case #" + k++ + ": " + output);
			System.out.println();
		}

	}
		
		
}