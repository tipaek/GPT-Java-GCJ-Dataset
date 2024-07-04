

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by Hao Wu (wuhao.02@gmail.com) on 5/16/20.
 */
public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));


    int T = Integer.parseInt(reader.readLine());
    for (int t = 1; t <= T; t++) {
      String[] tokens= getTokens(reader);
      long L = Long.parseLong(tokens[0]);
      long R = Long.parseLong(tokens[1]);

      long k = 1;
      while (L >= k || R >=k){
        if (L>=R) {
          L -=k;
        } else {
          R -= k;
        }
        k++;
      }

      System.out.println("Case #" + t + ": " + (k-1) + " " + L + " " + R);
    }
  }

  private static String[] getTokens(BufferedReader reader) throws IOException {
    return reader.readLine().trim().split(" ");
  }

  private static int getInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine().trim());
  }
}
