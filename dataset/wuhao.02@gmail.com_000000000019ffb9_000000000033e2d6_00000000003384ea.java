

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
      if (L > R) {
        long diff = L - R;
        k = (long) Math.ceil(Math.sqrt(2*diff));
        while (k*(k+1) / 2 > diff) k--;
        L = L - (k*(k+1)) / 2;
        while (L >= R) {
          k++;
          L = L - k;
        }
        k++;
        double rest = (-(k+1) + Math.sqrt((k+1)*(k+1) - 4*(k-R))) / 2;
        rest = Math.floor(rest);
        long inr = (long)rest;
        R = R - (inr * inr + (k+1) * inr + k);

        double lest = (-k + Math.sqrt(k*k + 4*L)) / 2;
        lest = Math.floor(lest);
        long intl = (long) lest;
        L = L - (intl * intl + k * intl);
        if (2*inr > 2*intl - 1) {
          k = k + 2*inr;
        } else {
          k = k + 2*intl - 1;
        }
      } else if (L == R) {
        L = L - k;
        k++;

        double rest = (-(k+1) + Math.sqrt((k+1)*(k+1) - 4*(k-R))) / 2;
        rest = Math.floor(rest);
        long inr = (long)rest;
        R = R - (inr * inr + (k+1) * inr + k);

        double lest = (-k + Math.sqrt(k*k + 4*L)) / 2;
        lest = Math.floor(lest);
        long intl = (long) lest;
        L = L - (intl * intl + k * intl);
        if (2*inr > 2*intl - 1) {
          k = k + 2*inr;
        } else {
          k = k + 2*intl - 1;
        }

      } else {
        long diff = R - L;
        k = (long) Math.ceil(Math.sqrt(2*diff));
        while (k*(k+1) / 2 > diff) k--;
        R = R - (k*(k+1)) / 2;
        while (R > L) {
          k++;
          R = R - k;
        }
        R = R + k;

        double rest = (-(k+1) + Math.sqrt((k+1)*(k+1) - 4*(k-R))) / 2;
        rest = Math.floor(rest);
        long inr = (long)rest;
        R = R - (inr * inr + (k+1) * inr + k);

        double lest = (-k + Math.sqrt(k*k + 4*L)) / 2;
        lest = Math.floor(lest);
        long intl = (long) lest;
        L = L - (intl * intl + k * intl);
        if (2*inr > 2*intl - 1) {
          k = k + 2*inr;
        } else {
          k = k + 2*intl - 1;
        }

      }
      /*
      while (L >= k || R >=k){
        if (L>=R) {
          L -=k;
        } else {
          R -= k;
        }
        k++;
      }
      */

      System.out.println("Case #" + t + ": " + k + " " + L + " " + R);
    }
  }

  private static String[] getTokens(BufferedReader reader) throws IOException {
    return reader.readLine().trim().split(" ");
  }

  private static int getInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine().trim());
  }
}
