import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = sc.nextInt();
    int[][] M = new int[100][100];
    int x = 1;
    while (T-- > 0) {
      int N = sc.nextInt();
      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
          M[i][j] = sc.nextInt();
      int k = 0;
      for (int i = 0; i < N; i++) k += M[i][i];
      int targetSum = N*(N+1)/2;
      int r = 0;
      int rSum = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) rSum += M[i][j];
        if (rSum != targetSum) r++;
        rSum = 0;
      }
      int c = 0;
      int cSum = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) cSum += M[j][i];
        if (cSum != targetSum) c++;
        cSum = 0;
      }
      System.out.printf("Case #%d: %d %d %d\n", x++, k, r, c);
    }
  }
}