import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    try{
    int t = s.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for(int i=1;i<=t;i++){
        int trace=0;
        int n = s.nextInt();
        int mat[][] = new int[n][n];
        int usum = 0;
       for(int N = 1;N<=n;N++){usum+=N^3;}
       int rown=0,coln=0;
       for(int j = 0;j<n;j++){
           int sum=0;
           for(int k = 0;k<n;k++){
               mat[j][k]=s.nextInt();
               sum+=(mat[j][k]^3);
               if(j==k)
                 trace+=mat[j][k];
           }
           if(sum!=usum){rown++;}
       }
       for(int l=0;l<n;l++){
           int sum=0;
           for(int m=0;m<n;m++){
               sum+=((mat[m][l])^3);
           }
           if(sum!=usum){coln++;}
       }
       
       System.out.println("Case #"+i+": "+trace+" "+
       rown+" "+coln);
    }
  }catch(Exception e){}
  }
}

