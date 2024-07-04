
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	private static void test() throws IOException {
		String s;
		BufferedReader read = new BufferedReader(new FileReader("data/testIn"));
		String total = "";
		while((s = read.readLine())!= null) total += s + "\n";
		InputStream testInput = new ByteArrayInputStream( total.getBytes("UTF-8") );
		System.setIn(testInput);
		read.close();
	}

	public static void main(String[] args) throws IOException {
//		test();
		final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final int t = Integer.parseInt(in.nextLine());
		for (int x = 1; x <= t; ++x) {
			String wh = in.nextLine();
			long maxNum = wh.equals("2") ? 99 : 9999999999999999l;
			System.out.println("Case #" + x + ": " + getResult(readGuesses(in, maxNum)));
		}
		in.close();
	}
	
	private static Guess[] readGuesses(final Scanner in, final long maxNum) {
		final int count = 10000;
		Guess[] guesses = new Guess[count];
		for(int i = 0; i < count; i++) {
			String[] line = in.nextLine().split(" ");
			long num = Long.parseLong(line[0]);
			if (num == -1) num = maxNum;
			guesses[i] = new Guess(num, line[1]);
		}
		return guesses;
	}
	
	private static class Guess {
		public Guess(long num, String result) {
			super();
			this.num = num;
			this.characters = result.toCharArray();
		}
		private final long num;
		private final char[] characters;
	}
		
	// Start with D <= 3.
	private static String getResult(final Guess[] guesses) {
		Set<Character> allCharacters = new HashSet<>();
		Set<Character> allNonZeroCharacters = new HashSet<>();
		Map<Character, Integer> maxNum = new HashMap<>();
		List<Set<Character>> options = new ArrayList<>();
		for(int i = 0; i < 10; i++) options.add(new HashSet<Character>());
		
		for(int i = 0; i < guesses.length; i++) {
			final Guess guess = guesses[i];
//			System.out.println("Evaluating " + String.valueOf(guess.characters));
			if(guess.num < 10) {
				final char ch = guess.characters[0];
				allNonZeroCharacters.add(ch);
				allCharacters.add(ch);
				evaluateMaxnum(maxNum, 1, (int)guess.num, ch, options);
			} else if (Long.toString(guess.num).length() == guess.characters.length) {
				evaluateFullLengthGuess(guess, allCharacters, allNonZeroCharacters, maxNum, options);
			} else {
				for(char c : guess.characters) allCharacters.add(c);
			}
		}
		
		Set<Character> determined = new HashSet<>();
		String result = "";
		for(int i = 9; i >= 1; i--) {
			Set<Character> option = options.get(i);
			if(option.size() > 1) {
				System.out.println("ERROR");
				System.exit(1);;
			}
			String chS = "";
			char xc = '0';
			for(Character c : option) {
				result = Character.toString(c) + result;
				xc = c;
			}
			allCharacters.remove(xc);
			for(int j = i-1; j >= 1; j--) options.get(j).remove(xc);
		}
		if(allCharacters.size() > 1) {
			System.out.println("ERROR");
			System.exit(1);;
		}
		for(Character c : allCharacters) {
			result = Character.toString(c) + result;
		}
		//System.out.println(allCharacters.size());
		//System.out.println(allNonZeroCharacters.size());
		//for(int i = 0; i < 10; i++) System.out.println(i +": " + options.get(i).size());
		return result;
	}
	
	private static void evaluateMaxnum(final Map<Character, Integer> maxNum, final int minNum, final int maxNumHere, final char ch, final List<Set<Character>> options) {
		if(!maxNum.containsKey(ch)) {
			//System.out.println("Adding " + ch + " as " + maxNumHere + " (Min: " + minNum + ")");
			maxNum.put(ch, maxNumHere);
			for(int k = minNum; k <= maxNumHere; k++) options.get(k).add(ch);
		} else if (maxNum.get(ch) > maxNumHere){
			//System.out.println("Reducing " + ch + " to " + maxNumHere);
			for(int k = maxNumHere + 1; k <= maxNum.get(ch); k++) options.get(k).remove(ch);
			maxNum.put(ch, maxNumHere);
		}
	}
	
	private static int firstDigit(long n) 
	{ 
	    while (n >= 10)  
	        n /= 10; 
	    return (int)n; 
	} 
	
	private static void evaluateFullLengthGuess(final Guess guess, final Set<Character> allCharacters, final Set<Character> allNonZeroCharacters, final Map<Character, Integer> maxNum, List<Set<Character>> options) {
		// Simplifying for now. There are situations where other chars might be fixed.
		evaluateMaxnum(maxNum, 1, firstDigit(guess.num), guess.characters[0], options);
		for(int i = 0; i < guess.characters.length; i++) {
			final char c = guess.characters[i];
			if (i > 0) allNonZeroCharacters.add(c);
			allCharacters.add(c);
		}
		
		/*long div = 1;
		
		for(int i = 0; i < guess.characters.length; i++) {
			int digit = (int)((guess.num / div) % 10);
			final char c = guess.characters[guess.characters.length-1-i];
			final int min = i + 1 == guess.characters.length ? 1 : 0;
			if (min > 0) allNonZeroCharacters.add(c);
			allCharacters.add(c);
			for(int j = min; j <= digit; j++) {
				evaluateMaxnum(maxNum, min, digit, c, options);
			}
			div = div * 10l;
		}*/
	}
	
}
