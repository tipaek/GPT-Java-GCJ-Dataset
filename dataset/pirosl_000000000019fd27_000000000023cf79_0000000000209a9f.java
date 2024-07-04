import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); 
        for (int i = 1; i <= t; ++i) {
          String s = in.nextLine();
          process(i, s);
        }
	}
	
	static void process(int i, String s) {
		Stack<Character> stack = new Stack<>();
		int level = 0;
		for (int idx = 0; idx < s.length(); ++idx) {
			char c = s.charAt(idx);
			int desiredLevel = c - '0';
			
			while (level < desiredLevel) {
				stack.push('(');
				++level;
			}
			while (level > desiredLevel) {
				stack.push(')');
				--level;
			}
			stack.push(c);
		}
		
		while (level > 0) {
			stack.push(')');
			--level;
		}
		
		StringBuffer sb = new StringBuffer();
		for (Character c : stack) {
			sb.append(c);
		}
		
		System.out.println("Case #" + i + ": " + sb.toString());
	}

}
