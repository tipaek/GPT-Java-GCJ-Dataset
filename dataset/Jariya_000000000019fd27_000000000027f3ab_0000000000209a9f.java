import java.util.Scanner;

// question2: Nesting Depth/ parenthesis
public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int T = sc.nextInt();
			
			for(int test=0; test< T; test++) {
				
				String s = sc.next();
				String y = solution(s);
				System.out.println("Case #"+(test+1)+": "+y);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	private static String solution (String s) {
		
		StringBuffer sb = new StringBuffer();
		int open = 0;
		for(char c : s.toCharArray()) {
			int val = Character.getNumericValue(c);
			while(open < val) {
				sb.append('(');
				open++;
			}
			while(open > val) {
				sb.append(')');
				open--;
			}
			sb.append(c);
		}
		while(open > 0) {
			sb.append(')');
			open--;
		}
		
		return sb.toString();
	}
	
	
}
