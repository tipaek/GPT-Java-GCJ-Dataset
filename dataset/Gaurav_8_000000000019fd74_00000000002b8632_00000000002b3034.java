
import java.util.Scanner;

public class Solution {

	public static String func(String str1, String str2) {
		StringBuffer ans = new StringBuffer();
		boolean[][] arr = new boolean[str1.length()][str2.length()];
		arr[0][0] = true;
		for(int i = 0; i < str1.length(); i++) {
			for(int j = 0; j < str2.length(); j++) {
				if(str1.charAt(i) == '*' || str2.charAt(j) == '*') {
					if(i > 0) {
						arr[i][j] |= arr[i - 1][j];
					}
					if(j > 0) {
						arr[i][j] |= arr[i][j - 1];
					}
				} else if(str1.charAt(i) == str2.charAt(j) && i > 0 && j > 0) {
					arr[i][j] = arr[i - 1][j - 1];
				}
			}
		}
		if(!arr[str1.length() - 1][str2.length() - 1]) {
			return "";
		}
		int i = str1.length() - 1, j = str2.length() - 1;
		while(i >= 0 && j >= 0) {
			if(str2.charAt(j) == '*') {
				if(i > 0 && arr[i - 1][j]) {
					ans.append(str1.charAt(i));
					i--;
				} else if(j > 0 && arr[i][j - 1]) {
					ans.append(str2.charAt(j));
					j--;
				} else {
					return "";
				}
			} else if(str1.charAt(i) == '*') { 
				if(j > 0 && arr[i][j - 1]) {
					ans.append(str2.charAt(j));
					j--;
				} else if(i > 0 && arr[i - 1][j]) {
					ans.append(str1.charAt(i));
					i--;
				} else {
					return "";
				}
			}	else if(str1.charAt(i) == str2.charAt(j)) {
				ans.append(str1.charAt(i));
				i--;
				j--;
			} else {
				return "";
			}
		}
		String temp = ans.toString();
		ans = new StringBuffer();
		for(i = temp.length() - 1; i >= 0; i--) {
			ans.append(temp.charAt(i));
		}
		return ans.toString();
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt(), testCase = 1;
		while(t-->0) {
			int n = s.nextInt();
			String[] patterns = new String[n];
			for(int i = 0; i < n; i++) {
				patterns[i] = "X" + s.next();
			}
			String pat = "X*";
			for(int i = 0; i < n; i++) {
				pat = func(pat, patterns[i]);
				if(pat.equals("")) {
					pat = "*";
					break;
				}
			}
			if(pat.equals("*")) {
				System.out.println("Case #" + testCase++ + ": " + "*");
			} else {
				StringBuffer strbf = new StringBuffer();
				for(int i = 0; i < pat.length(); i++) {
					if(pat.charAt(i) != '*') {
						strbf.append(pat.charAt(i));
					}
				}
				System.out.println("Case #" + testCase++ + ": " + strbf.toString().substring(1));
			}
		}

	}

}
