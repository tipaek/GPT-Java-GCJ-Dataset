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
			
			for(int j = 0; j < N; j++) {
				output += "1 " + (j+1) + "\n";
				
			}
			
			System.out.println("Case #" + (i+1) + ": " + output.trim());
			
		}
		
		in.close();
	}
}
