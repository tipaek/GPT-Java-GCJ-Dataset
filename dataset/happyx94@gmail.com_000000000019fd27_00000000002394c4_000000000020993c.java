import java.util.*;
import java.io.*;

public class Solution {
  public static void main(final String[] args) {
    final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    final int t = in.nextInt();
    for (int caseNumber = 1; caseNumber <= t; ++caseNumber) {
      final int n = in.nextInt();
      final int target = (1 + n) * n / 2;
      final int [] colSums = new int[n];
      int k = 0, r = 0, c = 0;      
      
      for (int i = 0; i < n; i++) {
          int rowSum = 0;
          for (int j = 0; j < n; j++) {
              int num = in.nextInt();
              if (i == j) k += num;
              rowSum += num;
              colSums[j] += num;
          }
          if (target != rowSum) r++;
      }
      
      for (int sum: colSums) {
          if (target != sum) c++;
      }
      
      int m = in.nextInt();
      System.out.println("Case #" + caseNumber + ": " + k + " " + r + " " + c);
    }
  }
}