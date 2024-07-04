
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
		//test();
		final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final int t = Integer.parseInt(in.nextLine());
		for (int x = 1; x <= t; ++x) {
			in.nextLine();
			System.out.println("Case #" + x + ": " + getResult(readGuesses(in)));
		}
		in.close();
	}
	
	private static Guess[] readGuesses(final Scanner in) {
		final int count = 10000;
		Guess[] guesses = new Guess[count];
		for(int i = 0; i < count; i++) {
			String[] line = in.nextLine().split(" ");
			guesses[i] = new Guess(line[1]);
		}
		return guesses;
	}
	
	private static class Guess {
		public Guess(String result) {
			super();
			this.characters = result.toCharArray();
		}
		private final char[] characters;
	}
		
	// Start with D <= 3.
	private static String getResult(final Guess[] guesses) {	
		Map<Character, Integer> distribution = new HashMap<>();
		
		for(int i = 0; i < guesses.length; i++) {
			final Guess guess = guesses[i];
			for(char c : guess.characters) {
				if(!distribution.containsKey(c)) distribution.put(c, 0);
				int num = distribution.get(c) + 1;
				distribution.put(c, num);
			}
		}
			char lowestChar = '0';
			int lowestCount = Integer.MAX_VALUE;
			for(char c : distribution.keySet()) {
				if (distribution.get(c) < lowestCount) {
					lowestChar = c;
					lowestCount = distribution.get(c);
				}
			}
			String result = Character.toString(lowestChar);
			distribution.remove(lowestChar);
			while(distribution.size() > 0) {
				char highest = '0';
				int highestCount = 0;
				for(char c : distribution.keySet()) {
					if (distribution.get(c) > highestCount) {
						highest = c;
						highestCount = distribution.get(c);
					}
				}
				result += Character.toString(highest);
				distribution.remove(highest);
			}
			return result;
	}
	
}
