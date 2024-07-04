
import java.util.Scanner;

public class Solution {

	public static String func(String str1, String str2) {
		StringBuffer ans = new StringBuffer();
		int[][] arr = new int[str1.length()][str2.length()];
		arr[0][0] = 1;
		for(int i = 0; i < str1.length(); i++) {
			for(int j = 0; j < str2.length(); j++) {
				if(str1.charAt(i) == '*' || str2.charAt(j) == '*') {
					if(i > 0) {
						arr[i][j] = Math.max(arr[i - 1][j], arr[i][j]);
					}
					if(j > 0) {
						arr[i][j] = Math.max(arr[i][j - 1], arr[i][j]);
					}
				} else if(str1.charAt(i) == str2.charAt(j) && i > 0 && j > 0) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
				}
//				System.out.println(arr[i][j] + " " + str1.charAt(i) + " " + str2.charAt(j));
			}
//			System.out.println();
		}
		if(arr[str1.length() - 1][str2.length() - 1] == 0) {
			return "";
		}
		int i = str1.length() - 1, j = str2.length() - 1;
		while(i >= 0 && j >= 0) {
			if(str1.charAt(i) == '*' || str2.charAt(j) == '*') {
				if(i > 0 && j > 0 && arr[i - 1][j] >= arr[i][j - 1]) {
					ans.append(str1.charAt(i--));
				} else if(i > 0 && j > 0 && arr[i - 1][j] < arr[i][j - 1]) {
					ans.append(str2.charAt(j--));
				} else if(i > 0 && arr[i - 1][j] > 0) {
					ans.append(str1.charAt(i--));
				} else if(j > 0 && arr[i][j - 1] > 0) {
					ans.append(str2.charAt(j--));
				} else {
					return "";
				}
			} else if(str1.charAt(i) == str2.charAt(j)) {
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
				patterns[i] = "x" + s.next();
			}
			String pat = patterns[0];
			for(int i = 1; i < n; i++) {
				pat = func(pat, patterns[i]);
				if(pat.equals("")) {
					pat = "*";
					break;
				}
//				System.out.println(pat);
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
