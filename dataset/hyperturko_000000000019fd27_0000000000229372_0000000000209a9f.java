import java.io.*;
import java.util.*;

public class Solution {

  public static void main(final String[] args) {
    final Reader in = new Reader();

    for (int x = 1; in.hasNext(); x++) {
      final String t = in.next();

      final String y = nestWithDepth(t);

      System.out.println("Case #" + x + ": " + y);
    }
  }

  private static String nestWithDepth(final String input) {
    final StringBuilder sb = new StringBuilder();
    int currentDepth = 0;
    for (char c : input.toCharArray()) {
      int cInt = c - '0';
      if (currentDepth != cInt) {
        for (int i = currentDepth; i != cInt;) {
          if (i < cInt) {
            sb.append('(');
            i++;
          } else {
            sb.append(')');
            i--;
          }
        }
        currentDepth = cInt;
      }
      sb.append(c);
    }
    
    for (int i = 0; i < currentDepth; i++) {
      sb.append(')');
    }

    return sb.toString();
  }

  private static class Reader implements Iterator<String> {
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
    public String next() {
      return in.next();
    }
  }

}