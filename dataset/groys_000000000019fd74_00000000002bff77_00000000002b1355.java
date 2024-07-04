import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  static long[][] board;
  static double[][] elim;
  static int r;
  static int c;

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      r = in.nextInt();
      c = in.nextInt();
      board = new long[r][c];
      elim = new double[r][c];
      read(in);

      long score = 0;
      int numElim = 0;
      do {
        score += roundScore();
        computeElim();
        numElim = eliminate();
      } while (numElim > 0);
      System.out.println("Case #" + i + ": " + score);

    }
  }


  static void read(Scanner in) {
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        board[i][j] = in.nextInt();
      }
    }
  }

  static long roundScore() {
    long s = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (board[i][j] != -1) {
          s += board[i][j];
        }
      }
    }

    return s;
  }

  static void computeElim() {
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (board[i][j] != -1) {
          compassAvg(i, j);
        }
      }
    }
  }

  static int eliminate() {
    int s = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (board[i][j] != -1 && board[i][j] < elim[i][j]) {
          board[i][j] = -1;
          elim[i][j] = -1;
          s++;
        }
      }
    }
    return s;
  }

  static void compassAvg(int x, int y) {
    if (board[x][y] == -1) {
      return;
    }
    double sum = 0;
    int cnt = 0;
    int i, j;
    // up
    i = x - 1;
    j = y;
    while (i >= 0) {
      if (board[i][j] != -1) {
        sum += board[i][j];
        cnt++;
        break;
      }
      i--;
    }
    // down
    i = x + 1;
    j = y;
    while (i < r) {
      if (board[i][j] != -1) {
        sum += board[i][j];
        cnt++;
        break;
      }
      i++;
    }
    // left
    i = x;
    j = y - 1;
    while (j >= 0) {
      if (board[i][j] != -1) {
        sum += board[i][j];
        cnt++;
        break;
      }
      j--;
    }
    // right
    i = x;
    j = y + 1;
    while (j < c) {
      if (board[i][j] != -1) {
        sum += board[i][j];
        cnt++;
        break;
      }
      j++;
    }

    elim[x][y] = cnt == 0 ? -1 :  (double) sum / cnt;
  }
}
