import java.io.*;
import java.util.*;
class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    int cases = 1;
    while(t-->0) {
      int n = scan.nextInt();
      int k = scan.nextInt();
      int latin [][] = new int[n][n];
      int diag = -1; //this is the value we need to line diagonal with
      boolean possible = false;
      for(int i = 1; i<=n ; i++) {
        if(i * n == k) {
          possible = true;
          diag = i;
        }
      }
      if(possible) {
        storeLatin(n, latin); //stores latin square in latin
        System.out.println("Case #" + cases + ": " + "POSSIBLE");
        int lookFor = diag;
        int pos = 0;
        for(int i = 0; i<n; i++) {
          if(latin[i][pos] == lookFor) {
            for(int j = 0; j<n; j++) {
              System.out.print(latin[i][j] + " ");
            }
            System.out.println();
            pos++;
            i = -1;
          }
          if(pos == n) {
            break;
          }
        }
      }
      else {
        System.out.println("Case #" + cases + ": " + "IMPOSSIBLE");
      }
      cases++;
    }
  }
  static void storeLatin(int n, int [][] latin) {   
    int row = 0;
    int col = 0;
    int k = n+1; 
    for (int i = 1; i <= n; i++) { 
      int temp = k; 
      while (temp <= n) { 
        latin[row][col] = temp;
        col++;
        temp++; 
      } 
      for (int j = 1; j < k; j++) { 
        latin[row][col] = j;     
        col++;
      } 
      k--;
      row++;
      col=0;
    }  
  }
}