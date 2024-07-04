import java.util.*;
import java.io.*;

public class Solution {
	private static String solve(String inp) {
		String edited = "0" + inp + "0";
		String res = "";
		int len = edited.length();
		for(int i=0 ; i<len-1 ; i++) {
			char firstDigit = edited.charAt(i);
			char secondDigit = edited.charAt(i+1);
			res += firstDigit;
			if(firstDigit < secondDigit) {
				for(int j=0 ; j<secondDigit - firstDigit ; j++) {
					res += "(";
				}
			}
			else
				for(int j=0 ; j<firstDigit - secondDigit ; j++) {
					res += ")";
				}
		}
		return res.substring(1, res.length());
	}
	public static void main(String[] args) {
		int N;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0 ; i<N ; i++) {
			String inp = sc.next();
			System.out.println("Case #" + Integer.toString(i+1) + ": " + solve(inp));
		} 
	}
}
