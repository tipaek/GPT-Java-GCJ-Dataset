
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int n = in.nextInt();
	      String[] p = new String[n];
	      for (int j =0; j < n; j++) {
	    	  p[j] = in.next();
	      }
	      String ans = s.patternMatch(p);

	      System.out.println("Case #" + i + ": " +  ans);
	    }
	    in.close();

	}
	
	public boolean pattern(char[] str1, char[] str2) {
		StringBuffer sb = new StringBuffer();
		int p1 = str1.length -1;
		int p2 = str2.length -1;
		
		while (p1 >= 0 && p2 >= 0) {
			if (str1[p1] == str2[p2]) {
				p1--;
				p2--;
			} else {
				if (str2[p2] == '*') {
					return true;
				} else {
					return false;
				}
			}
		}
		
		return true;
	}

	public String patternMatch(String[] list) {
		Arrays.sort(list, new Comparator<String>() {
			public int compare(String obj1, String obj2) {
				return Integer.compare(obj2.length(), obj1.length());
			}
		});
		
		for (int i = 1; i < list.length; i++) {
			if (!pattern(list[0].toCharArray(), list[i].toCharArray())) {
				return "*";
			}
		}
		
		return list[0].replace("*", "AA");
		
	}

}
