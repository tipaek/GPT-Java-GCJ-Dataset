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
			String main = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
			String longest="";
			String[] array = new String[n];
			for (int i = 0; i < n; i++) {
				String str = scn.next();
				array[i] = str;
				if (str.length() < main.length()) {
					main = str;
				}
				if (str.length()>longest.length()){
					longest=str;
				}
			}
			longest=longest.substring(1);
			main = "^." + main;
			Pattern p = Pattern.compile(main);
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				if (!p.matcher(array[i]).matches()) {
					ans.append("*");
					flag = true;
					break;
				}
			}
			if (!flag) {
				ans.append(longest);
			}
			
			ans.append("\n");
		}
		System.out.println(ans);
	}
	
	
}
