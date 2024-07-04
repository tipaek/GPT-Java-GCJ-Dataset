
import java.util.Scanner;
import java.util.*; 

public class Solution {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		scan.nextLine();
		
		StringBuilder [] ans = new StringBuilder[T];
		
		for (int j = 0; j < T; j++) {
			StringBuilder res = new StringBuilder();
			Stack<Integer> stack = new Stack<Integer>();
			String str = scan.next();
			int i = 0;
			while (i < str.length())
			{
				while (i < str.length() && str.charAt(i) == '0') {
					res.append('0');
					i++;
				}
				
				if (i < str.length() && str.charAt(i) == '1') {
					res.append('(');
					res.append('1');
					stack.add (1);
					i++;
					if (i == str.length())
						res.append(')');
				}
				
				while (i < str.length() && str.charAt(i) == '1') {
					res.append('1');
					i++;
					if (i == str.length())
						res.append(')');
				}
				
				if (i < str.length() && str.charAt(i) == '0') {
					res.append(')');
					res.append('0');
					stack.pop();
					i++;
				}
			}
			ans[j] = res;
		}
		
		scan.close();

		for(int i = 1; i <= T; i++) {
			System.out.println("Case #" + i + ": " + ans[i - 1]);
		}
	}
}
