
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Hao Wu (wuhao.02@gmail.com) on 4/10/20.
 */
public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));


    int T = Integer.parseInt(reader.readLine());
    for (int t = 1; t <= T; t++) {
      int N = getInt(reader);
      List<Integer> res = fac(N);
      System.out.println("Case #" + t + ": ");
      int i = 0;
      int x = 1;
      int y = 1;
      int bits = res.size();
      int tmp = N - bits;
      res = fac(tmp);
      while (i < res.size()) {
        int k = i;
        boolean left = y == 1;
        while (k < res.size() && res.get(k) == 0) {
          System.out.println(x + " " + y);
          if (!left) y++;
          x++;
          tmp ++;
          k++;
        }
        if (left) {
          while (y <= x) {
            System.out.println(x + " " + y);
            y++;
          }
        } else {
          while (y >= 1) {
            System.out.println(x + " " + y);
            y--;
          }
          y++;
        }
        x++;
        i = x-1;
      }
      while (tmp < N) {
        System.out.println(x + " " + y);
        x++;
        if (y!=1) y++;
        tmp++;
      }
    }
  }

  private static List<Integer> fac(int N) {
    List<Integer> ret = new ArrayList<>();
    while (N > 0) {
      ret.add(N%2);
      N = N / 2;
    }
    return ret;
  }

  private static String[] getTokens(BufferedReader reader) throws IOException {
    return reader.readLine().trim().split(" ");
  }

  private static int getInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine().trim());
  }
}
