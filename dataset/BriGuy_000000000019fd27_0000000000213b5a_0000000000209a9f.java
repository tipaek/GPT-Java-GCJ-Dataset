import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			String s = in.readLine();
			int last = 0;
			String ans = "";
			for(int i = 0; i < s.length(); i++) {
				int dig = Integer.parseInt(s.substring(i,i+1));
				if(last > dig) {
					for(int x = last; x > dig; x--) {
						ans += ")";
					}
				} else if(last < dig) {
					for(int x = last; x < dig; x++) {
						ans += "(";
					}
				}
				ans += dig;
				last = dig;
			}
			
			for(int x = last; x > 0; x--) {
				ans += ")";
			}
			
			System.out.println("Case #" + t + ": " + ans);
		}
	}
}
