import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases;
    testCases = sc.nextInt();
    boolean [] [] possible = new boolean[6][30];
    possible[2][2] = true;
    possible[2][4] = true;

    possible[3][3] = true;
    possible[3][6] = true;
    possible[3][9] = true;

    possible[4][4] = true;
    possible[4][8] = true;
    possible[4][12] = true;
    possible[4][16] = true;
    possible[4][10] = true;

    possible[5][5] = true;
    possible[5][10] = true;
    possible[5][15] = true;
    possible[5][20] = true;
    possible[5][25] = true;

    String [] [] possibleSquare = new String[6][30];
    possibleSquare[2][2] = "1 2\n2 1";
    possibleSquare[2][4] = "2 1\n1 2";
    possibleSquare[3][3] = "1 2 3\n2 1 3\n3 2 1";
    possibleSquare[3][6] = "2 1 3\n3 2 1\n1 3 2";
    possibleSquare[3][9] = "3 1 2\n2 3 1\n1 2 3";

    possibleSquare[4][4] = "1 2 3 4\n2 1 4 3\n4 3 1 2\n3 4 2 1";
    possibleSquare[4][8] = "2 1 3 4\n1 2 4 3\n4 3 2 1\n3 4 1 2";
    possibleSquare[4][12] = "3 1 2 4\n1 3 4 2\n4 2 3 1\n2 4 1 3";
    possibleSquare[4][16] = "4 1 3 2\n1 4 2 3\n2 3 4 1\n3 2 1 4";
    possibleSquare[4][10] = "1 3 4 2\n4 2 1 3\n2 4 3 1\n3 1 2 4";

    possibleSquare[5][5] = "1 2 3 4 5\n2 1 4 5 3\n3 5 1 2 4\n4 3 5 1 2\n5 4 2 3 1";
    possibleSquare[5][10] = "2 1 3 4 5\n1 2 4 5 3\n3 5 2 1 4\n4 3 5 2 1\n5 4 1 3 2";
    possibleSquare[5][15] = "3 1 2 4 5\n1 3 4 5 2\n2 5 3 1 4\n4 2 5 3 1\n5 4 1 2 3";
    possibleSquare[5][20] = "4 1 2 3 5\n1 4 3 5 2\n2 5 4 1 3\n3 2 5 4 1\n5 3 1 2 4";;
    possibleSquare[5][25] = "5 1 2 3 4\n1 5 3 4 2\n2 4 5 1 3\n3 2 4 5 1\n4 3 1 2 5";;;

    for (int testCase = 1; testCase <= testCases; testCase++) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      if(n>5){
        return;
      }
      if(!possible[n][k]) {
        System.out.println("Case #" + testCase + ": IMPOSSIBLE");
      } else {
        System.out.println("Case #" + testCase + ": POSSIBLE");
        System.out.println(possibleSquare[n][k]);
      }
    }
  }
}
