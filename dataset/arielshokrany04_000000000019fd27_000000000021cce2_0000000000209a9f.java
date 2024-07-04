import java.util.Scanner;
import java.io.*;
class Solution {
	public static String out;
		static Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static void main(String[] args) {
		    int T = Integer.valueOf(input.nextLine());
		    String out = "";
		    for (int i = 1; i <= T; ++i) {
		    	String S = input.nextLine();
		    	out += solve(S,i)+"\n";
		    }
		   System.out.println(out);
	}
	public static String solve(String S,int num) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < S.charAt(0)-48; i++) {
			out.append('(');
		}
		out.append(S.charAt(0));
		for (int j = 1; j < S.length(); j++) {
			int A = S.charAt(j-1)-48;
			int B = S.charAt(j)-48;
			if(A > B) {
				for (int i = 0; i < A - B; i++) {
					out.append(')');
				}
			}
			else if(A < B) {
				for (int i = 0; i < B - A; i++) {
					out.append('(');
				}
			}
			out.append(S.charAt(j));
		}
		for (int i = 0; i < S.charAt(S.length()-1)-48; i++) {
			out.append(')');
		}
		return "Case #"+num+": "+out.toString();
	}

}