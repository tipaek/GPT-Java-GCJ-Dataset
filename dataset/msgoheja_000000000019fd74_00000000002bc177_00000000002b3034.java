import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static String[] processInput(String input) {
		String[] output = {"", "*", ""};
		
		StringTokenizer str = new StringTokenizer(input, "*", true);
		String inp = "";
		int index = 0;
		while(str.hasMoreElements()) {
			inp = str.nextElement().toString();
			
			if(inp.equals("*")) {
				index = 1;
			} else {
				output[index] = inp;
			}
			index++;
		}
		
		return output;
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int N;
		String output, inpt;
		String[] input, dict;
		boolean flag = true;
		int T = in.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = in.nextInt();
			flag = true;
			output = "*";
			
			input = new String[3];
			dict = new String[3];
			
			inpt = in.next();
			
			dict = processInput(inpt);
			
			for(int i = 1; i < N; i++) {
				inpt = in.next();
				
				if(flag) {
					input = processInput(inpt);
					
					if(input[0].length() >= dict[0].length() && input[0].startsWith(dict[0])) {
						dict[0] = input[0];
						
						
						if(input[2].length() >= dict[2].length() && input[2].endsWith(dict[2])) {
							dict[2] = input[2];
						} else if(input[2].length() < dict[2].length() && dict[2].endsWith(input[2])) {

						} else {
							flag = false;
						}
					} else if(input[0].length() < dict[0].length() && dict[0].startsWith(input[0])) {
						if(input[2].length() >= dict[2].length() && input[2].endsWith(dict[2])) {
							dict[2] = input[2];
						} else if(input[2].length() < dict[2].length() && dict[2].endsWith(input[2])) {

						} else {
							flag = false;
						}
					} else {
						flag = false;
					}
				}
			}
			
			if(flag) {
				output = (dict[0] + "" + dict[2]);
			}
			System.out.println("Case #" + tc + ": " + output);
		}
		in.close();
	}
}
