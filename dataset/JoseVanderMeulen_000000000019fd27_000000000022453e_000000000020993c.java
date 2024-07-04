import java.util.Scanner;

//********************************************************************************************
//Vestigium
//https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d3f56
//********************************************************************************************
class Solution {
  static Scanner scanner = new Scanner(System.in);

  static int t;
  static int num;

  static int n;
  static int[][] mtx = new int[100][100];
  static boolean[] set = new boolean[101];

  public static void main(String[] args) {
    t = scanner.nextInt();

    num = 0;
    while (num != t) {
      num++;
      prb();
    }
  }

  static void prb() {
    read();

    int trace = 0;
    for (int i = 0; i != n; i++) {
      trace += mtx[i][i];
    }

    int rLines = 0;
    for (int i = 0; i != n; i++) {
      initSet();
      int j = 0;
      while (j != n && !set[mtx[i][j]]) {
        set[mtx[i][j]] = true;
        j++;
      }

      if (j != n) {
        rLines++;
      }
    }

    int rColumns = 0;
    for (int i = 0; i != n; i++) {
      initSet();
      int j = 0;
      while (j != n && !set[mtx[j][i]]) {
        set[mtx[j][i]] = true;
        j++;
      }

      if (j != n) {
        rColumns++;
      }
    }

    System.out.printf("Case #%d:%d %d %d\n", num, trace, rLines, rColumns);
  }

  static void read() {
    n = scanner.nextInt();

    for (int i = 0; i != n; i++) {
      for (int j = 0; j != n; j++) {
        mtx[i][j] = scanner.nextInt();
      }
    }
  }

  static void initSet() {
    int i = 0;
    while (i != n) {
      i++;
      set[i] = false;
    }
  }
}