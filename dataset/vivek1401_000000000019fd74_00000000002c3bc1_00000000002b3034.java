import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		StringBuilder ans = new StringBuilder();
		int t = scn.nextInt();
		for (int _case_ = 1; _case_ <= t; _case_++) {
			ans.append("Case #").append(_case_).append(": ");
			
			//code
			int n = scn.nextInt();
			String longest = "";
			String[] array = new String[n];
			for (int i = 0; i < n; i++) {
				array[i] = scn.next();
				if (array[i].length() > longest.length()) {
					longest = array[i];
				}
			}
			boolean flag = true;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (!check(array[i], array[j])) {
						flag = false;
						break;
					}
				}
			}
			
			if (flag) {
				ans.append(longest.substring(1));
			} else {
				ans.append("*");
			}
			
			ans.append("\n");
		}
		System.out.println(ans);
	}
	
	private static boolean check(String s1, String s2) {
		Pattern p = Pattern.compile(s1.length() > s2.length() ? "^." + s2 : "^." + s1);
		return p.matcher(s1.length() > s2.length() ? s1 : s2).matches();
	}
	
	
}
