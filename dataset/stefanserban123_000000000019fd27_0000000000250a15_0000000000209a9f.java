
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = sc.nextInt();
		sc.nextLine(); // sometimes necesary after nextInt to go to next line
		
		for (int i=1; i<=tests; i++) {
			String input = sc.nextLine();
			System.out.println(solve(input, i));
		}
		
	}
	
	public static String solve (String input, int tc) {
		
		String[] source = input.split("");
		int depth = 48;
		String out = "";
		
		for (int i=0;i<source.length;i++) {
			int e = (int) input.charAt(i);
			
			if (e > depth) {
				out += repeatChar("(", e - depth) + input.charAt(i);
			} else if (e < depth) {
				out += repeatChar(")", depth - e) + input.charAt(i);
			} else {
				out += input.charAt(i);
			}
			
			depth = e;
		}
		
		out += repeatChar(")", depth - 48);
		
		return "Case #" + tc + ": " + out;
	}
	
	private static String repeatChar(String c, int n) {
		return String.join("", Collections.nCopies(n, c));
	}
}
