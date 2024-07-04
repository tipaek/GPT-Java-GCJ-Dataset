import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        
       Scanner scan = new Scanner(System.in);
       int tests = scan.nextInt();
       for(int k =0; k<tests; k++)
       {
           int n = scan.nextInt();
           int[][] arr = new int[n][n];
           for(int i=0; i<n;i++)
           {
               for(int j=0; j<n; j++)
               {
                   arr[i][j] = scan.nextInt();
               }
           }
       int sum = 0; int sumR =0; int sumC = 0;
       int s = 0;
       while(s<n)
       {
           boolean flag1 = false; boolean flag2 = false;
           for(int i=0 ; i<n-1; i++)
           {
               int numR = arr[s][i];
               int numC = arr[i][s];
               for(int j=i+1;j<n;j++)
               {
                   if(numR == arr[s][j] || numC == arr[j][s] )
                   {
                       if(numR == arr[s][j])
                           flag1 = true;
                       if(numC == arr[j][s])
                           flag2 = true;
                   }
                       
               }
           }
           if(flag1) sumR++; 
           if(flag2) sumC++;
           sum = sum + arr[s][s];
           s++;
       }
           System.out.println("Case #" + k+1 + ": " + sum +" " + sumR + " " + sumC);
    }
       
    }  
}