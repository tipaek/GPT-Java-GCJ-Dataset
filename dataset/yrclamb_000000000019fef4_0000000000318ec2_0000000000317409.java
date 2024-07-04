import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public String solve(int X, int Y, String path) {
		int cur = 0;
		if(X == 0 && Y == 0) return "0";
		for(int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			if(c == 'N') Y++;
			else if(c == 'S') Y--;
			else if(c == 'W') X--;
			else if(c == 'E') X++;
			cur++;
			if(Math.abs(X) + Math.abs(Y) <= cur) return cur + "";
		}
		
		return "IMPOSSIBLE";
	}
	
	public static void mainX(String[] args) {
		Solution Q = new Solution();
		System.out.println(Q.solve(4, 4, "SSSS"));
		System.out.println(Q.solve(3, 0, "SNSS"));
		System.out.println(Q.solve(2, 10, "NSNNSN"));
		System.out.println(Q.solve(0, 1, "S"));
		System.out.println(Q.solve(2, 7, "SSSSSSSS"));
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution Q = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			int X = in.nextInt();
			int Y = in.nextInt();
			String s = in.next();
			in.nextLine();
			String output = Q.solve(X, Y, s);
			System.out.println("Case #" + i + ": " + output);
			System.out.flush();
		}
	}

}
