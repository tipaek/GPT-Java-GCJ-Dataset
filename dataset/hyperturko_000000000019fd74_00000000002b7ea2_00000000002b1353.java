import java.io.*;
import java.util.*;

public class Solution {

  public static void main(final String[] args) {
    final Reader in = new Reader();

    for (int x = 1; in.hasNext(); x++) {
      final int n = in.next();

      System.out.println("Case #" + x + ":");

      walk(n);
    }
  }

  private static void walk(final int n) {
    int sum = 1;
    int r = 2;
    int k = 2;

    System.out.println("1 1");

    while(sum + calc(r, k) <= n) {
      sum += calc(r, k);
      System.out.println(r + " " + k);
      r++;
    }

    r--;
    k = 1;
    while(sum + calc(r, k) <= n) {
      sum += calc(r, k);
      System.out.println(r + " " + k);
      r--;
    }
  }

  private static int calc(final int r, final int k) {
    if (r == 1) return 1;
    if (k == 1) return 1;
    if (k == 2) return r - 1;
    else throw new IllegalStateException();
  }

  private static class Reader implements Iterator<Integer> {
    private final Scanner in;
    private final int T;

    public Reader() {
      in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      T = in.nextInt();
    }

    @Override
    public boolean hasNext() {
      return in.hasNext();
    }

    @Override
    public Integer next() {
      return in.nextInt();
    }
  }

}