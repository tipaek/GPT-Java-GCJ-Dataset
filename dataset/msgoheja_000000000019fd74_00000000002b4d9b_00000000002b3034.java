import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int N;
		String input, output, dict;
		boolean flag = true;
		int T = in.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = in.nextInt();
			flag = true;
			output = "*";
			input = in.next();
			if(input.startsWith("*")) {
				dict = input.substring(1);
				for(int i = 1; i < N; i++) {
					input = in.next();
					
					if(flag) {
						input = input.replaceFirst("\\*", "");
						if(input.length() >= dict.length()) {
							if(input.endsWith(dict)) {
								dict = input;
							} else {
								flag = false;
							}
						} else if(input.length() < dict.length()) {
							if(!dict.endsWith(input)) {
								flag = false;
							}
						}
					}
				}
				
				if(flag) {
					output = dict;
				}
			} else {
				break;
			}
			
			System.out.println("Case #" + tc + ": " + output);
		}
		in.close();
	}
}
