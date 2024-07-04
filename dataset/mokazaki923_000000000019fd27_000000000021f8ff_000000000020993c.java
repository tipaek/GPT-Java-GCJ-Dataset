import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			System.out.println("Case #" + i + ": " + solve(in));
		}
	}

	private static String solve(Scanner in) {
		int length = in.nextInt();
		in.nextLine();
		
		int[][] valuess = new int[length][length];
		for (int row = 0; row < length; row++) {
			String[] parts = new StringBuilder(in.nextLine()).toString().split(" ");
			valuess[row] = Arrays.stream(parts).mapToInt(Integer::valueOf).toArray();
		}
		
		int vert = 0;
		for (int index = 0; index < length; index++)
			vert += valuess[index][index];
		
		boolean[] dups = new boolean[length];
		for (int row = 0; row < length; row++) {
			boolean[] used = new boolean[length];
			boolean dup = false;
			for (int col = 0; col < used.length; col++) {
				int value = valuess[row][col];
				if (used[value]) {
					dup = true;
					break;
				}
				used[value] = true;
			}
			if (dup)
				dups[row] = true;
		}
		int rowDupCount = 0;
		for (boolean b : dups)
			if (b)
				rowDupCount++;
		
		Arrays.fill(dups, false);
		for (int row = 0; row < length; row++) {
			boolean[] used = new boolean[length];
			boolean dup = false;
			for (int col = 0; col < used.length; col++) {
				int value = valuess[col][row];
				if (used[value]) {
					dup = true;
					break;
				}
				used[value] = true;
			}
			if (dup)
				dups[row] = true;
		}
		
		int colDupCount = 0;
		for (boolean b : dups)
			if (b)
				colDupCount++;
		
		return vert + " " + rowDupCount + " " + colDupCount;
		
	}

}
