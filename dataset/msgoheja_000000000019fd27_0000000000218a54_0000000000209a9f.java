import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
	
	static String balancedString(String input) {
		String output = "";
		char ch, lastCh = '\0';
		int open = 0, close = 0, tempB = 0, inputCh, nextCh = 0;
		
		input+="0";
		
		
		for(int i = 0; i < input.length()-1; i++) {
			ch = input.charAt(i);
			inputCh = Integer.parseInt(""+ch);
			nextCh = Integer.parseInt(""+input.charAt(i+1));
			
			if(ch != lastCh) {
				// Opening Bracket
				while(open < inputCh) {
					output += "(";
					open++;
					close++;
				}
				
				// Print Character
				output += ch;
				
			} else {
				output += ch;
			}
			
			// Closing Bracket based on next input
			tempB = 0;
			if(inputCh > nextCh) {
				tempB = inputCh - nextCh;
			}
			
			while(close > 0 && tempB > 0) {
				output += ")";
				tempB--;
				close--;
				open--;
			}
			
			lastCh = ch;
			
			//System.out.println("i: " + i + " -> " + output + ", open: " + open + ", close: " + close);
		}
		
		while(close > 0) {
			output += ")";
		}
		
		return output;
	}
	

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String input, output;
		int T = in.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			input = in.next();
			output = balancedString(input);
			System.out.println("Case #" + tc + ": " + output);
		}
		in.close();
	}

}
