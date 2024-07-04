import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedInputStream(System.in));
    PrintStream out = System.out;
    int T = in.nextInt();
    int N;
    int[][] M;
    int k, r, c;
    Set<Integer> s = new HashSet<>();
    for (int t = 1; t <= T; t++) {
      N = in.nextInt();
      M = new int[N][N];
      k = r = c = 0;
      for (int i = 0; i < N; i++) {
        s.clear();
        for (int j = 0; j < N; j++) {
          M[i][j] = in.nextInt();
          s.add(M[i][j]);
          if (i == j) {
            k += M[i][j];
          }
        }
        if (s.size() < N) {
          r++;
        }
      }
      for (int j = 0; j < N; j++) {
        s.clear();
        for (int i = 0; i < N; i++) {
          s.add(M[i][j]);
        }
        if (s.size() < N) {
          c++;
        }
      }
      out.println("Case #" + t + ": " + k + " " + r + " " + c);
    }
  }
}