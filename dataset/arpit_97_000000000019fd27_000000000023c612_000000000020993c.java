// "static void main" must be defined in a public class.

import java.util.*;
import java.io.*;
import java.lang.*;


class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        for(int t=1;t<=test_case;t++){
            int n = Integer.parseInt(br.readLine());
            int mat[][] = new int[n][n];
            int trace = 0;
            for(int i=0;i<n;i++){
                String str[] = br.readLine().split(" ");
                for(int j=0;j<n;j++){
                    mat[i][j] = Integer.parseInt(str[j]);
                    if(i == j){
                        trace+=mat[i][j];
                    }
                }
            }
            int count_row = 0;
            for(int i=0;i<n;i++){
                boolean arr[] = new boolean[n+1];
                for(int j=0;j<n;j++){
                    int val = mat[i][j];
                    if(!arr[val]){
                        arr[val] = true;
                    }
                    else{
                        count_row++;
                        break;
                    }
                }
            }
            int count_col = 0;
            for(int j=0;j<n;j++){
                boolean arr[] = new boolean[n+1];
                for(int i=0;i<n;i++){
                    int val = mat[i][j];
                    if(!arr[val]){
                        arr[val] = true;
                    }
                    else{
                        count_col++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+t+": "+trace+" "+count_row+" "+count_col);
        }
    }
}