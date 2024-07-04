
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long t = sc.nextLong();
		int k = 1;
		while (t-- > 0) {
			String s = sc.next();
			int total = 0;
			s+="0";
			String ans = "";
			for (int i = 0; i < s.length(); i++) {
				int cur = (int) s.charAt(i) - '0';
				if (cur == total) {

				} else if (cur > total) {
					while (cur > total) {
						ans += "(";
						total++;
					}
				}else {
					while(cur < total) {
						ans+=")";
						total--;
					}
				}
				ans+=s.charAt(i);
			}
			int max = ans.length();
			 System.out.println( "Case #"+k+": "+ans.substring(0,max-1));
		       k++;
		}
	}
}