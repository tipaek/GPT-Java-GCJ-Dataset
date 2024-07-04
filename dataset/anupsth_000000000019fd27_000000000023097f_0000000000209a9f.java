
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		final Scanner input = new Scanner(System.in);
		int T = Integer.parseInt(input.nextLine());
		for (int ks = 1; ks <= T; ks++) {
			String S = input.nextLine();
			System.out.println("Case #" + ks + ": "+putParanthesis(S));
		}
	}
	static String putParanthesis(final String S) {
		
		char[] chars = S.toCharArray();
		StringBuilder sb = new StringBuilder(S.length());
		for(char c:chars) {
			int val = Integer.parseInt(String.valueOf(c)); 
			sb.append(getPar(val,'('));
			sb.append(val);
			sb.append(getPar(val,')'));
		}
		int index = sb.indexOf(")(");
		while(index!=-1) {
			sb.delete(index, index+2);
			index = sb.indexOf(")(");
		}
		return sb.toString();

	}
	static StringBuilder getPar(int n,char c) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(c);
		}
		return sb;
	}
}
