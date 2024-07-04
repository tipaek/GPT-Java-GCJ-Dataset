import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int open, close, inputCh;
		String input, output;
		char ch, lastCh;
		int T = in.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			input = in.next();
			
			open = close = 0;
			output = "";
			lastCh = '\0';
			
			for(int i = 0; i < input.length(); i++) {
				ch = input.charAt(i);
				inputCh = Integer.parseInt(""+ch);
				
				if(ch != lastCh) {
					while(open > 0) {
						output += ")";
						open--;
					}
					if(inputCh == 1) {
						output += ("(" + ch);
						open++;
					} else {
						output += ch;
					}
				} else {
					output += ch;
				}
				lastCh = ch;
			}
			
			if(open > 0) {
				while(open-- > 0) {
					output += ")";
				}
			}
			
			System.out.println("Case #" + tc + ": " + output);
		}
		in.close();
	}

}
