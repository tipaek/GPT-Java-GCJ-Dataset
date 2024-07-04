import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();
    for (int x = 1; x <= T; x++) {
      int R = Integer.parseInt(in.next());
      int S = Integer.parseInt(in.next());

      int N = (R - 1) * (S - 1);
      System.out.println("Case #" + x + ": " + N);

      int K = R * (S - 1) - 1;
      for (int i = R; i > 1; i--) {
        for (int j = 0; j < S - 1; j++) {
          System.out.println("" + i + " " + K);
          K--;
        }
      }
    }
  }
}