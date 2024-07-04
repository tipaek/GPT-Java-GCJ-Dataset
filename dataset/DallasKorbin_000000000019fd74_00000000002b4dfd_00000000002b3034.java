import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for(int i = 0; i < numTests; i++) {
    	int testCaseInput = in.nextInt();
    	
    	ArrayList<String> words = new ArrayList<>();
    	for(int j = 0; j < testCaseInput ; j++) {
    		words.add(in.next());
    	}
    	
    	String answer = calculateAnswer(words);
    	
    	System.out.println("Case #" + (i+1) + ": " + answer);
    }
    in.close();
  }

	private static String calculateAnswer(ArrayList<String> words) {
		String answer = "*";

		for (String word : words) {
			String possibleAnswer = word.replace("*", "");
			if (checkIfCorrect(possibleAnswer, words)) {
				return possibleAnswer;
			}
		}

		return answer;
	}

	private static boolean checkIfCorrect(String possibleAnswer, ArrayList<String> words) {

		for (String word : words) {
			if (!Pattern.matches(word.replace("*", ".*"), possibleAnswer)) {
				return false;
			}
		}

		return true;
	}
}