import java.io.*;
import java.util.*;

public class Solution {

  static BufferedReader br;
  static PrintWriter out;
  static StringTokenizer st;

  static int T;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(new OutputStreamWriter(System.out));
    //br = new BufferedReader(new FileReader("in.txt"));
    //out = new PrintWriter(new FileWriter("out.txt"));

    T = readInt();
  main:
    for (int t = 1; t <= T; t++) {
      int N = readInt();
      String prefix = "";
      StringBuilder middle = new StringBuilder("");
      String suffix = "";
      for (int i = 0; i < N; i++) {
        String[] tokens = (readLine() + " ").split("\\*");
        if (tokens[0].length() < prefix.length()) {
          if (!prefix.startsWith(tokens[0])) {
            out.printf("Case #%d: *%n", t);
            continue main;
          }
        } else if (tokens[0].length() >= prefix.length()) {
          if (!tokens[0].startsWith(prefix)) {
            out.printf("Case #%d: *%n", t);
            continue main;
          }
          prefix = tokens[0];
        }

        for (int j = 1; j < tokens.length - 1; j++) {
          middle.append(tokens[j]);
        }

        if (tokens[tokens.length - 1].length() < suffix.length()) {
          if (!suffix.endsWith(tokens[tokens.length - 1])) {
            out.printf("Case #%d: *%n", t);
            continue main;
          }
        } else if (tokens[tokens.length - 1].length() >= suffix.length()) {
          if (!tokens[tokens.length - 1].endsWith(suffix)) {
            out.printf("Case #%d: *%n", t);
            continue main;
          }
          suffix = tokens[tokens.length - 1];
        }
      }
      out.printf("Case #%d: %s%n", t, prefix + middle.toString() + suffix.substring(0, suffix.length() - 1));
    }

    out.close();
  }

  static String next() throws IOException {
    while (st == null || !st.hasMoreTokens())
      st = new StringTokenizer(br.readLine().trim());
    return st.nextToken();
  }

  static long readLong() throws IOException {
    return Long.parseLong(next());
  }

  static int readInt() throws IOException {
    return Integer.parseInt(next());
  }

  static double readDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static char readCharacter() throws IOException {
    return next().charAt(0);
  }

  static String readLine() throws IOException {
    return br.readLine().trim();
  }
}
