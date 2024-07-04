import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      in.nextLine();
      String s = in.nextLine();
      
      System.out.print("Case #" + i + ": ");
      for (int j = 0; j < s.length(); j++) {
    	  if (s.charAt(j) == '1') {
    		System.out.print("(1");
		while (s.charAt(j) == '1' && j<s.length()) {
			System.out.print("1");j++;	
		}
		if (j == s.length())
			System.out.print(")");
		else 
			System.out.print(")0");
    	  }else {
    		System.out.print("0");
    	  }
      }
      System.out.print(System.lineSeparator());
    }
  }
}