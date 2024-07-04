/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution {
//class Ideone{
public static String addSP(int i){
        String s = "";
        for(int j = 1;j <= i;j++){
            s = s + "(";
        }
        return(s);
    }
    public static String addEP(int i){
        String s = "";
        for(int j = 1;j <= i;j++){
            s = s + ")";
        }
        return(s);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String temp = in.nextLine();
        for (int i = 1; i <= t; ++i) {
          String s = in.nextLine();
          String ans = "";
          s = "0"+s+"0";
          int len = s.length();
          for(int j = 1;j < len;j++){
            if(s.charAt(j)> s.charAt(j-1)){
                ans = ans + addSP(s.charAt(j)-s.charAt(j-1));
            }else if(s.charAt(j-1) > s.charAt(j)){
                ans = ans + addEP(s.charAt(j-1)-s.charAt(j));
            }
            ans = ans + s.substring(j, j+1);
          }
          ans = ans.substring(0,ans.length()-1);
          System.out.println("Case #" + i + ": "+ans);
        }
	}
}

    
      