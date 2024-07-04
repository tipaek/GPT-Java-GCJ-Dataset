import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    // Scanner sc = new Scanner(new File("input.txt"));
    int T = sc.nextInt();
    int[][] M = new int[100][100];
    int x = 1;
    Set<Integer> set = new HashSet<>();
    while (T-- > 0) {
      int N = sc.nextInt();
      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
          M[i][j] = sc.nextInt();
      int k = 0;
      for (int i = 0; i < N; i++) k += M[i][i];
      int r = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) set.add(M[i][j]);
        if (set.size() != N) r++;
        set.clear();
      }
      int c = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) set.add(M[j][i]);
        if (set.size() != N) c++;
        set.clear();
      }
      System.out.printf("Case #%d: %d %d %d\n", x++, k, r, c);
    }
  }
}