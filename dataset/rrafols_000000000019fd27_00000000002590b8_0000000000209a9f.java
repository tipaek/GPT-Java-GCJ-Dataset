import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        int numTestCases = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < numTestCases; i++) {
        	String line = sc.nextLine();
        	
        	System.out.println("Case #" + (i + 1) + ": " + solve(line));
        }
	}

	private static String solve(String line) {
		StringBuilder sb = new StringBuilder();
		
		int depth = 0;
		for(int i = 0; i < line.length(); i++) {
			int k = line.charAt(i) - '0';
			
			while(k > depth) {
				sb.append("(");
				depth++;
			}
			
			while(k < depth) {
				sb.append(")");
				depth--;
			}
			
			sb.append(k);
		}
		
		while(depth > 0) {
			sb.append(")");
			depth--;
		}
		
		return sb.toString();
	}
}