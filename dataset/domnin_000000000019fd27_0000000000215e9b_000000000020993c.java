
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    int cnt = 1;
    while (t-- > 0) {
      int N = in.nextInt();
      int rCnt = 0, cCnt = 0, trace = 0;

      int[][] arr = new int[N][N];
      for (int r = 0; r < N; r++)
        for (int c = 0; c < N; c++) {
          arr[r][c] = in.nextInt();
          if (r == c) trace += arr[r][c];
        }
      for (int r = 0; r < N; r++) {
        Set<Integer> rSet = new HashSet<Integer>();
        for (int c = 0; c < N; c++) rSet.add(arr[r][c]);
        if (rSet.size() < N) rCnt++;
      }
      for (int c = 0; c < N; c++) {
        Set<Integer> cSet = new HashSet<Integer>();
        for (int r = 0; r < N; r++) cSet.add(arr[r][c]);
        if (cSet.size() < N) cCnt++;
      }

      System.out.println("Case #:" + cnt++ + " " + trace + " " + rCnt + " " + cCnt);
    }
    System.out.flush();
  }
}
