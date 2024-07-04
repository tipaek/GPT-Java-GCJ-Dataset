
import java.util.Scanner;

public class Solution {
	
public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int c = 1;
		while (t-- > 0) {

			String s = scan.next();
			
			StringBuilder ans = function(s);
			System.out.print("Case #" + c + ": ");
			System.out.print(ans);
			System.out.println();
			c++;
		}
	}

	public static StringBuilder function(String s) {
		
		StringBuilder sans = new StringBuilder();
		int prev = s.charAt(0) - '0';
		int open = 0;
		for(int i = 0; i<prev; i++) {
			sans.append("(");
			open++;
		}
		sans.append(prev);
		
		for(int i = 1; i<s.length(); i++) {
			
			int curr = s.charAt(i) - '0';
			if(curr >= prev) {
				int num = curr - prev;
				for(int j = 0; j<num; j++) {
					sans.append("(");
					open++;
				}
			}
			
			else if(curr < prev) {
				
				int num = prev - curr;
				for(int j = 0; j<num; j++) {
					sans.append(")");
					open--;
				}
			}
			
			sans.append(curr);
			prev = curr;
			
		}
		
		
		for(int j = 0; j<open; j++) {
			sans.append(")");
		}
		
		return sans;
	
	}

}
