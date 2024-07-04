import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		String [] words;
		int count;
		String longest;
		boolean isPossible;
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			words = new String[n];
			count = 0;
			longest = "";
			isPossible = true;
			for (int j = 0; j < n; j++) {
				String word = in.next().toString();
				words[count] = word;
				count++;
				if(word.length() >= longest.length()) {
					longest = word;
					System.out.println(longest);
				}
			}
			for(String word : words) {
				if(!longest.endsWith(word.substring(1))){
					isPossible = false;
				}
			}
			
			if(isPossible) {
				System.out.println("Case #" + i + ": " + longest.substring(1));
			} else {
				System.out.println("Case #" + i + ": *");
			}
		}
	}
}