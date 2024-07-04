import java.util.*;
import java.io.*;

public class Solution {
	
	public static String ans(String s) {
	int max = -1;
	int position = 0;
	int temp = 0;
	for (int i = 0; i < s.length(); i++)
		if ((s.charAt(i) >= 48 && s.charAt(i)<= 57) && 
				(temp = Integer.parseInt(s.substring(i, i+1))) > max) {
			max = temp;
			position = i;
		}
	
	if (max == 0)
		return s;
	
	int left = position, right = position;
	while (left >= 0 && s.charAt(left) != '0')
		left--;
	
	while (right < s.length() && s.charAt(right) != '0')
		right++;
	
	String sub = s.substring(left +1, right);
	String rep = "";
	for (int i = 0; i < sub.length(); i++) {
		if (sub.charAt(i) >= 48 && sub.charAt(i)<= 57)
			rep += sub.charAt(i) - 49;
		else rep += sub.charAt(i);
	}
	
	s = s.substring(0, left+1) + "(" + rep + ")" + s.substring(right);
	//System.out.println(s);
	return ans(s);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(
				new BufferedReader(new InputStreamReader(System.in)));

		int T = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.
		for (int t = 1; t <= T; ++t) {
			String str = in.next();
			String ans = ans(str);
			String actualAns = "";
			int count = 0;
			

			for (int i = 0; i < ans.length(); i++) {
				if (ans.charAt(i) == '0')
					actualAns += str.charAt(count++);
				else actualAns += ans.charAt(i);
			}
			
			
			System.out.println("Case #" + t + ": " + actualAns);
		}

		in.close();
	}
}