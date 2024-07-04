import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static void main(String[] args) {		
		int cases = Integer.parseInt(in.nextLine());
		for(int i=0; i<cases; i++) solveCase(i+1);
		
	}
	private static void solveCase(int i) {
		int depth = 0;
		StringBuilder str = new StringBuilder(); 
		
		char[] chars = in.nextLine().toCharArray();
		for(int l=0; l<chars.length; l++) {
			int el = chars[l] - '0';
			
			while(depth < el) {
				str.append('(');
				depth++;
			}
			
			while(depth > el) {
				str.append(')');
				depth--;
			}

			str.append(el);
		}

		while(depth > 0) {
			str.append(')');
			depth--;
		}
		
		System.out.println("Case #" + i + ": " + str.toString());
	}
}
