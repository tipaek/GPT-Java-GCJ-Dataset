import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int j1,t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

    for (j1 = 1; j1 <= t; ++j1) {

      int i,n=in.nextInt();
      int a[][] = new int[n][3];
      
      for(i=0;i<n;i++){
          a[i][0]=in.nextInt();
          a[i][1]=in.nextInt();
      }
      
      int j[][] = new int[n][2];
      int c[][] = new int[n][2];
      int cl=0, jl=0,p;
      c[0][0]=a[0][0];
      c[0][1]=a[0][1];
      a[0][2]=1;
      cl++;
      int fl=1, g=1;
      for(i=1;i<n;i++){
          fl=1; g=1;
          for(p=0;p<cl;p++){
              if(a[i][0]>c[p][0] && a[i][0]<c[p][1] || a[i][1]>c[p][0] && a[i][1]<c[p][1]){
                  //overlapping with c.
                  fl=0;
                  break;
              } 
          }
          
          if(fl==1){
                c[cl][0]=a[i][0];
                c[cl][1]=a[i][1];
                a[i][2]=1;
                cl++; 
          }
          
          if(fl==0){
           for(p=0;p<jl;p++){
              if(a[i][0]>j[p][0] && a[i][0]<j[p][1]|| a[i][1]>j[p][0] && a[i][1]<j[p][1]){
                  //overlapping with c.
                  g=0;
                  break;
              } 
          }
          if(g==1){
              j[jl][0]=a[i][0];
              j[jl][1]=a[i][1];
              a[i][2]=0;
              jl++;
          }
          
          if(g==0){
              break;
          }
          }
      }
      
      String res="";
      if(fl==0){
        System.out.println("Case #" + j1 + ": " +"IMPOSSIBLE");
        
      }else{
          
          for(int y=0;y<n;y++){
              if(a[y][2]==1){
                  res+='C';
              }else{
                  res+='J';
              }
          }
          System.out.println("Case #" + j1 + ": " +res);
      }
      //System.out.println("Case #" + j + ": " +r);
    }
  }
}