import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        int r = in.nextInt();
        int c = in.nextInt();
        int[][] input = new int[r][c];
        for (int p = 0; p < r; p++) {
            for (int q = 0; q < c; q++)
                input[p][q] = in.nextInt();
        }
        int res = findInterest(input, r, c);
        System.out.println("Case #" + i + ": " + res);
    }
  }
  
  public static int findInterest(int[][] input, int r, int c) {
      int totalSum = 0;
      int[][] next = new int[r][c];
      boolean flag = false;
      for (int i = 0; i < r; i++) {
          for (int j =0; j < c; j++) {
              if (input[i][j] != 0) {
              totalSum+= input[i][j];
              int currSum = 0;
              int currRow = i-1;
              int currCol = j-1;
              int count = 0;
              while (currRow >= 0 && input[currRow][j] == 0) {
                  currRow--;
              }
              if (currRow >= 0) {
                  currSum += input[currRow][j];
                  count++;
              }
              currRow = i+1;
              while (currRow < r && input[currRow][j] == 0) {
                  currRow++;
              }
              if (currRow < r) {
                  currSum += input[currRow][j];
                  count++;
              }
              while (currCol >= 0 && input[i][currCol] == 0) {
                  currCol--;
              }
              if (currCol >= 0) {
                  currSum += input[i][currCol];
                  count++;
              }
              currCol = j+1;
              while (currCol < c && input[i][currCol] == 0) {
                  currCol++;
              }
              if (currCol < c) {
                  currSum += input[i][currCol];
                  count++;
              }
              if (input[i][j] * count >= currSum) {
                  next[i][j] = input[i][j];
              } else {
                  flag = true;
              }
          }
          }
      }
    //   System.out.println(totalSum + " " + flag);
      if (!flag) {
          return totalSum;
      }
      return totalSum + findInterest(next, r, c);
  }
}