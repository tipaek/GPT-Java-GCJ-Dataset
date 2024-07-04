import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for(int nu=1;nu<=t;nu++){
      int n = in.nextInt();
      int trace=0;
      int[][] a=new int[n][n];
      for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
              a[i][j]=in.nextInt();
          }
          trace+=a[i][i];
      }
      int r=0;
      for(int i=0;i<n;i++){
        if(!check(i,a,n)){
            r++;
        }
      }
    int c=0;
      for(int i=0;i<n;i++){
        if(!checkcol(i,a,n)){
            c++;
        }
      }
      System.out.println("Case #" + nu + ": " + (trace) + " " + r+" "+c);
    }
  }
  static boolean check(int ind,int[][] a,int n){
      HashSet<Integer> hs=new HashSet();
      for(int i=0;i<n;i++){
          if(hs.contains(a[ind][i])){
              return false;
          }else{
              hs.add(a[ind][i]);
          }
      }
      return true;
  }
    static boolean checkcol(int ind,int[][] a,int n){
      HashSet<Integer> hs=new HashSet();
      for(int i=0;i<n;i++){
          if(hs.contains(a[i][ind])){
              return false;
          }else{
              hs.add(a[i][ind]);
          }
      }
      return true;
  }
}