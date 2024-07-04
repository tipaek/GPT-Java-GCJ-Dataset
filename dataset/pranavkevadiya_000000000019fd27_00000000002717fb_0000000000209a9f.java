import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String tCount = in.nextLine();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= Integer.parseInt(tCount); ++i) {
			String digits = in.nextLine();
			printDigits(i, digits);
		}
		in.close();
	}
	

	public static String getLeftBraces(int count) {
		if(count == 0) return "";
		return new String(new char[count]).replace("\0", "(");
	}
	
	public static String getRightBraces(int count) {
		if(count == 0) return "";
		return new String(new char[count]).replace("\0", ")");
	}
	 	
	public static void printDigits(int testCase, String digits) {
	   int count = 0;
	   int lastCharPosition = 0;
	   int lastDigit = 0;
	   List<Character> characters = new ArrayList<Character>();
	   
	   while(count < digits.length()) {
		   char ch = digits.charAt(count);
		   int nesting = Character.getNumericValue(ch);

		   if(count > 0) {
			   boolean increasing = nesting > lastDigit;
			   int diff = Math.abs(nesting - lastDigit);
			   if(increasing) {
				   characters.addAll(lastCharPosition + 1, getCharactersToBeInserted(ch, diff));
			   }
			   else {
				   characters.add(lastCharPosition + 1 + diff, ch);
			   }
			   lastDigit = nesting;
			   lastCharPosition = lastCharPosition + 1 + diff;			   
		   }
		   else {
			   characters.addAll(0, getCharactersToBeInserted(ch, nesting));
			   lastDigit = nesting;
			   lastCharPosition = lastCharPosition + nesting;
		   }
		   count++;
	   }
	   String output = "Case #" + testCase + ": ";
	   for (Character character : characters) {
		   output += character;
	   }
		
	   System.out.println(output);
		
	}


	private static List<Character> getCharactersToBeInserted(char ch, int diff) {
		return (getLeftBraces(diff) + ch + getRightBraces(diff)).chars().mapToObj(c -> (char) c)
				.collect(Collectors.toList());
	}

	

}
