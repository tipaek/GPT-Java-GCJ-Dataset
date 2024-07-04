import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File("solution.in")); //new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++){
			String s = sc.next();
			String res = "";
			int[] diffs = new int[s.length()+1];
			diffs[0] = 0-Character.getNumericValue(s.charAt(0));
			for(int j = 1; j < s.length(); j++) {
				diffs[j] = Character.getNumericValue(s.charAt(j-1))-Character.getNumericValue(s.charAt(j));
			}
			diffs[s.length()] = Character.getNumericValue(s.charAt(s.length()-1)) - 0;
			//for(int j = 0; j < diffs.length; j++) System.out.print(diffs[j] + " ");
			for(int j = 0; j < Math.abs(diffs[j]); j++) res += '(';
			for(int j = 0; j  < s.length(); j++) {
				res += s.charAt(j);
				if(diffs[j+1] > 0) {
					for(int l = 0; l < diffs[j+1]; l++) res += ')';
				}
				else if (diffs[j+1] < 0) {
					for(int l = 0; l < Math.abs(diffs[j+1]); l++) res += '(';
				}
			}
			System.out.println("Case #" + i + ": " + res);
		}
	}
}