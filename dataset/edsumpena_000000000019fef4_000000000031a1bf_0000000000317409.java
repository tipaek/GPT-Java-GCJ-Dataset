import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int x = 1; x <= t; ++x) {
			int east = in.nextInt();
			int north = in.nextInt();
			String seq = in.next();

			System.out.println("Case #" + x + ": " + solve(east, north, seq));
		}
		in.close();
	}
	
	private static String solve(int east, int north, String seq) {
		int[] pos = new int[] {east, north};
		for(int i = 0; i < seq.length(); i++) {
			switch(seq.charAt(i)) {
			case 'N':
				pos[1] += 1;
				break;
			case 'S':
				pos[1] -= 1;
				break;
			case 'E':
				pos[0] += 1;
				break;
			case 'W':
				pos[0] -= 1;
				break;
			}
			
			if(Math.abs(pos[0]) + Math.abs(pos[1]) <= i + 1)
				return String.valueOf(i + 1);
		}
		return "IMPOSSIBLE";
	}

}