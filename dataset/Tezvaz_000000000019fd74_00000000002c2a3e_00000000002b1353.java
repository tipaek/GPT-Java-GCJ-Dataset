
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*Quick Notes
Use BigInteger & BigDecimal for large numbers - They are arbitrarily precise.

*/
public class Solution {
	
	public static void main(String[] args) {
		
		//System.out.println("Some*some".replace("*",""));
		Scanner in = new Scanner(System.in);
		int totalTestCases = Integer.parseInt(in.nextLine());
		
		for(int i = 0; i < totalTestCases; i++) {
			
			String output = "";
			int N = Integer.parseInt(in.nextLine());
			
			if(N <= 500) {
				for(int j = 0; j < N; j++) {
					output += (j+1) + " 1" + "\n";
					
				}
				
				System.out.println("Case #" + (i+1) + ":\n" + output.trim());
			} else {
				
				output += "1 1\n";
				output += "2 1\n";
				output += "3 2\n";
				output += "3 1\n";
				
				for(int j = 3; j < 499; j++) {
					output += (j+1) + " 1" + "\n";
					
				}
				
				System.out.println("Case #" + (i+1) + ":\n" + output.trim());
			}
			
		}
		
		in.close();
	}
}
