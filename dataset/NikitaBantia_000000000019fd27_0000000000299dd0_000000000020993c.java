import java.util.*;
import java.io.*;

class Solution {
  public static void main(String[] args) {
   try{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int in=0;
    while(in++<t){
      int n = Integer.parseInt(br.readLine());
      int[][] a = new int[n][n];
      int rc= 0;
      int cc=0;
      int trace=0;
      for(int i=0;i<n;i++){
    		Set<Integer> s = new HashSet<>();
        String str = br.readLine();
        StringTokenizer strt = new 	StringTokenizer(str);
        int j=0;
        while(strt.hasMoreTokens()){
      
          a[i][j] = Integer.parseInt(strt.nextToken());
          if(i==j) trace+= a[i][j];
          s.add(a[i][j]);
          j++;
        }
        if(s.size()!=n) rc++;
             }
      for(int j=0;j<n;j++){
        Set<Integer> s1 = new HashSet<>();
         for(int i=0;i<n;i++){
          s1.add(a[i][j]);
          }
        if(s1.size()!=n)cc++;
      }
      System.out.println("Case #"+in+": "+trace+" "+rc+" "+cc);
    }
     
     }
    catch(Exception e){
      e.printStackTrace();
    }
  }

}

