import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		int T =  sc.nextInt();
		sc.nextLine();
		
		for(int tc = 1; tc <= T; tc++) {
			String ans = "";
			
			String input = sc.nextLine();
			
			int curDepth = 0;
			
			for(char ch : input.toCharArray()) {
				
				int depth = ch - '0';
				
				while(curDepth < depth) {
					++curDepth;
					ans += "(";
				}
				
				while(curDepth > depth) {
					--curDepth;
					ans += ")";
				}
				
				if(curDepth == depth) {
					ans += ch;
				}	
			}
			
			while(curDepth > 0) {
				--curDepth;
				ans += ")";
			}
			
			System.out.println("Case #" + tc + ": " + ans);
		}
	}

}
