import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cases = in.nextInt();
		
		for(int i = 1; i <= cases; i++) {
			int depth = 0;
			String input = in.next();
			String solution = "";
			int val = 0;
			
			for(int j = 0; j < input.length(); j++) {
				val = Integer.parseInt(String.valueOf(input.charAt(j)));

				while(depth < val) {
					solution += "(";
					depth++;
				}
				while(depth > val) {
					solution += ")";
					depth--;
				}
				solution += val;
			}
			while (depth > 0) {
				solution += ")";
				depth--;
			}
			System.out.println("Case #" + i + ": " + solution);
		}
	}
}