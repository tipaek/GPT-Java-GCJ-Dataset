 import java.util.*;
 import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for(int nu=1;nu<=t;nu++){
      int n = in.nextInt();
      int[][] a=new int[n][2];
      for(int i=0;i<n;i++){
          for(int j=0;j<2;j++){
              a[i][j]=in.nextInt();
          }
      }
      Arrays.sort(a,(p,q)->{
      if(p[1]!=q[1])return p[1]-q[1];
      return p[0]-q[0];
      });
      StringBuilder res=new StringBuilder();
      int c=-1,j=-1;
      for(int i=0;i<n;i++){
      if(c==-1||a[c][1]<=a[i][0]){
      c=i;
      res.append('C');
      }else if(j==-1||a[j][1]<=a[i][0]){
      j=i;
       res.append('J');
       }else{
       res=new StringBuilder("IMPOSSIBLE");
       break;
       }}
      System.out.println("Case #" + nu + ": " + (res.toString()));
    }
  }


}