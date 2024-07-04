import java.util.Scanner;
import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception{
		//FileReader inputFile = new FileReader(new File(args[0])); // TESTING
		InputStreamReader inputFile = new InputStreamReader(System.in); // uncomment this
		Scanner in = new Scanner(new BufferedReader(inputFile));

		int t = in.nextInt();
		for(int c = 0; c < t; c++){
			String s = in.next();
			int len = s.length();

			//System.out.println("given: " + s + " " + len); // TESTING

			String sP = new String();
			for(int i = 0; i < len; i++){
				/*if(s.charAt(i) == '0'){ // 0s
					//System.out.println("0s");
					if(i>=1){ // not first char
						if(s.charAt(i-1) == '1'){
							sP += ')';
						}
					}
					 // first char or last char
					sP += "0";
				} else if (s.charAt(i) == '1'){ // 1s
					//System.out.println("1s");
					if(i>=1){ // not first char
						if(s.charAt(i-1) != '1'){ // prev char != 1
							sP += '(';
						}
					} else { // first char
						sP += '(';
					}

					sP += '1';

					if( i==len-1){ // last char
						sP += ')';
					}
				}*/

				char d = s.charAt(i);
				int digit = Character.getNumericValue(d);

				if(i == 0){ // first char
					for(int numParens = 0; numParens < digit; numParens++){
						sP += '(';
					}
				} else { // not first char
					char prevD = s.charAt(i-1);
					int prevDigit = Character.getNumericValue(prevD);

					if(prevDigit < digit){ // prev smaller num
						int numParensToAdd = digit - prevDigit;
						for(int numParens = 0; numParens < numParensToAdd; numParens++){
							sP += '(';
						}
					} else if (prevDigit == digit){ // same num
						// do nothing
					} else { // prev larger num
						int numParensToAdd = prevDigit - digit;
						for(int numParens = 0; numParens < numParensToAdd; numParens++){
							sP += ')';
						}
					}
				}

				sP += d;

				if( i==len-1){ // last char
					for(int numParens = 0; numParens < digit; numParens++){
						sP += ')';
					}
				}
				
			}

			// output
			System.out.println("Case #" + (c+1) + ": " + sP);
		}
	}

	/*private static String appendOne(char nextChar){
		String sP = new String();

		sP += '1';

		if(nextChar.length() == 0){
			return sP + ")";
		}

		if(nextChar.charAt(0) == '1'){
			sP += appendOne(nextChar.substring(1));
		}

		return sP;
	}*/
}