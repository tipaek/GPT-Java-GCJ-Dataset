import java.util.Scanner;

public class Solution {
  static Scanner scanner = new Scanner(System.in);

  static int t;
  static int num;

  static int x;
  static int y;

  static int[] xb;
  static int[] yb;

  static int max;

  public static void main(String[] args) {
    t = scanner.nextInt();
    scanner.nextLine();

    num = 0;
    while (num != t) {
      num++;
      prb();
    }
  }

  static void prb() {
    read();

    int xv = 1;
    if (x < 0) {
      x = -x;
      xv = -1;
    }
    max = decompose(xb, x, xv);

    int yv = 1;
    if (y < 0) {
      y = -y;
      yv = -1;
    }
    int ydx = decompose(yb, y, yv);

    max = max(max, ydx);

    int xf = 10000;
    int yf = 10000;

    int i = 0;
    while (i != max) {
      if (xb[i] == 0 && yb[i] == 0) {
        System.out.printf("Case #%d: IMPOSSIBLE\n", num);
        return;
      }

      if (xb[i] != 0 && (i == 0 || xb[i - 1] == 0)) {
        xf = i;
      }

      if (yb[i] != 0 && (i == 0 || yb[i - 1] == 0)) {
        yf = i;
      }

      if (xb[i] != 0 && yb[i] != 0 && xf == yf) {
        System.out.printf("Case #%d: IMPOSSIBLE\n", num);
        return;
      }
      
      if (xb[i] != 0 && yb[i] != 0 && xf < yf) {
        int tmp0 = xb[xf];
        int tmp1 = eatOne(xb, xf);
        xb[xf] = -tmp0;
        xb[tmp1] = tmp0;
        max = max(max, tmp1 + 1);
      } else if (xb[i] != 0 && yb[i] != 0) {
        int tmp0 = yb[yf];
        int tmp1 = eatOne(yb, yf);
        yb[yf] = -tmp0;
        yb[tmp1] = tmp0;
        max = max(max, tmp1 + 1);
      }
      
      i++;
    }

    System.out.printf("Case #%d: ", num);
    for (i = 0; i != max; i++) {
      if (xb[i] == 1) {
        System.out.print("E");
      } else if (xb[i] == -1) {
        System.out.print("W");
      } else if (yb[i] == 1) {
        System.out.print("N");
      } else {
        System.out.print("S");
      }
    }
    System.out.println();
  }

  static int max(int x, int y) {
    if (x > y) {
      return x;
    } else {
      return y;
    }
  }

  static int eatOne(int t[], int idx) {
    while (idx != t.length && t[idx] != 0) {
      t[idx] = 0;
      idx++;
    }
    return idx;
  }

  // ***************************************************************************
  // INPUT
  // ***************************************************************************

  static void read() {
    xb = new int[100];
    yb = new int[100];
    x = scanner.nextInt();
    y = scanner.nextInt();
  }

  static int decompose(int[] t, int n, int v) {
    int i = 0;
    while (n != 0) {
      if (n % 2 != 0) {
        t[i] = v;
      }
      i++;
      n = n / 2;
    }
    return i;
  }
}