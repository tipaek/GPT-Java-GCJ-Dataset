

import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        StringBuilder sb = new StringBuilder();
        for (int test = 1; test <= t; ++test) {
           int n = in.nextInt();
           int trace =0;
           int col =0;
           int row = 0;
           int[][] arr = new int[n][n];
           for(int i =0; i< n ; i++){
               int[] rowCheck = new int[n+1];
               for(int j=0; j<n; j++){
                   arr[i][j] = in.nextInt();
                   rowCheck[arr[i][j]]++;
                   if(i == j){
                       trace += arr[i][j];
                   }
               }
               for(int num : rowCheck){
                   if(num >1){
                       row++;
                       break;
                   }
               }
           }
           for(int i  =0; i< n ; i++){
               int[] colCheck = new int[n+1];
               for(int j =0; j< n; j++){
                   if(colCheck[arr[j][i]] ==1){
                       col++;
                       break;
                   } else {
                       colCheck[arr[j][i]]++;
                   }
               }
           }

           sb.append("Case #"+test+": "+trace+" " +row+ " " +col +"\n");
        }

        System.out.println(sb.toString());
    }
}