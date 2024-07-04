import java.util.Scanner;

import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));  
        int t = in.nextInt();
        for(int i = 0;i<t;i++){
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0;
            for(int j = 0;j<n;j++){
                for(int r = 0; r<n;r++){
                arr[j][r] = in.nextInt();
                if(r == j)
                    trace+=arr[j][r];
                }
            }
            int row = 0;
            int col = 0;
            for(int j = 0;j<n;j++){
                    int res = arr[j][0];
                    for(int c = 1;c<n;c++){
                        if(res == arr[j][c]){
                            row++;
                            break;
                        }
                    }
                    res = arr[0][j];
                    for(int c = 1;c<n;c++){
                        if(res == arr[c][j]){
                            col++;
                            break;
                        }
                    }
                }
                System.out.println("Case #"+(i+1)+": "+trace+" "+row+" "+col);
            }
        in.close();
        }
 }