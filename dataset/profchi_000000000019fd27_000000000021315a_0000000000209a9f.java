import java.util.Arrays;
import java.util.HashSet;
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
	
	public static void printResult(int current, String result) {
		System.out.println("Case #" + current + ": " + result);
	}
	
	public static void processInput(int testCase) {
		String input = in.nextLine();
		solve(input.trim(), testCase);
	}
	
	public static void solve(String text, int testCase) {
		StringBuilder result =  new StringBuilder();
		int currentNum;
		int bracketsCount = 0;
		for (int i = 0; i < text.length(); ++i) {
			currentNum = text.charAt(i) - 48;
			if(currentNum > bracketsCount) {
				while (currentNum > bracketsCount) {
					result.append('(');
					++bracketsCount;
				}
			}
			if(currentNum < bracketsCount) {
				while (currentNum < bracketsCount) {
					result.append(')');
					--bracketsCount;
				}
			}
			result.append(currentNum);
		}
		
		while (bracketsCount > 0) {
			result.append(')');
			--bracketsCount;
		}
		
		printResult(testCase, result.toString());
		
	}
	
	public static void helper() {
		
	}


}