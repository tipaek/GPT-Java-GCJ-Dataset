import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.nextLine();
		for(int i = 0; i < n; i++) {
			String s = in.nextLine();
			int depth = 0;
			
			String ans = "";
			// "a " + x
			for(int j = 0; j < s.length(); j++) {
				int num = s.charAt(j) - '0';
				while(num > depth) {
					ans += "("; // ans = ans + ")"
					depth++;
				}
				
				while(num < depth) {
					ans += ")";
					depth--;
				}
				
				ans += num;
			}
			
			for(int j = 0; j < depth; j++)
				ans += ")";
			
			System.out.println("Case #" + (i + 1) + ": " + ans);
			
			
			
		}
	}

}
