import java.util.*;
import java.io.*;


public class Solution {

  int[] leftRotatebyOne(int arr[], int n)
  {
    int i, temp;
    temp = arr[0];
    for (i = 0; i < n - 1; i++)
      arr[i] = arr[i + 1];
    arr[i] = temp;

    return arr;
  }

  int[] leftRotate(int arr[], int d, int n)
  {
    for (int i = 0; i < d; i++)
      leftRotatebyOne(arr, n);

    return arr;
  }

  int[][] buildMatrix(int[] base, int d, int n) {

    int[][] arr = new int[n][n];

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        arr[i][j] = base[j];
      }
      base = leftRotate(base, d+1, n);
    }
    return arr;
  }

  boolean validMatrix(int[][] arr, int n) {

    int r_count = 0;
    int c_count = 0;

    for(int j = 0; j < n; j++) {
      HashSet<Integer> row_set = new HashSet<>();
      for(int k = 0; k < n; k++) {
        if(row_set.contains(arr[j][k])) {
          r_count +=1;
          break;
        }
        row_set.add(arr[j][k]);
      }
    }

    for(int j = 0; j < n; j++) {
      HashSet<Integer> col_set = new HashSet<>();
      for(int k = 0; k < n; k++) {
        if(col_set.contains(arr[k][j])) {
          c_count +=1;
          break;
        }
        col_set.add(arr[k][j]);
      }
    }

    return (r_count < 1 && c_count < 1);

  }

  public static void main(String[] args)throws Exception {

    Scanner in = new Scanner(System.in);
    int numCases = in.nextInt();

    Solution solution = new Solution();

    for(int i = 0; i < numCases; i++) {
      int n = in.nextInt(); // size of matrix
      int trace = in.nextInt();

      // start with original array
      int[] base = new int[n];
      for(int j = 1; j <= n; j++) {
        base[j-1] = j;
      }

      base = solution.leftRotate(base, 1 , n);

      int[][] output = new int[n][n];
      boolean flag = false;

      for(int j = 0; j < n; j++) {

        for(int k = 0; k < n; k++) {

          int[][] arr = solution.buildMatrix(base, k, n);

          int diag = 0;
          int sum = 0;

          while(diag < n) {
            sum += arr[diag][diag];
            diag++;
          }

          if(sum == trace && solution.validMatrix(arr, n)) {
            output = arr;
            flag = true;
            break;
          }
        }

        if(flag) {
          break;
        }

        base = solution.leftRotate(base, 1, n);

      }


      System.out.printf("Case #%d: ", i+1);
      if(flag) {
        System.out.println("POSSIBLE");
        for(int p = 0; p < n; p++) {
            for(int q = 0; q < n; q++) {
              System.out.print(output[p][q] + " ");
            }
            System.out.println();
          }

      } else {
        System.out.println("IMPOSSIBLE");
      }
    }
  }
}