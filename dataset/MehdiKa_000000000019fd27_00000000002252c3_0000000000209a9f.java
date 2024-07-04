import java.util.*;
import java.io.*;
public class Solution {

	static String solve(String s) {
		String result = "";
		int lastDigit = 0;
		for(int i=0; i<s.length(); i++) {
			int digit = Character.getNumericValue(s.charAt(i));
			for(int j=0; j<digit-lastDigit; j++) {
				result += "(";
			}
			for(int j=0; j<lastDigit-digit; j++) {
				result += ")";
			}
			lastDigit = digit;
			result += s.charAt(i);
		}
		for(int j=0; j<lastDigit; j++) {
			result += ")";
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new FileReader("bin/myinput.txt")));
		} catch (IOException e) {
			// e.printStackTrace();
			 in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));			
		}
		
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			String s = in.next();
			System.out.println("Case #" + i + ": " + solve(s));
		}
		in.close();
	}

}
