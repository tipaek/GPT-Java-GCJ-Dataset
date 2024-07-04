import java.util.*;
    import java.io.*;
    public class Solution {
    	public static String nest(String S) {
    		int v = 0;
            int open = 0;
            StringBuffer ans = new StringBuffer();
            for(int j = 0; j < S.length(); j++) {
          	  if((int)S.charAt(j) - 48 > v) {
          		  int diff = (int)S.charAt(j) - 48 - v;
          		  while(diff-- > 0) {
          			  ans.append("(");
          			  open++;
          		  }
          		  ans.append(S.charAt(j));
          		  v = (int)S.charAt(j) - 48;
          	  }
          	  else if((int)S.charAt(j) - 48 < v) {
          		  int diff = v - (int)S.charAt(j) + 48 ;
          		  
          		  while(diff-- > 0) {  
          			  ans.append(")");
          			  open--;
          		  }
          		  ans.append(S.charAt(j));
          		  v = (int)S.charAt(j) - 48 ;
          	  }
          	  else {
          		  ans.append(S.charAt(j));
          	  }
            }
            while(open --> 0) {
            	ans.append(")");
            }
            return ans.toString();
    	}
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          String S = in.next();
          String X = nest(S);
          System.out.println("Case #" + i + ": " + X);
        }
      }
    }