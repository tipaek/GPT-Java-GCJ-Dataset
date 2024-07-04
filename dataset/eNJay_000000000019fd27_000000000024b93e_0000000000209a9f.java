import java.util.*;
import java.io.*;
public class Solution {
    
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      
	String s = in.next();
      
      	paren(s, i);
    }
  }
  
  
  private static void paren(String s, int cs){
      
	StringBuilder sb = new StringBuilder();
	int d = 0;
	
	for(int i=0; i<s.length(); i++){

		int n = s.charAt(i) - '0' ;

		while(d < n) {
			sb.append('(');
			d++;
		}

		while(d > n) {
			sb.append(')');
			d--;
		}
		
		sb.append(n);

	}

	while(d>0){
		sb.append(')'); d--;
	}

        System.out.println("Case #" + cs + ": " + sb.toString());
  }
}
