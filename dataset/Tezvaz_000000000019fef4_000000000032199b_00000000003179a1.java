import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int totalTestCases = Integer.parseInt(in.nextLine());

		for(int i = 0; i < totalTestCases; i++) {
			
			int U = Integer.parseInt(in.nextLine());
			String[] queries = new String[10000];
			String[] res = new String[10000];
			HashSet<Character> allLetters = new HashSet<Character>();
			HashSet<Character> allLettersExceptO = new HashSet<Character>();
			
			for(int j = 0; j < 10000; j++) {
				String nextLine = in.nextLine();
				queries[j] = nextLine.split(" ")[0];
				res[j] = nextLine.split(" ")[1];
				
				for(int k = 0; k < res[j].length(); k++) {
					
					if(k == 0) {
						allLettersExceptO.add(res[j].charAt(k));
					}
					allLetters.add(res[j].charAt(k));
				}
				
			}
			
			Character zerothLetter = 'A';
			Character firstLetter = 'A';
			Character secLetter = 'A';
			Character thirdLetter = 'A';
			Character fourthLetter = 'A';
			Character fifthLetter = 'A';
			Character sixthLetter = 'A';
			Character seventhLetter = 'A';
			Character eigthLetter = 'A';
			Character ninthLetter = 'A';
			
			for(Character c : allLetters) {
				if(!allLettersExceptO.contains(c)) {
					zerothLetter = c;
				}
			}
			
			//1st number 1 and res length same as query length
			for(int j = 0; j < 10000; j++) {
				if(res[j].length() == queries[j].length()) {
					
					if(queries[j].charAt(0) == '1') {
						firstLetter = res[j].charAt(0);
					}
				}
			}
			
			//2nd number
			for(int j = 0; j < 10000; j++) {
				if(res[j].length() == queries[j].length()) {
					
					if(queries[j].charAt(0) == '2' && res[j].charAt(0) != firstLetter) {
						secLetter = res[j].charAt(0);
					}
				}
			}
			
			//3rd number
			for(int j = 0; j < 10000; j++) {
				if(res[j].length() == queries[j].length()) {
					
					if(queries[j].charAt(0) == '3' && res[j].charAt(0) != firstLetter && res[j].charAt(0) != secLetter) {
						thirdLetter = res[j].charAt(0);
					}
				}
			}
			
			//4th number
			for(int j = 0; j < 10000; j++) {
				if(res[j].length() == queries[j].length()) {
					
					if(queries[j].charAt(0) == '4' && res[j].charAt(0) != firstLetter && res[j].charAt(0) != secLetter && res[j].charAt(0) != thirdLetter) {
						fourthLetter = res[j].charAt(0);
					}
				}
			}
			
			//5th
			for(int j = 0; j < 10000; j++) {
				if(res[j].length() == queries[j].length()) {
					
					if(queries[j].charAt(0) == '5' && res[j].charAt(0) != firstLetter && res[j].charAt(0) != secLetter && res[j].charAt(0) != thirdLetter
							&& res[j].charAt(0) != fourthLetter) {
						fifthLetter = res[j].charAt(0);
					}
				}
			}
			
			//6th
			for(int j = 0; j < 10000; j++) {
				if(res[j].length() == queries[j].length()) {
					
					if(queries[j].charAt(0) == '6' && res[j].charAt(0) != firstLetter && res[j].charAt(0) != secLetter && res[j].charAt(0) != thirdLetter
							&& res[j].charAt(0) != fourthLetter
							&& res[j].charAt(0) != fifthLetter) {
						sixthLetter = res[j].charAt(0);
					}
				}
			}
			
			//7th
			for(int j = 0; j < 10000; j++) {
				if(res[j].length() == queries[j].length()) {
					
					if(queries[j].charAt(0) == '7' && res[j].charAt(0) != firstLetter && res[j].charAt(0) != secLetter && res[j].charAt(0) != thirdLetter
							&& res[j].charAt(0) != fourthLetter
							&& res[j].charAt(0) != fifthLetter
							&& res[j].charAt(0) != sixthLetter) {
						seventhLetter = res[j].charAt(0);
					}
				}
			}
			
			//8th
			for(int j = 0; j < 10000; j++) {
				if(res[j].length() == queries[j].length()) {
					
					if(queries[j].charAt(0) == '8' && res[j].charAt(0) != firstLetter && res[j].charAt(0) != secLetter && res[j].charAt(0) != thirdLetter
							&& res[j].charAt(0) != fourthLetter
							&& res[j].charAt(0) != fifthLetter
							&& res[j].charAt(0) != sixthLetter
							&& res[j].charAt(0) != seventhLetter) {
						eigthLetter = res[j].charAt(0);
					}
				}
			}
			
			//9th
			for(int j = 0; j < 10000; j++) {
				if(res[j].length() == queries[j].length()) {
					
					if(queries[j].charAt(0) == '9' && res[j].charAt(0) != firstLetter && res[j].charAt(0) != secLetter && res[j].charAt(0) != thirdLetter
							&& res[j].charAt(0) != fourthLetter
							&& res[j].charAt(0) != fifthLetter
							&& res[j].charAt(0) != sixthLetter
							&& res[j].charAt(0) != seventhLetter
							&& res[j].charAt(0) != eigthLetter) {
						ninthLetter = res[j].charAt(0);
					}
				}
			}
			
			System.out.println("Case #" + (i+1) + ": " + zerothLetter + firstLetter + secLetter + thirdLetter + fourthLetter + fifthLetter + sixthLetter + seventhLetter + eigthLetter + ninthLetter);
		}
		
		in.close();
	}
}
