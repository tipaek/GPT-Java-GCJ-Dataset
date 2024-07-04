import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int caseCount = in.nextInt();
		in.nextLine();

		for(int c = 1; c <= caseCount; c++) {
			String line = in.nextLine();
			
			String ans = "";
			char last = '0';
			for(char x : line.toCharArray()) {
				while(x > last) {
					ans += '(';
					last++;
				}
				
				while(x < last) {
					ans += ')';
					last--;
				}
				
				ans += x;
			}
			
			for(; last > '0'; last--) {
				ans += ')';
			}
			
			System.out.println("Case #" + c + ": "+ ans);
		}
	}
}
