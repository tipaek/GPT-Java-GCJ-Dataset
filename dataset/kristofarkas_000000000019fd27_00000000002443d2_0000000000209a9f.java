import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      String s = in.next();
      int[] a = s.chars().map(Character::getNumericValue).toArray();
      System.out.println("Case #" + i + ": " + nest(a, a.length));
    }
  }

  private static String nest(int[] digits, int n) {
    int befopen = 0;
    int aftclosed = 0;
    int[] bef = new int[n];
    int[] aft = new int[n];

    for (int i = 0; i < n; i++) {
      bef[i] = befopen <= digits[i] ? digits[i] - befopen : 0;
      befopen = digits[i];
    }

    for (int i = n-1; i > -1; i--) {
      aft[i] = aftclosed <= digits[i] ? digits[i] - aftclosed : 0;
      aftclosed = digits[i];
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < bef[i]; j++)
        sb.append('(');
      sb.append(digits[i]);
      for (int j = 0; j < aft[i]; j++)
        sb.append(')');
    }

    return sb.toString();
  }
}
