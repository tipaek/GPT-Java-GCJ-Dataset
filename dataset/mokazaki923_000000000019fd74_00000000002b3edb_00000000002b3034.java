import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

		boolean testset1 = true;
		boolean testset2 = true;
		List<String> wordList = new ArrayList<>();
		for (int index = 0; index < length; index++) {
			String word = in.nextLine(); 
			wordList.add(word);
			int wordLength = word.length();
			if (word.replace("*", "").length() != wordLength - 1) {
				testset1 = false;
				testset2 = false;
			} else if (word.charAt(0) != '*')
				testset1 = false;
		}
		
		if (testset1) 
			return solve1(wordList);

		if (testset2)
			return solve2(wordList);
		
		wordList.sort((a,b)-> a.compareTo(b));

		String result = "*";
		return result;
	}

	private static String solve1(List<String> baseWordList) {
		List<String> wordList = new ArrayList<>();
		String longestWord = "";
		int longestLength = 0;
		for (String word : baseWordList) {
			word = word.replace("*", "");
			int wordLength = word.length();
			if (wordLength > longestLength) {
				longestLength = wordLength;
				longestWord = word;
			}
			wordList.add(word);
		}
		
		for (String word : wordList) {
			int wordLength = word.length();
			if (!longestWord.substring(longestLength - wordLength).equals(word))
				return "*";
		}
		
		return longestWord;
	}

	private static String solve2(List<String> wordList) {
		// TODO Auto-generated method stub
		return null;
	}

}
