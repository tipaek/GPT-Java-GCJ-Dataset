
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int u = in.nextInt();
			String result = "";
			// prepare
			String [] letteroptions = new String[2];
			int [] occurences = new int [10]; // letteroption x, letter y -> how often
			for (int k=0;k<2; k++) {
				letteroptions[k] = new String ();
			}
			
			for (int j=0; j<10000; j++) {
				//read
				int number = in.nextInt();
				String letters = in.next();
				// 1-9
				if (letters.length()>1) {
					String firstLetter = letters.substring(0,1);
					if (!letteroptions[1].contains(firstLetter)){
						letteroptions[1] += firstLetter;
						//System.out.println(letteroptions);
					}
					occurences [letteroptions[1].indexOf(firstLetter)] += 1;
				}
				// 0
				if (!letteroptions[0].contains(letters.substring(letters.length()-1, letters.length()))){
					letteroptions[0] += letters.substring(letters.length()-1, letters.length());
				}
			}
				// identify 0
				for (int jap=0; jap<letteroptions[1].length(); jap++) {
					// 0 is never at the front
					letteroptions[0] = letteroptions[0].replace(letteroptions[1].charAt(jap)+"", "");
				}
				result = letteroptions[0];
				// 1-9 heuristic
				for (int a=0; a<9; a++) {
					System.out.println(a +":" +occurences[a] +" : "+letteroptions[1].charAt(a) + "");
				}
				for (int huhu = 1; huhu<= 9; huhu++) {
					//find most often occuring one
					int max = 0;
					int maxindex = -1;
					for (int yes = 0; yes < letteroptions[1].length(); yes++) {
						if (occurences[yes] > max) {
							max = occurences[yes];
							maxindex = yes;
						}
					}
					result += letteroptions[1].charAt(maxindex) + "";
					occurences[maxindex]=-1;
				}
			
	        System.out.println("Case #"+i+": "+result);
		}
	}
}
