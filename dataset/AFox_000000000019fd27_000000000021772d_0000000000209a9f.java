import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		 int cases = scan.nextInt();
		 scan.nextLine();
		 for (int i = 1; i <= cases; i++) {
		 String s = scan.nextLine();
		 s = recurs(s);
		 System.out.printf("Cases #%d " + s + "\n",i);
		 }
		 
	}
	public static String recurs(String s) {
		if (s.equals("1"))
			return "(1)";
		if (s.length() <= 1)
			return s;
		if (s.substring(0,1).equals("1")) {
		return "(" + s.substring(0,fc(s)) + ")" + recurs(s.substring(fc(s)));
		}
		else
		return s.substring(0,fc(s)) + recurs(s.substring(fc(s)));
	}
	public static int fc(String s) {
		for (int i = 0; i < s.length()-1; i++) {
			if (s.charAt(i) != s.charAt(i+1))
			return i+1;
		}
		return s.length();
	}

}
