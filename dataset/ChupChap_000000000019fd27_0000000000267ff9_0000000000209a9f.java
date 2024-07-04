import java.util.*;
import java.io.*;
public class Solution {
    public static String fin(String S) {
        S=S+"0";
        String f=" ";
        if(S.charAt(0)=='0')
        {
            f="0";
        }
        else
        {
            f="(1";
        }
        for(int i=1; i<S.length(); i++)
        {
            if(S.charAt(i)=='0' && S.charAt(i-1)=='1')
            {
                f=f+")0";
            }
            else if(S.charAt(i)=='1' && S.charAt(i-1)=='0')
            {
                f=f+"(1";
            }
            else
            {
                f=f+S.charAt(i);
            }
        }
        String fi="";
        for(int j=0; j< f.length()-1; j++)
        {
            fi=fi+f.charAt(j);
        }
        return fi;
    }
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= T; ++i) {
      String S = in.next();
      String f=fin(S);
      System.out.println("Case #" + i + ": " + f);
    }
  }
}