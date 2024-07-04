import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

		boolean isPossible;
		String solutionS;
		String solutionE;
		String wordS;
		String wordE;
		int index;
		
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			
			isPossible = true;
			solutionS = "";
			solutionE = "";
			index = 0;
			
			for (int j = 0; j < n; j++) {
				String word = in.next().toString();
				index = word.indexOf("*");
				wordS = word.substring(0, index);
				//System.out.println(wordS);

				if(index < word.length()) {
					wordE = word.substring(index + 1);
				} else {
					wordE = word.substring(index);
				}

				//System.out.println(index);
				
				if(index > 0) {
					if(wordS.length() >= solutionS.length()) {
						if(wordS.startsWith(solutionS)) {
							solutionS = wordS;
							//System.out.println("new solutionS : "+solutionS);
						} else {
							isPossible = false;
						}
					} else {
						if(!solutionS.startsWith(wordE)) {
							isPossible = false;
						}
					}
				}
				
				if(index < word.length()) {
					if(wordE.length() >= solutionE.length()) {
						if(wordE.endsWith(solutionE)) {
							solutionE = wordE;
							//System.out.println("new solutionE : "+solutionE);
						} else {
							isPossible = false;
						}
					} else {
						if(!solutionE.endsWith(wordE)) {
							isPossible = false;
						}
					}
				}
			}
			
			if(isPossible) {
				System.out.println("Case #" + i + ": " + solutionS + solutionE);
			} else {
				System.out.println("Case #" + i + ": *");
			}
			
		}
	}
}