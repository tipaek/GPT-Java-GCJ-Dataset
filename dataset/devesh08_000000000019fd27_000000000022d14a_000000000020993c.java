import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int tt = 1;tt <= t; ++tt) {
      int n = in.nextInt(),r=0,c=0,trace=0,i,j;
      int a[][]=new int[n][n];
      for(i=0;i<n;i++) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(j=0;j<n;j++) {
          a[i][j]=in.nextInt();
          set.add(a[i][j]);
          if(i==j)
            trace+=a[i][j];
        }
        if(set.size()<n)
          r++;
      }
      for(i=0;i<n;i++) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(j=0;j<n;j++)
          set.add(a[j][i]);
        if(set.size()<n)
          c++;
      }
      System.out.println("Case #"+tt+": "+trace+" "+r+" "+c);
    }
  }
}