import java.util.*;

public class Solution {

  static class Competiton {
    int[][] mat;
    boolean cf;
    int il = 0;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long tc = sc.nextInt();
    int tcn = 1;

    while (tc-- != 0) {
      int r = sc.nextInt();
      int c = sc.nextInt();

      long il = 0;
      int[][] mat = new int[r][c];
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          mat[i][j] = sc.nextInt();
          //          il += mat[i][j];
        }
      }

      Competiton cc = isCompetitionOver(mat, r, c);
      il += cc.il;
      while (!cc.cf) {
        Competiton ctemp = isCompetitionOver(cc.mat, r, c);
        cc.mat = ctemp.mat;
        cc.cf = ctemp.cf;
        cc.il = ctemp.il;
        il += ctemp.il;
      }

      System.out.println("Case #" + tcn + ": " + il);
      tcn++;
    }
  }

  static float calAvg(int[] arr) {
    float avg = 0.0f;
    float cnt = 0.0f;
    for (int i1 = 0; i1 < arr.length; i1++) {
      avg += arr[i1];
      if (arr[i1] != 0) {
        cnt++;
      }
    }

    if (cnt > 0) {
      return avg / cnt;
    }

    return 0;
  }

  static float NeigbourAvg(int[][] mat, int i, int j, int r, int c) {
    int[] avgarr = new int[4];

    if (i + 1 < r) {
      for (int k = i + 1; k < r; k++) {
        if (mat[k][j] != 0) {
          avgarr[0] = mat[k][j];
          break;
        }
      }
    }
    if (i - 1 >= 0) {
      for (int k = i - 1; k >= 0; k--) {
        if (mat[k][j] != 0) {
          avgarr[1] = mat[k][j];
          break;
        }
      }
    }
    if (j + 1 < c) {
      for (int k = j + 1; k < c; k++) {
        if (mat[i][k] != 0) {
          avgarr[2] = mat[i][k];
          break;
        }
      }
    }
    if (j - 1 >= 0) {
      for (int k = j - 1; k >= 0; k--) {
        if (mat[i][k] != 0) {
          avgarr[3] = mat[i][k];
          break;
        }
      }
    }

    return calAvg(avgarr);
  }

  static Competiton isCompetitionOver(int[][] mat, int r, int c) {
    boolean nf = true;
    int df[][] = new int[r][c];
    int il = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        // check if neighbours exist
        if (mat[i][j] != 0) {
          il += mat[i][j];
          float avg = NeigbourAvg(mat, i, j, r, c);
          if (avg <= mat[i][j]) {
            df[i][j] = mat[i][j];
          } else {
              nf = false;
          }
        }
      }
    }

    Competiton cz = new Competiton();
    cz.mat = df;
    cz.cf = nf;
    cz.il = il;
    return cz;
  }
}
