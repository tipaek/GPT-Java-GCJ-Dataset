import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		String S;
		char[] ar;
		boolean open;
		
		StringBuilder result;
		
		for (int t = 1; t <= T; t++) {
			S = sc.nextLine();
			ar = S.toCharArray();
			result = new StringBuilder();
			
			open = false;
			
			for (int i = 0; i < ar.length; i++) {
				if (ar[i] == '0') {
					if (open) {
						result.append(')');
						open = false;
					}
				} else {
					if (!open) {
						result.append('(');
						open = true;
					}
				}
				
				result.append(ar[i]);
			}
			
			if (open) {
				result.append(')');				
			}
			
			System.out.println(String.format("Case #%d: %s", t, result));
		}
		
	}

}
