import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k =0;k<t;k++) {
        	String s = in.next();
        	
        	String sol = findSol(s,k+1);
        	System.out.println(sol);
        	
          
        }
	}
	
	static String findSol(String s, int caseNo) {
		String sol1= "";
		String sol ="";
		int openCount =0;
		for(int i = 0; i<s.length();i++) {
			int val = s.charAt(i) - '0';
			if(val == openCount) {
				sol+=s.charAt(i);
			}else if(val>openCount) {
				for(int t= 0;t< val-openCount; t++) {
					sol+="(";
				}
				openCount = val;
				sol+=s.charAt(i);
			}else if(openCount> val) {
				for(int t = 0;t <openCount - val; t++) {
					sol+=")";
				}
				openCount = val;
				sol+=s.charAt(i);
			}
		}
		for(int i =0;i<openCount;i++) {
			sol+=")";
		}
		sol1 = "Case #"+caseNo+": " + sol;
		return sol1;
        
    }
}
