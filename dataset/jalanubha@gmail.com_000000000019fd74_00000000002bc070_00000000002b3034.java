import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for(int x = 0; x < T; x++) {
			String input = "";			
			int N = Integer.parseInt(sc.nextLine());
			String[][] inputs = new String[N][100];
			String[] s = new String[N];
			String[][] maxlens = new String[N][2];
			String maxPrefix = "";
			String maxSuffix = "";
			for (int i = 0; i < N; i++) {
				String temp = sc.nextLine();
				s[i] = temp;
				if(temp.charAt(0) == '*') {
					temp = "_" + temp;
				}
				if(temp.charAt(temp.length() - 1) == '*') {
					temp = temp + "_";
				}
				inputs[i] = temp.split("[*]");
				
				
				if(inputs[i][0].length() > maxPrefix.length()) {
					maxPrefix = inputs[i][0];
				}
				if(inputs[i][inputs[i].length - 1].length() > maxSuffix.length()) {
					maxSuffix = inputs[i][inputs[i].length - 1];
				}
			}
			
			input = maxPrefix + maxSuffix;
			input = input.replaceAll("_", "").replaceAll("[*]", "");
			for (int i = 0; i < N; i++) {
				if(maxPrefix.indexOf(inputs[i][0]) == 0 || inputs[i][0].contentEquals("_")) continue;
				else {
					input = "*";
					break;
				}
			}
			
			if (input != "*") {
				int sufLen = maxSuffix.length();
				for (int i = 0; i < N; i++) {
					int len = inputs[i].length;
					int ipSufLen = inputs[i][len - 1].length();
					if(maxSuffix.substring(sufLen - ipSufLen).contentEquals(inputs[i][len - 1]) || inputs[i][len - 1].contentEquals("_")) continue;
					else {
						input = "*";
						break;
					}
				}
			}

			System.out.format("Case #%d: %s\n", (x + 1), input);
		}
		
		
		sc.close();
	}
}
