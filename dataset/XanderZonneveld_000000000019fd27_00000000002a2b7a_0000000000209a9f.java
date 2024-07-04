import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int count = 1;
		sc.nextLine();

		while (t-- > 0) {
			String input = sc.nextLine();
			String solution = "";
			int depth = 0;
			
			for(int i = 0; i < input.length(); i++) {
				int curr = Integer.parseInt(""+input.charAt(i));
				
				if(depth < curr) {
					for (int j = 0; j < curr - depth; j++) {
						solution += "(";
					}
				} else if(depth > curr) {
					for (int j = 0; j < depth - curr; j++) {
						solution += ")";
					}
				}
				depth = curr;
				solution += curr;
			}
			
			if(depth > 0) {
				for (int j = 0; j < depth; j++) {
					solution += ")";
				}
			}
				
			
			System.out.println("Case #" + count + ": " + solution);
			
			count++;
		}
	}
}
