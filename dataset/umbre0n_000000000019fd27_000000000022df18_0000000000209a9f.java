import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
 
import java.util.*;
import java.lang.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class Solution implements Runnable {

  static BufferedReader in;
  static PrintWriter out;

  static int minInversionsNeeded;
  static boolean[][] isOpenCell;
  static int[][] ways;
 
  public static void main(String[] args) {
      new Thread(null, new Solution(), "whatever", 1<<29).start();
  }
 
  public void run() {
    in = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out, false);
 
    try
    {
      // in = new BufferedReader(new FileReader("class_treasurer.txt"));
      // out = new PrintWriter("output.txt");

      int t,x1,n,i,j;
      String str;
      String[] token;

      str=in.readLine().trim();
      token=str.split(" ");

      t=Integer.parseInt(token[0]);

      for(x1=0;x1<t;x1++) {
        str=in.readLine().trim();
        n=str.length();
        String res="";
        int previousDigit=0;

        for(i=0;i<n;i++) {
          int val=(str.charAt(i)-'0');
          if(val>=previousDigit) {
            for(j=previousDigit;j<val;j++) {
              res+="(";
            }
          }
          else {
            for(j=val;j<previousDigit;j++) {
              res+=")";
            }
          }
          res+=val;
          previousDigit=val;
        }

        for(j=0;j<previousDigit;j++) {
          res+=")";
        }

        out.println(String.format("Case #%s: %s", x1+1, res));
      }

      out.flush();
      out.close();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}
