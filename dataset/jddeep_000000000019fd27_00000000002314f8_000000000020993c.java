import java.util.*;
import java.io.*;

class Solution{
    public static int trace(int[][] m, int n){
        int sum = 0; 
    for (int i=0; i<n; i++) 
        sum += m[i][i]; 
    return sum;
    }
    public static int repeatedRows(int[][] m, int n){
        int j=0,i = 0, count = 1;
        int res = 0;
        while(i<n && j<n){
            if(j+count>=n){
                if(j<n-1){
                    j++;
                    count = 1;
                    continue;
                }
                i++;
                j=0;
                count = 1;
                continue;
            }
            if(m[i][j] == m[i][j+count]){
                res++;
                i++;
                j=0;
                count = 1;
                continue;
            }
            count++;
        }
        return res;
    }

    public static int repeatedColumns(int[][] m, int n){
        int j=0,i = 0,count = 1;
        int res = 0;
        while(i<n && j<n){
            if(i+count>=n){
                if(i<n-1){
                    i++;
                    count = 1;
                    continue;
                }
                j++;
                i=0;
                count = 1;
                continue;
            }
            if(m[i][j] == m[i+count][j]){
                System.out.println("match: " + m[i][j]);
                res++;
                j++;
                i=0;
                count = 1;
                continue;
            }

            count++;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int k = 0, j =0;
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int[][] m = new int[n][n];
          k = 0; j = 0;
          while(j<n){
              if(k < n)
              m[k][j] = in.nextInt();
              if(j == n-1 && k<n){
                  j = 0;
                  k++;
                  continue;
              }
              if(k>=n){
                  break;
              }
              j++;
          }
          int x = trace(m, n);
          int r = repeatedRows(m, n);
          int c = repeatedColumns(m, n);
          
          System.out.println("Case #" + i + ": " + x + " " + r + " " + c);
        }
        in.close();
      }
}