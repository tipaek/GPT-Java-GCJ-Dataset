import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		short T = input.nextShort();
		for(short i=0; i<T; i++) {
			String s = input.next();
			
			StringBuilder sp = new StringBuilder();
			int level = 0;
			for(int j=0;j<s.length();j++) {
				int el = Character.getNumericValue(s.charAt(j));
				
				// close parentheses
				if(level>el) {
					for(int k=level;k>el;k--) {
						sp.append(")");
					}
				}
				// open parentheses
				if(level<el) {
					for(int k=level;k<el;k++) {
						sp.append("(");
					}
				}
				
				sp.append(el);				
				level = el;
			}
			
			while(level-->0) {
				sp.append(")");
			}
			
			System.out.println(String.format("Case #%d: %s", (i+1), sp));
		}
		
	}

}
