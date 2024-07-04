import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int a[][]=new int[n][n];
          int tr=0;
          for(int j=0;j<n;j++){
            for(int k=0;k<n;k++){
                a[j][k]=in.nextInt();
                if(j==k){
                    tr+=a[j][k];
                }
            }
          }
          int r=0;
          int c=0;
          
          for(int j=0;j<n;j++){
            
            int sum=0;
            for(int k=0;k<n-1;k++){
                int b=a[j][k];
                for(int l=k+1;l<n;l++){
                    if(b==a[j][l]){
                        sum+=1;
                    }
                }
                if(sum>0){
                    break;
                }
                
            }
            if(sum>0){
                r+=1;
            }
          }
          for(int k=0;k<n;k++){
            
            int sum=0;
            for(int j=0;j<n-1;j++){
                int b=a[j][k];
                
                for(int l=j+1;l<n;l++){
                    if(b==a[l][k]){
                        sum+=1;
                    }
                }
                if(sum>0){
                    break;
                }
            }
            if(sum>0){
                c+=1;
            }
          }
          System.out.println("Case #" + i + ": " + tr + " " + r+" "+c);
        }
      }
    }