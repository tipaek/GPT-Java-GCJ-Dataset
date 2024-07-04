import java.util.Scanner;

//********************************************************************************************
//Indicium
//https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/0000000000209aa0
//********************************************************************************************
class Solution {
  static Scanner scanner = new Scanner(System.in);

  static int t;
  static int num;

  static int n;
  static int k;

  static int[][][] mtx = new int[50][50][50];

  static int[][] cpt = new int[50][50];
  static int[][] end = new int[50][50];
  static boolean[][] ok = new boolean[50][50];

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

    boolean res = search(n * n);
    print(res);
  }

  static boolean search(int sz) {
    if (sz == 0) {
      return true;
    }

    min();
    int x = minX;
    int y = minY;

    ok[x][y] = true;
    sz--;
    boolean res = false;

    int i = 0;
    while (i != n && !res) {
      if (mtx[x][y][i] == 0) {
        end[x][y] = i;
        add(x, y, i);

        if (x != y || x  == y && verifyColumn(0, k)) {
          res = search(sz);
        } 

        remove(x, y, i);
      }
      i++;
    }

    sz++;
    ok[x][y] = false;
    return res;
  }

  static void add(int x, int y, int v) {
    for (int i = 0; i != n; i++) {
      addCell(x, i, v);
      addCell(i, y, v);
    }
  }

  static void addCell(int idx, int jdx, int v) {
    if (mtx[idx][jdx][v] == 0) {
      cpt[idx][jdx]--;
    }
    mtx[idx][jdx][v]++;
  }

  static void remove(int x, int y, int v) {
    for (int i = 0; i != n; i++) {
      removeCell(x, i, v);
      removeCell(i, y, v);
    }
  }

  static void removeCell(int idx, int jdx, int v) {
    mtx[idx][jdx][v]--;
    if (mtx[idx][jdx][v] == 0) {
      cpt[idx][jdx]++;
    }
  }

  static boolean verifyColumn(int idx, int sum) {
    if (idx == n) {
      return sum == 0;
    }

    if (ok[idx][idx]) {
      return verifyColumn(idx + 1, sum - end[idx][idx]);
    }

    boolean res = false;
    int i = 0;
    while (i != n && !res) {
      if (mtx[idx][idx][i] == 0) {
        res = verifyColumn(idx + 1, sum - i);
      }
      i++;
    }
    return res;
  }

  static int minX;
  static int minY;

  static void min() {
    minX = -1;
    minY = -1;
    int min = n * n * n;
    for (int i = 0; i != n; i++) {
      for (int j = 0; j != n; j++) {
        if (!ok[i][j] && cpt[i][j] < min) {
          minX = i;
          minY = j;
          min = cpt[i][j];
        }
      }
    }
  }

  static void read() {
    n = scanner.nextInt();
    k = scanner.nextInt() - n;
  }

  static void print(boolean ok) {
    System.out.printf("Case #%d: ", num);
    if (!ok) {
      System.out.println("IMPOSSIBLE");
      return;
    }

    System.out.println("POSSIBLE");
    for (int i = 0; i != n; i++) {
      for (int j = 0; j != n; j++) {
        System.out.print(end[i][j] + 1 + " ");
      }
      System.out.println();
    }
  }
}
