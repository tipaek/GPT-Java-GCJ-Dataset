import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTestCases = Integer.parseInt(in.nextLine());
    for (int i = 1; i <= numTestCases; ++i) {
      int sum = Integer.parseInt(in.nextLine());
      solveProblem(i, sum);
    }
  }
  private static void outputCase(int problem) {
    System.out.println("Case #" + problem + ":");
  }

  private static void outputPascal(int r, int k) {
    System.out.println(r + " " + k);
  }

  private static void solveProblem(int problem, int sum) {
    // dumb test case 1 brute force
    if (sum <= 500) {
      outputCase(problem);
      for (int r = 1; r <= sum; r++) {
        outputPascal(r, 1);
      }
    } else if (sum == 501) {
      outputCase(problem);
      outputPascal(1, 1);
      outputPascal(2, 1);
      outputPascal(3, 2);
      for (int r = 3; r <= sum - 1 - 1; r++) {
        outputPascal(r, 1);
      }
    } else if (sum > 501 && sum <= 677) {
      // traverse left side of 1s, go along row 9 and then go down until it meet
      outputCase(problem);
      for (int i = 1; i <= 8; i++) {
        outputPascal(i, 1);
      }
      for (int j = 1; j <= 9; j++) {
        outputPascal(9, j);
      }
      int newSum = sum - 256 - 8;
      int newRow = 10;
      while (newSum > 0) {
        outputPascal(newRow, newRow);
        newRow++;
        newSum--;
      }
    } else if (sum > 677 && sum <= 1000) {
      outputCase(problem);
      for (int i = 1; i <= 9; i++) {
        outputPascal(i, 1);
      }
      for (int j = 1; j <= 10; j++) {
        outputPascal(10, j);
      }
      int newSum = sum - 512 - 9;
      int newRow = 11;
      while (newSum > 0) {
        outputPascal(newRow, newRow);
        newRow++;
        newSum--;
      }
    }
  }
}