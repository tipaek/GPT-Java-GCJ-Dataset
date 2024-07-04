import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases;
    testCases = sc.nextInt();
    boolean[][] possible = new boolean[6][30];
    possible[2][2] = true;
    possible[2][4] = true;

    possible[3][3] = true;
    possible[3][6] = true;
    possible[3][9] = true;

    possible[4][4] = true;
    possible[4][6] = true;
    possible[4][7] = true;
    possible[4][8] = true;
    possible[4][9] = true;
    possible[4][10] = true;
    possible[4][11] = true;
    possible[4][12] = true;
    possible[4][13] = true;
    possible[4][14] = true;
    possible[4][16] = true;

    possible[5][5] = true;
    possible[5][6] = true;
    possible[5][7] = true;
    possible[5][8] = true;
    possible[5][9] = true;
    possible[5][10] = true;
    possible[5][11] = true;
    possible[5][12] = true;
    possible[5][13] = true;
    possible[5][14] = true;
    possible[5][15] = true;
    possible[5][16] = true;
    possible[5][17] = true;
    possible[5][18] = true;
    possible[5][19] = true;
    possible[5][20] = true;
    possible[5][21] = true;
    possible[5][22] = true;
    possible[5][23] = true;
    possible[5][25] = true;

    Integer[][] possibleSquare22 = new Integer[][]{{1, 2}, {2, 1}};
    Integer[][] possibleSquare24 = new Integer[][]{{2, 1}, {1, 2}};

    Integer[][] possibleSquare33 = new Integer[][]{{1, 2, 3}, {2, 1, 3}, {3, 2, 1}};
    Integer[][] possibleSquare36 = new Integer[][]{{2, 1, 3}, {3, 2, 1}, {1, 3, 2}};
    Integer[][] possibleSquare39 = new Integer[][]{{3, 1, 2}, {2, 3, 1}, {1, 2, 3}};

    Integer[][] possibleSquare44 = new Integer[][]{{1, 2, 3, 4}, {2, 1, 4, 3}, {4, 3, 1, 2},
        {3, 4, 2, 1}};
    Integer[][] possibleSquare46 = new Integer[][]{{1, 3, 2, 4}, {3, 2, 4, 1}, {2, 4, 1, 3},
        {4, 1, 3, 2}};
    Integer[][] possibleSquare47 = new Integer[][]{{3, 2, 4, 1}, {4, 1, 2, 3}, {2, 3, 1, 4},
        {1, 4, 3, 2}};
    Integer[][] possibleSquare48 = new Integer[][]{{2, 1, 3, 4}, {1, 2, 4, 3}, {4, 3, 2, 1},
        {3, 4, 1, 2}};
    Integer[][] possibleSquare49 = new Integer[][]{{1, 2, 4, 3}, {4, 3, 2, 1}, {2, 1, 3, 4},
        {3, 4, 1, 2}};
    Integer[][] possibleSquare411 = new Integer[][]{{1, 2, 3, 4}, {3, 4, 2, 1}, {2, 1, 4, 3},
        {4, 3, 1, 2}};
    Integer[][] possibleSquare412 = new Integer[][]{{3, 1, 2, 4}, {1, 3, 4, 2}, {4, 2, 3, 1},
        {2, 4, 1, 3}};
    Integer[][] possibleSquare413 = new Integer[][]{{2, 3, 1, 4}, {1, 4, 3, 2}, {3, 2, 4, 1},
        {4, 1, 2, 3}};
    Integer[][] possibleSquare414 = new Integer[][]{{4, 1, 3, 2}, {2, 3, 1, 4}, {3, 2, 4, 1},
        {1, 4, 2, 3}};
    Integer[][] possibleSquare416 = new Integer[][]{{4, 1, 3, 2}, {1, 4, 2, 3}, {2, 3, 4, 1},
        {3, 2, 1, 4}};
    Integer[][] possibleSquare410 = new Integer[][]{{1, 3, 4, 2}, {4, 2, 1, 3}, {2, 4, 3, 1},
        {3, 1, 2, 4}};

    Integer[][] possibleSquare55 = new Integer[][]{{1, 2, 3, 4, 5}, {2, 1, 4, 5, 3},
        {3, 5, 1, 2, 4}, {4, 3, 5, 1, 2}, {5, 4, 2, 3, 1}};
    Integer[][] possibleSquare56 = new Integer[][]{{1, 5, 4, 3, 2}, {3, 2, 5, 1, 4},
        {2, 4, 1, 5, 3}, {4, 1, 3, 2, 5}, {5, 3, 2, 4, 1}};
    Integer[][] possibleSquare57 = new Integer[][]{{1, 5, 4, 3, 2}, {2, 1, 5, 4, 3},
        {5, 3, 2, 1, 4}, {3, 4, 1, 2, 5}, {4, 2, 3, 5, 1}};
    Integer[][] possibleSquare58 = new Integer[][]{{1, 3, 4, 5, 2}, {3, 2, 5, 1, 4},
        {5, 4, 1, 2, 3}, {4, 1, 2, 3, 5}, {2, 5, 3, 4, 1}};
    Integer[][] possibleSquare59 = new Integer[][]{{1, 4, 3, 5, 2}, {4, 2, 5, 1, 3},
        {5, 3, 1, 2, 4}, {3, 1, 2, 4, 5}, {2, 5, 4, 3, 1}};
    Integer[][] possibleSquare510 = new Integer[][]{{2, 1, 3, 4, 5}, {1, 2, 4, 5, 3},
        {3, 5, 2, 1, 4}, {4, 3, 5, 2, 1}, {5, 4, 1, 3, 2}};
    Integer[][] possibleSquare511 = new Integer[][]{{1, 5, 2, 4, 3}, {5, 3, 4, 1, 2},
        {4, 2, 1, 3, 5}, {2, 1, 3, 5, 4}, {3, 4, 5, 2, 1}};
    Integer[][] possibleSquare512 = new Integer[][]{{1, 5, 2, 3, 4}, {5, 4, 3, 1, 2},
        {3, 2, 1, 4, 5}, {2, 1, 4, 5, 3}, {4, 3, 5, 2, 1}};
    Integer[][] possibleSquare513 = new Integer[][]{{2, 4, 1, 5, 3}, {4, 3, 5, 2, 1},
        {5, 1, 2, 3, 4}, {1, 2, 3, 4, 5}, {3, 5, 4, 1, 2}};
    Integer[][] possibleSquare514 = new Integer[][]{{2, 5, 1, 4, 3}, {5, 3, 4, 2, 1},
        {4, 1, 2, 3, 5}, {1, 2, 3, 5, 4}, {3, 4, 5, 1, 2}};
    Integer[][] possibleSquare515 = new Integer[][]{{3, 1, 2, 4, 5}, {1, 3, 4, 5, 2},
        {2, 5, 3, 1, 4}, {4, 2, 5, 3, 1}, {5, 4, 1, 2, 3}};
    Integer[][] possibleSquare516 = new Integer[][]{{4, 3, 2, 5, 1}, {3, 1, 5, 4, 2},
        {5, 2, 4, 3, 1}, {2, 4, 1, 3, 5}, {1, 5, 3, 2, 4}};
    Integer[][] possibleSquare518 = new Integer[][]{{3, 5, 1, 2, 4}, {5, 4, 2, 3, 1},
        {2, 1, 3, 4, 5}, {1, 3, 4, 5, 2}, {4, 2, 5, 1, 3}};
    Integer[][] possibleSquare519 = new Integer[][]{{4, 5, 1, 3, 2}, {5, 2, 3, 4, 1},
        {3, 1, 4, 5, 2}, {1, 4, 2, 5, 3}, {2, 3, 5, 1, 4}};
    Integer[][] possibleSquare517 = new Integer[][]{{4, 3, 1, 5, 2}, {3, 2, 5, 4, 1},
        {5, 1, 4, 3, 2}, {1, 4, 2, 3, 5}, {2, 5, 3, 1, 4}};
    Integer[][] possibleSquare520 = new Integer[][]{{4, 1, 2, 3, 5}, {1, 4, 3, 5, 2},
        {2, 5, 4, 1, 3}, {3, 2, 5, 4, 1}, {5, 3, 1, 2, 4}};
    Integer[][] possibleSquare521 = new Integer[][]{{5, 1, 3, 2, 4}, {3, 2, 4, 5, 1},
        {1, 4, 5, 3, 2}, {2, 5, 1, 4, 3}, {4, 3, 2, 1, 5}};
    Integer[][] possibleSquare522 = new Integer[][]{{5, 1, 2, 3, 4}, {2, 3, 4, 5, 1},
        {1, 4, 5, 2, 3}, {3, 5, 1, 4, 2}, {4, 2, 3, 1, 5}};
    Integer[][] possibleSquare523 = new Integer[][]{{5, 1, 2, 3, 4}, {4, 5, 1, 2, 3},
        {1, 3, 4, 5, 2}, {3, 2, 5, 4, 1}, {2, 4, 3, 1, 5}};
    Integer[][] possibleSquare525 = new Integer[][]{{5, 1, 2, 3, 4}, {1, 5, 3, 4, 2},
        {2, 4, 5, 1, 3}, {3, 2, 4, 5, 1}, {4, 3, 1, 2, 5}};

    for (int testCase = 1; testCase <= testCases; testCase++) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      if (n > 5) {
        return;
      }
      if (!possible[n][k]) {
        System.out.println("Case #" + testCase + ": IMPOSSIBLE");
      } else {
        System.out.println("Case #" + testCase + ": POSSIBLE");
        switch (n) {
          case 2:
            switch (k) {
              case 2:
                print2(possibleSquare22, 2);
                break;
              case 4:
                print2(possibleSquare24, 2);
                break;
            }
            break;
          case 3:
            switch (k) {
              case 3:
                print2(possibleSquare33, 3);
                break;
              case 6:
                print2(possibleSquare36, 3);
                break;
              case 9:
                print2(possibleSquare39, 3);
                break;
            }
            break;
          case 4:
            switch (k) {
              case 4:
                print2(possibleSquare44, 4);
                break;
              case 6:
                print2(possibleSquare46, 4);
                break;
              case 7:
                print2(possibleSquare47, 4);
                break;
              case 8:
                print2(possibleSquare48, 4);
                break;
              case 9:
                print2(possibleSquare49, 4);
                break;
              case 10:
                print2(possibleSquare410, 4);
                break;
              case 11:
                print2(possibleSquare411, 4);
                break;
              case 12:
                print2(possibleSquare412, 4);
                break;
              case 13:
                print2(possibleSquare413, 4);
                break;
              case 14:
                print2(possibleSquare414, 4);
                break;
              case 16:
                print2(possibleSquare416, 4);
                break;
            }
            break;
          case 5:
            switch (k) {
              case 5:
                print2(possibleSquare55, 5);
                break;
              case 6:
                print2(possibleSquare56, 5);
                break;
              case 7:
                print2(possibleSquare57, 5);
                break;
              case 8:
                print2(possibleSquare58, 5);
                break;
              case 9:
                print2(possibleSquare59, 5);
                break;
              case 10:
                print2(possibleSquare510, 5);
                break;
              case 11:
                print2(possibleSquare511, 5);
                break;
              case 12:
                print2(possibleSquare512, 5);
                break;
              case 13:
                print2(possibleSquare513, 5);
                break;
              case 14:
                print2(possibleSquare514, 5);
                break;
              case 15:
                print2(possibleSquare515, 5);
                break;
              case 16:
                print2(possibleSquare516, 5);
                break;
              case 17:
                print2(possibleSquare517, 5);
                break;
              case 18:
                print2(possibleSquare518, 5);
                break;
              case 19:
                print2(possibleSquare519, 5);
                break;
              case 20:
                print2(possibleSquare520, 5);
                break;
              case 21:
                print2(possibleSquare521, 5);
                break;
              case 22:
                print2(possibleSquare522, 5);
                break;
              case 23:
                print2(possibleSquare523, 5);
                break;
              case 25:
                print2(possibleSquare525, 5);
                break;
            }
            break;
        }
      }

    }
  }

  public static void print2(Integer data[][], int size) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(data[i][j] + " ");
      }
      System.out.println();
    }
  }
}
