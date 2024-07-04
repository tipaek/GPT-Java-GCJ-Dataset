import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
  // dp[i][j] is going to store true if sum j is
  // possible with array elements from 0 to i.
  static boolean[][] dp;

  public static boolean isSafe(int[][] board, int row, int col, int num) {
    // row has the unique (row-clash)
    for (int d = 0; d < board.length; d++) {
      // if the number we are trying to
      // place is already present in
      // that row, return false;
      if (board[row][d] == num) {
        return false;
      }
    }

    // column has the unique numbers (column-clash)
    for (int r = 0; r < board.length; r++) {
      // if the number we are trying to
      // place is already present in
      // that column, return false;

      if (board[r][col] == num) {
        return false;
      }
    }

    // if there is no clash, it's safe
    return true;
  }

  public static boolean solveSudoku(int[][] board, int n) {
    int row = -1;
    int col = -1;
    boolean isEmpty = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 0) {
          row = i;
          col = j;

          // we still have some remaining
          // missing values in Sudoku
          isEmpty = false;
          break;
        }
      }
      if (!isEmpty) {
        break;
      }
    }

    // no empty space left
    if (isEmpty) {
      return true;
    }

    // else for each-row backtrack
    for (int num = 1; num <= n; num++) {
      if (isSafe(board, row, col, num)) {
        board[row][col] = num;
        if (solveSudoku(board, n)) {
          // print(board, n);
          return true;
        } else {
          board[row][col] = 0; // replace it
        }
      }
    }
    return false;
  }

  public static void print(int[][] board, int N) {
    // we got the answer, just print it
    for (int r = 0; r < N; r++) {
      for (int d = 0; d < N; d++) {
        System.out.print(board[r][d]);
        System.out.print(" ");
      }
      System.out.print("\n");

      if ((r + 1) % (int) Math.sqrt(N) == 0) {
        System.out.print("");
      }
    }
  }

  static ArrayList<ArrayList<Integer>> acceptedSoln = new ArrayList<>();

  static void display(ArrayList<Integer> v, int len) {
    boolean found = false;
    if (v.size() == len) {
      for (ArrayList<Integer> s : acceptedSoln) {
        if (s.equals(v)) {
          found = true;
        }
      }
      if (!found) {
        ArrayList<Integer> copy = new ArrayList<>();
        copy.addAll(v);
        acceptedSoln.add(copy);
//        System.out.println(v);
      }
    }
  }

  // A recursive function to print all subsets with the
  // help of dp[][]. Vector p[] stores current subset.
  static void printSubsetsRec(int arr[], int i, int sum, ArrayList<Integer> p, int ss) {
    // If we reached end and sum is non-zero. We print
    // p[] only if arr[0] is equal to sun OR dp[0][sum]
    // is true.
    if (i == 0 && sum != 0 && dp[0][sum]) {
      p.add(arr[i]);
      display(p, ss);
      p.clear();
      return;
    }

    // If sum becomes 0
    if (i == 0 && sum == 0) {
      display(p, ss);
      p.clear();
      return;
    }

    // If given sum can be achieved after ignoring
    // current element.
    if (dp[i - 1][sum]) {
      // Create a new vector to store path
      ArrayList<Integer> b = new ArrayList<>();
      b.addAll(p);
      printSubsetsRec(arr, i - 1, sum, b, ss);
    }

    // If given sum can be achieved after considering
    // current element.
    if (sum >= arr[i] && dp[i - 1][sum - arr[i]]) {
      p.add(arr[i]);
      printSubsetsRec(arr, i - 1, sum - arr[i], p, ss);
    }
  }

  // Prints all subsets of arr[0..n-1] with sum 0.
  static void printAllSubsets(int arr[], int n, int sum, int ss) {
    if (n == 0 || sum < 0) return;

    // Sum 0 can always be achieved with 0 elements
    dp = new boolean[n][sum + 1];
    for (int i = 0; i < n; ++i) {
      dp[i][0] = true;
    }

    // Sum arr[0] can be achieved with single element
    if (arr[0] <= sum) dp[0][arr[0]] = true;

    // Fill rest of the entries in dp[][]
    for (int i = 1; i < n; ++i)
      for (int j = 0; j < sum + 1; ++j)
        dp[i][j] = (arr[i] <= j) ? (dp[i - 1][j] || dp[i - 1][j - arr[i]]) : dp[i - 1][j];
    if (dp[n - 1][sum] == false) {
//      System.out.println("There are no subsets with" + " sum " + sum);
      return;
    }

    // Now recursively traverse dp[][] to find all
    // paths from dp[n-1][sum]
    ArrayList<Integer> p = new ArrayList<>();
    printSubsetsRec(arr, n - 1, sum, p, ss);
  }

  // Driver Program to test above functions
  public static void main(String args[]) {

      Scanner sc = new Scanner(System.in);
      long tc = sc.nextInt();
      int tcn = 1;

      while (tc-- != 0) {

          acceptedSoln = new ArrayList<>();

          int n = sc.nextInt();
          int sum = sc.nextInt();
          int arr[] = new int[n*n];
          int j = 1;
          for (int i = 0; i < n*n; i++) {
              if(j > n) {
                  j = 1;
              }
              arr[i] = j;
              j++;
//              System.out.print(arr[i] + " ");
          }
//          System.out.println();

          int len = arr.length;
          printAllSubsets(arr, len, sum, n);


          String impo = "IMPOSSIBLE";
          String po = "POSSIBLE";
          boolean isSol = false;
          for (List<Integer> v : acceptedSoln) {
              int board[][] = new int[v.size()][v.size()];
              int i = 0;
              for (Integer x : v) {
                  board[i][i] = x;
                  i++;
              }

              if (solveSudoku(board, v.size())) {
                  isSol = true;
                  System.out.println("Case #" + tcn + ": " + po);
                  print(board, v.size()); // print solution
                  break;
              } else {
//                  System.out.println("No solution");
              }
          }
          if (!isSol) {
              System.out.println("Case #" + tcn + ": " + impo);
          }

          tcn++;
      }

  }
}
