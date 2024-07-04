    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          String s = in.next();
          String new_string = new String();
          int digit;
          for (int x=0; x < s.length(); x++) {
        	  digit = Integer.parseInt(String.valueOf(s.charAt(x)));
        	 for(int z = 0; z < digit; z++)
        		 new_string = new_string + '(';
        	 
        	 new_string = new_string + digit;
        	 for(int z = 0; z < digit; z++)
        		 new_string = new_string + ')';
        	     
          }

          System.out.println("Case #" + i + ": " + new_string.replaceAll("\\)\\(", ""));
        }
      }
    }