import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      int N = sc.nextInt();
      int K = sc.nextInt();
      int sum = 0;
      for (int j = 1; j <= N; j++) {
        sum += j;
      }
      if (K % N != 0 || sum != K) {
        System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
        continue;
      }
      System.out.println(String.format("Case #%d: POSSIBLE", t));
      int start = K / N;
      for (int i = 0; i < N; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < N; j++) {
          sb.append(1 + (start + i + j) % N);
          sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
      }
    }
  }
}
