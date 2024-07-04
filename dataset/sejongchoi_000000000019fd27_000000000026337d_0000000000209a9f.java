import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int t=1;t<=test_case;t++) {
			String s = sc.next();
			StringBuffer res = new StringBuffer();
			int remains = 0, cur;
			for(int i=0;i<s.length();i++) {
				cur = Character.getNumericValue(s.charAt(i));
				if(remains == 0) {
					for(int j=0;j<cur;j++) res.append('(');
					remains += cur;
					res.append(s.charAt(i));
				}
				else if(cur > remains) {
					for(int j=0;j<cur-remains;j++) res.append('(');
					res.append(s.charAt(i));
					for(int j=0;j<cur-remains;j++) res.append(')');
				}
				else if( cur < remains){
					for(int j=0;j<remains-cur;j++) res.append(')');
					remains = cur;
					res.append(s.charAt(i));
				}
				else {
					res.append(s.charAt(i));
				}
			}
			for(int i=0;i<remains;i++) res.append(')');
			System.out.println("Case #"+t+": "+res);
		}
		
	}
}
