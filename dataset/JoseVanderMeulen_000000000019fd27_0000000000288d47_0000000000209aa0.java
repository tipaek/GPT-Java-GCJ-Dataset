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

    if (!verifyColumn(0, k)) {
      return false;
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
        addLine(x, i);
        addColumn(y, i);
        res = search(sz);
        removeColumn(y, i);
        removeLine(x, i);
      }
      i++;
    }

    sz++;
    ok[x][y] = false;
    return res;
  }

  static void addLine(int idx, int v) {
    for (int i = 0; i != n; i++) {
      if (mtx[idx][i][v] == 0) {
        cpt[idx][i]--;
      }
      mtx[idx][i][v]++;
    }
  }

  static void addColumn(int idx, int v) {
    for (int i = 0; i != n; i++) {
      if (mtx[i][idx][v] == 0) {
        cpt[i][idx]--;
      }
      mtx[i][idx][v]++;
    }
  }

  static void removeLine(int idx, int v) {
    for (int i = 0; i != n; i++) {
      mtx[idx][i][v]--;
      if (mtx[idx][i][v] == 0) {
        cpt[idx][i]++;
      }
    }
  }

  static void removeColumn(int idx, int v) {
    for (int i = 0; i != n; i++) {
      mtx[i][idx][v]--;
      if (mtx[i][idx][v] == 0) {
        cpt[i][idx]++;
      }
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
    while(i != n && !res) {
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
