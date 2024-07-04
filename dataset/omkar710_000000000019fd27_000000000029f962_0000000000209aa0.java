import java.util.*;
import java.io.*;

public class Solution {

  static void reverseArray(int arr[], int start,
                           int end)
  {
    while (start < end)
    {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  // Function to right rotate
  // arr[] of size n by d
  int[] rightRotate(int arr[], int d, int n)
  {
    reverseArray(arr, 0, n - 1);
    reverseArray(arr, 0, d - 1);
    reverseArray(arr, d, n - 1);

    return arr;
  }

  int[][] buildMatrix(int[] base, int d, int n) {

    int[][] arr = new int[n][n];

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        arr[i][j] = base[j];
      }
      
      base = rightRotate(base, d+1, n);
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

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numCases = in.nextInt();

    Solution solution = new Solution();

    for(int i = 0; i < numCases; i++) {
      int n = in.nextInt(); // size of matrix
      int trace = in.nextInt();

      int count = n;
      // start with original array
      int[] base = new int[n];
      for(int j = 0; j < n; j++) {
        base[j] = count;
        count -= 1;
      }

      int[][] output = new int[n][n];
      boolean flag = false;

      for(int j = 0; j < n; j++) {

        for(int k = 0; k < n; k++) {

          int[][] arr = solution.buildMatrix(base, k, n);

          int diag = 1;
          int sum = 0;

          int init_val = arr[0][0];
          sum += init_val;

          while(diag < n) {
            if(arr[diag][diag] != init_val) {
              sum = -1;
              break;
            }
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

        base = solution.rightRotate(base, 1, n);

      }


      System.out.printf("Case #%d: ", i+1);
      if(flag) {
        System.out.println("POSSIBLE");
        for(int p = 0; p < n; p++) {
            for(int q = 0; q < n; q++) {
              if(q +1 != n) {
                System.out.print(output[p][q] + " ");
              } else {
                System.out.print(output[p][q]);
              }
            }
            System.out.println();
          }

      } else {
        System.out.println("IMPOSSIBLE");
      }
    }
  }
}