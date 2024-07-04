import java.util.*;
import java.io.*;
public class Solution {
    public static String fin(String s) {
        s=s+"0";
        String f=" ";
        int j= s.charAt(0)-48;
            for(int k=1; k<=j; k++)
            {
                f=f+"(";
            }
            f=f+s.charAt(0);
        for(int i=1; i<s.length(); i++)
        {
            int dif=s.charAt(i)-s.charAt(i-1);
            if(dif<0)
            {
                dif=dif*(-1);
                for(int l=1; l<=dif; l++)
                {
                    f=f+")";
                }
                f=f+s.charAt(i);
            }
            else
            {
                for(int l=1; l<=dif; l++)
                {
                    f=f+"(";
                }
                f=f+s.charAt(i);
            }
        }
        String fi="";
        for(int j1=0; j1< f.length()-1; j1++)
        {
            fi=fi+f.charAt(j1);
        }
        return fi;
    }
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();
    for (int i = 1; i <= T; ++i) {
      String s = in.next();
      String f=fin(s);
      System.out.println("Case #" + i + ": " + f);
    }
  }
}