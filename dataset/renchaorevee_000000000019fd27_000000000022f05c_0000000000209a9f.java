import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		try {
			BufferedReader reader =
	                 new BufferedReader(new InputStreamReader(System.in));
			int numOfTestCases = Integer.parseInt(reader.readLine(), 10);
			for (int i = 0; i < numOfTestCases; i++) {
				String line = reader.readLine();
				String r = solveSingleCase(line);
				System.out.println("Case #"+(i+1)+": " + r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String solveSingleCase(String line) {
		
		StringBuffer sb = new StringBuffer(line);
		int[] digits = new int[line.length()];
		
		for (int i = 0; i < line.length(); i++) {
			int n = Integer.parseInt(line.charAt(i) + "");
			digits[i] = n;
		}
		
		for (int i = 0, totalNumOfP = 0; i < line.length()+1; i++) {
			
			int diff;
			if (i == 0) {
				diff = digits[i];
			} else if (i == line.length()) {
				diff = -digits[i-1];
			} else {
				diff = digits[i] - digits[i-1];
			}
			
			sb = insertPAt(sb, diff, i+totalNumOfP);
			totalNumOfP += Math.abs(diff);
		}
		
		
		
		return sb.toString();
	}
	
	public static StringBuffer insertPAt(StringBuffer sb, int numOfP, int position) {
		if (numOfP == 0) return sb;
		
		if (numOfP > 0) {
			for (int i = 0; i < numOfP; i++) {
				sb.insert(position, '(');			
			}
		}
		
		if (numOfP < 0) {
			for (int i = 0; i < -numOfP; i++) {
				sb.insert(position, ')');			
			}
		}
		
		return sb;
	}
}
