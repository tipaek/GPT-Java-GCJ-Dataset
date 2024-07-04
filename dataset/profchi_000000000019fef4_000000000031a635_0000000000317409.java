import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCases = Integer.parseInt(in.nextLine());
		
		for (int i = 0; i < testCases; ++i) {
			processInput(i + 1);
		}
	}
	
	public static void printResult(int current, int result) {
		String value = result == -1? "IMPOSSIBLE" : result + "";
		System.out.println("Case #" + current + ": " + value);
	}
	
	public static void processInput(int testCase) {
		String line = in.nextLine();
		String [] lineInputs = line.split(" ");
		int x = Integer.parseInt(lineInputs[0]);
		int y = Integer.parseInt(lineInputs[1]);
		
		int result = solve (x, y, lineInputs[2]);
		printResult(testCase, result);
	}
	
	public static List<List<Integer>> helper(int [] diag, int T) {
		return null;
	}
	
	public static int solve(int x , int y, String moves) {
		if (x == 0 && y == 0)
			return 0;
		
		int absDist;
		for (int i = 0; i < moves.length(); ++i) {
			char c = moves.charAt(i);
			if (c == 'N')
				++y;
			else if (c == 'S')
				--y;
			else if (c == 'E')
				++x;
			else if (c == 'W')
				--x;
			absDist = Math.abs(x) + Math.abs(y);
			if (absDist <= i + 1) {
				return i + 1;
			}
		}
		
		return -1;
	}

}
