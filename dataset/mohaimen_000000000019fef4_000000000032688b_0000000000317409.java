
import java.util.Scanner;

public class Solution {
	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();
	
		for(int t = 0; t< tests; t++) {
			
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			
			String s = scanner.next();
			int count = 0, res = 0;
			if(x > y && s.length() > y) {
				System.out.println("Case #" + (t + 1) + ": " + "IMPOSSIBLE");
			}else {
				
				if(x == y) {
					count = x;
					res = x;
				}else if(x < y) {
					count = y - x;
					res = count;
				}else {
					count = y;
					res = x;
				}
				
				int c = 0;
				
				for(int i = 0; i < s.length(); i++) {
					if(s.charAt(i) == 'S') {
						c++;
					}else {
						c = 0;
					}
				}
				
				if(c >= count) {
					System.out.println("Case #" + (t + 1) + ": " + res);
				}else {
					System.out.println("Case #" + (t + 1) + ": " + "IMPOSSIBLE");
				}
				
			}
			
			
			
			
		}
	
	}
}
