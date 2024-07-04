import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int tt = 1;tt <= t; ++tt) {
      String s=in.next();
      int n=s.length(),i,j,d=0,k=0;
      String res="";
      for(i=0;i<n;i++) {
        d=s.charAt(i)-'0';
        if(d<k) { //brackets more than digit -> close k-d brackets
          for(j=0;j<k-d;j++)
            res+=")";
        }
        else if(d>k) { //brackets less than digit -> open d-k brackets
          for(j=0;j<d-k;j++)
            res+="(";
        }
        res+=s.charAt(i);
        k=d;
      }
      for(i=0;i<k;i++)
        res+=")";
      System.out.println("Case #"+tt+": "+res);
    }
  }
}