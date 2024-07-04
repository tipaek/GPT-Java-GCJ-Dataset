import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int x = 1; x <= t; ++x) {
        int k = 0,r = 0,c = 0,n,i,j;

        n = sc.nextInt();
        
        int[][] matrix = new int[n][n];

        for(i = 0;i<n;i++){
            for(j = 0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        for(i = 0;i<n;i++){
            for(j = 0;j<n;j++){
                k+=(i == j)?matrix[i][j]:0;
            }
        }
        for(i = 0;i<n;i++){

            int[] counter = new int[n+1];
            for(j = 0;j<n;j++){
                counter[matrix[i][j]]++;
            }

            for(int  kx = 1;kx<n+1;++kx){
                if(counter[kx] == 0 || counter[kx]>1){
                    r++;
                    break;
                }
            }
        }

        for(i = 0;i<n;i++){

            int[] counter = new int[n+1];
            for(j = 0;j<n;j++){
                counter[matrix[j][i]]++;
            }

            for(int  kx = 1;kx<n+1;++kx){
                if(counter[kx] == 0 || counter[kx]>1){
                    c++;
                    break;
                }
            }
        }

        System.out.println("Case #"+x+":"+" "+k+" "+r+" "+c);
    }
  }
}