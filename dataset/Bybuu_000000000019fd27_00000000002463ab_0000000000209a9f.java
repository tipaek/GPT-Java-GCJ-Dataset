import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Solution {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int recursive = scanner.nextInt();
		scanner.nextLine();
		for (int r = 0; r<recursive; r++) {
			
			String m = scanner.nextLine();
			Stack<Character> STACK = new Stack<Character>();
			int prev = 0;
			int number = 0;
			StringBuilder sb = new StringBuilder("");
			for(int i =0; i< m.length();i++){
				char c = m.charAt(i);
				number = Integer.parseInt(String.valueOf(c));
				if (number < prev) {
					for(int j = 0; j<prev-number; j++) {
						sb.append(')');
					}
				} else {
					for(int k = 0; k<number-prev; k++) {
						sb.append('(');
					}
				}
				sb.append(c);
				prev = number;
			}
			for(int j = 0; j<number; j++) {
						sb.append(')');
			}
			System.out.println("Case #" + (r+1) + ": "+sb.toString());
		}
	}
}