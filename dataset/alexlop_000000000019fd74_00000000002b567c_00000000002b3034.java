import java.util.*;
import java.io.*;

public class Solution {
	
	public static void myFunction(String[] words, int caseNum) {
		Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));
		
		String temp = words[words.length - 1];
		String longest = temp.substring(1, temp.length());
		
		for(int i = 0; i < words.length - 1; i++) {
			String shortw = words[i].substring(1, words[i].length());
			int start = longest.length()-shortw.length();
			if(shortw.equals(longest.substring(start, longest.length()))) {
				
			}
			else {
				System.out.println("Case #" + caseNum + ": *");
			}
		}
		
		System.out.println("Case #" + caseNum + ": " + longest);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
			int n = in.nextInt();
			String[] words = new String[n];
			for(int k = 0; k < words.length; k++) {
				String temp = in.nextLine();
				words[k] = temp;
			}
			myFunction(words, i);
		}

	}

}
