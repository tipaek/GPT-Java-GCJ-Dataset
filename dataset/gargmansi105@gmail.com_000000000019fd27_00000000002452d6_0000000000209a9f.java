import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for (int q = 0; q < t; q++) {
			String str=sc.next();
			StringBuilder ans=new StringBuilder();
			int op=0;
			for (int i = 0; i < str.length(); i++) {
				int ch=str.charAt(i)-'0';
				while(op<ch) {
					ans.append("(");
					op++;
				}
				while(op>ch) {
					ans.append(")");
					op--;
				}
				ans.append(ch);
			}
			while(op>0) {
				ans.append(')');
				op--;
			}
			System.out.println("Case #"+q+": "+ans);
		}

	}

}
