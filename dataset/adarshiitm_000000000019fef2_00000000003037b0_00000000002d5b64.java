import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String args[]) {
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      System.out.println("Case #" + ks + ": ");
      joinTheRanks(input.nextInt(), input.nextInt());
    }
  }

  private static void joinTheRanks(int r, int s) {
    System.out.println((s - 1) * (r - 1));

    for (int i = 0; i < r - 1; i++) {
      for (int j = 0; j < s - 1; j++) {
        int a = (s - 1) * (r - i) - j;
        int b = r - i - 1;
        System.out.println((a + " " + b));
      }
    }
  }

}