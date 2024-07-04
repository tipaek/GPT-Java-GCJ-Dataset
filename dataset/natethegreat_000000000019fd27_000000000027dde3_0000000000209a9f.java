import java.util.*;
import java.io.*;


public class Solution {
	public String sol;
	public char[] c;
	public int curDepth;
	public int num;
	
	public void solve(String s) {
		c = new char[s.length()];
		c = s.toCharArray();
		curDepth = 0;
		num = 0;
		sol = "";
		for(int i = 0; i < c.length; ++i) {
			String temp = Character.toString(c[i]);
			int cur = Integer.parseInt(temp);
			if(cur == curDepth) {
				sol = sol + temp;
			}else if(cur > curDepth) {
				do {
					sol = sol + "(";
					curDepth++;
				}while(cur > curDepth);
				sol = sol + temp;
			}else if(cur < curDepth) {
				do {
					sol = sol + ")";
					curDepth--;
				}while(cur < curDepth);
				sol = sol + temp;
			}
		}
		while(curDepth > 0) {
			sol = sol + ")";
			curDepth--;
		}
	}
	
	public void printSol(int i) {
		System.out.println("Case #" + i + ": " + sol);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int total = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        Solution s = new Solution();
        for(int i = 0; i < total; ++i) {
        	String string = in.nextLine();
            s.solve(string);
            s.printSol(i + 1);
        }
        in.close();
	}

}
