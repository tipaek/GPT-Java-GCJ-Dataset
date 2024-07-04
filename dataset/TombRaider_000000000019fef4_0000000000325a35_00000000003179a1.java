
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	// task 2
      
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int u = in.nextInt();
			String result = "";
			// prepare
			String [] letteroptions = new String[10];
			int [] occurences = new int [10]; // letteroption x, letter y -> how often
			for (int k=0;k<10; k++) {
				letteroptions[k] = new String ();
			}
			
			for (int j=0; j<10000; j++) {
				//read
				int number = in.nextInt();
				String letters = in.next();
				if ((number != -1) && ((number + "").length() == letters.length())) {
					//for restriction, let's be picky and only have a look at the first digit
					//restrict
					int firstdigit = Integer.parseInt( ((number + "").substring(0, 1)) );
					String firstLetter = letters.substring(0,1);
					// first letter is evidently possible for that first digit
					if (!letteroptions[firstdigit].contains(firstLetter)){
						letteroptions[firstdigit] += firstLetter;
					//	System.out.println("["+number+","+letters+"] leads to ["+firstdigit+","+firstLetter+"]");
					}
					// 0 is always an option
					if (!letteroptions[0].contains(letters.substring(letters.length()-1, letters.length()))){
						letteroptions[0] += letters.substring(letters.length()-1, letters.length());
				//		System.out.println("["+number+","+letters+"] leads to [0,"+letters.substring(letters.length()-1, letters.length())+"]");
					}
				} else if (number == -1) {
					// 1-9
					if (letters.length()>1) {
						String firstLetter = letters.substring(0,1);
						if (!letteroptions[1].contains(firstLetter)){
							letteroptions[1] += firstLetter;
						}
						occurences [letteroptions[1].indexOf(firstLetter)] += 1;
					}
					// 0
					if (!letteroptions[0].contains(letters.substring(letters.length()-1, letters.length()))){
						letteroptions[0] += letters.substring(letters.length()-1, letters.length());
					}
				}
			}
			// debug output
//			for (int gg = 1; gg <= 10; gg++) {
//				System.out.println(gg + " : " + letteroptions[gg % 10]);
//			}
			if (!letteroptions[2].equals("")) {
				// check restrictions
				// set for 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
				for (int setters = 1; setters<=10; setters++) {
					String resultNow = "";
					if (letteroptions [setters % 10].length() == 1) {
						resultNow = letteroptions[setters % 10];
					} else {
						resultNow = letteroptions[setters % 10].charAt(0) + "";
					}
					//remove results from all
					for (int jo=0; jo<10; jo++) {
						letteroptions[jo] = letteroptions[jo].replace(resultNow, "");
					}
					//add to result string
					if (setters != 10) {
						result += resultNow;
					} else {
						// 0 is first
						result = resultNow + result;
					}
				}
			} else {
				// identify 0
				for (int jap=0; jap<letteroptions[1].length(); jap++) {
					// 0 is never at the front
					letteroptions[0] = letteroptions[0].replace(letteroptions[1].charAt(jap)+"", "");
				}
				result = letteroptions[0];
				// 1-9 heuristic
				for (int huhu = 1; huhu<= 9; huhu++) {
					//find most often occuring one
					int max = 0;
					int maxindex = -1;
					for (int yes = 0; yes <letteroptions[1].length(); yes++) {
						if (occurences[yes] > max) {
							max = occurences[yes];
							maxindex = yes;
						}
					}
					result += letteroptions[1].charAt(maxindex);
					occurences[maxindex]=-1;
				}
			}
			
			
            System.out.println("Case #"+i+": "+result);
		}
	}
}
