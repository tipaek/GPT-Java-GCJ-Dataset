import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public String solve(String S) {
		int cur = 0;
		StringBuilder ans = new StringBuilder("");
		
		
		for(int i = 0; i < S.length(); i++) {
			char next = S.charAt(i);
			
			int target = (int)(next - '0');
			while( cur != target) {
				if(cur < target) {
					ans.append('(');
					cur++;
				}
				else {
					ans.append(')');
					cur--;
				}
			}
			ans.append(next);
		}
		
		while( cur != 0) {
			ans.append(')');
			cur--;
		}
		
		return ans.toString();
	}
	
	public static void mainX(String[] args) {
		Solution Q = new Solution();
		System.out.println(Q.solve("123"));
		System.out.println(Q.solve("0000"));
		System.out.println(Q.solve("101"));
		System.out.println(Q.solve("111000"));
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution Q = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			String S = in.nextLine();
			String ans = Q.solve(S);
			System.out.println("Case #" + i + ": " + ans);
			System.out.flush();
		}
	}

}
