import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int tt = 1;tt <= t; ++tt) {
      String s="";
      int n=in.nextInt(),i,j,k=0;
      ArrayList<Integer> x[]=new ArrayList[2];
      ArrayList<Integer> y[]=new ArrayList[2];
      for(i=0;i<2;i++) {
        x[i]=new ArrayList<Integer>();
        y[i]=new ArrayList<Integer>();
      }
      outer:for(i=0;i<n;i++) {
        int l=in.nextInt(),r=in.nextInt();
        k=0;
        inner:for(j=0;j<x[0].size();j++) {
          if((r>x[0].get(j) && r<x[1].get(j)) || (l<x[1].get(j) && l>x[0].get(j))) {
            k=-1;
            break inner;
          }
        }
        if(k==0) {
          x[0].add(l);
          x[1].add(r);
          s+="C";
          continue outer;
        }
        k=0;
        inner:for(j=0;j<y[0].size();j++) {
          if((r>y[0].get(j) && r<y[1].get(j)) || (l<y[1].get(j) && l>y[0].get(j))) {
            k=-1;
            break inner;
          }
        }
        if(k==0) {
          y[0].add(l);
          y[1].add(r);
          s+="J";
          continue outer;
        }
        s="IMPOSSIBLE";
        break outer;
      }
      System.out.println("Case #"+ tt +": "+s);
    }
  }
}