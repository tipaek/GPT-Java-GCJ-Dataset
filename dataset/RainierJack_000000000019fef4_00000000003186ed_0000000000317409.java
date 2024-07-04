import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		PrintStream out = System.out;
		int T = in.nextInt();
			
		for (int t=0; t<T; t++) {
			
			int X = in.nextInt();
			int Y = in.nextInt();
			String M = in.next();
			
			String res = solve(X,Y,M);
			out.println(String.format("Case #%d: %s", t+1, res));
		}
		
		in.close();
	}

	public static String solve (int X, int Y, String M) {
		int x = X;
		int y = Y;
		int size = M.length();
		
		for (int i=0; i<size; i++) {
			char c = M.charAt(i);
			switch (c) {
			case 'N':
				y++;
				break;
			case 'S':
				y--;
				break;
			case 'W':
				x--;
				break;
			case 'E':
				x++;
				break;
			}
			int d = Math.abs(x)+Math.abs(y);
			if (d <= i+1)
				return Integer.toString(i+1);
		}
		return "IMPOSSIBLE";
	}
	
}
