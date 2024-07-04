import java.io.*;
import java.util.*;

class Solution {
	static Scanner sc;

	public static void main(String[] args) throws IOException{
		sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//sc = new Scanner(new BufferedReader(new InputStreamReader(ves.txt)));
		
		
		int t = sc.nextInt(); 
		for (int i = 1; i <= t; i++) {
			String S = sc.next();
			int[] array = new int[S.length()];
			for (int c = 0; c < S.length(); c++) {
				array[c] = Character.getNumericValue(S.charAt(c));
			}
			
			String toret = "";
			int left = 0;
			for (int c = 0; c < S.length(); c++) {
				if (left < array[c]) {
					for (int p = 0; p < array[c] - left; p++) {
						toret = toret + "(";
						left++;
					}
				} else if (left > array[c]) {
					for (int p = 0; p < left - array[c]; p++) {
						toret = toret + ")";
						left --;
					}
				}
				toret = toret + array[c];
				if (c == (S.length()-1)) {
					for (int p = 0; p < array[c]; p++) {
						toret = toret + ")";
					}
				}
			}
			
			System.out.println("Case #" + i + ": " + toret);
			
			
		}

	}
}
