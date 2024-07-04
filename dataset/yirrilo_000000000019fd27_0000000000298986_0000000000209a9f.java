

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main( String[] argv ) throws Exception {
		InputStream inputStream = System.in;
		String response = doJob(inputStream);
		System.out.print(response);
	}

	public static String doJob(InputStream inputStream) {
		Scanner sc = new Scanner(inputStream);
		StringBuilder solution = new StringBuilder();
		int testCaseNumber = Integer.valueOf(sc.nextLine());
		for(int i = 0; i< testCaseNumber; i++) {
			String line = sc.nextLine();

			String result = solve(line);
			solution.append("Case #"+(i+1)+": "+result+"\n");
		}
		
		return solution.toString();
	}

	private static String solve(String line) {
		String result = "";
		int[] ints = Arrays.stream(line.split("")).mapToInt(Integer::valueOf).toArray();
		int last = 0;
		
		for (int i : ints) {
			result = addIntToString(result, i, last);
			last = i;
		}
		result += addClosingBracket(ints[ints.length-1]);
		
		return result;
	}

	private static String addIntToString(String result, int current, int last) {
		String stringToAdd = "";
		if(current == last) {
			stringToAdd = ""+current;
		} else if (current > last) {
			stringToAdd = addOpeningBracketAndNewInt(last, current);
		} else {
			stringToAdd = addClosingBracketAndNewInt(last, current);
		}
		return result + stringToAdd;
	}

	private static String addClosingBracketAndNewInt(int last, int current) {
		String result = "";
		for(int i = current; i < last; i++) {
			result += ")";
		}
		return result + current;
	}

	private static String addClosingBracket(int current) {
		String result = "";
		for(int i = current; i > 0; i--) {
			result += ")";
		}
		return result;
	}

	private static String addOpeningBracketAndNewInt(int last, int current) {
		String result = "";
		for(int i = last; i < current; i++) {
			result += "(";
		}
		return result + current;
	}
}