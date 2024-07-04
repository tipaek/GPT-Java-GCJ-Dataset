import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Solution {

  void solve() throws IOException {
    int t = nextInt();
    for (int testCase = 0; testCase < t; testCase++) {
      int n = nextInt();
      int[][] a =new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          a[i][j] = nextInt();
        }
      }
      int sum = 0;
      int cols = 0;
      int rows = 0;
      for (int i = 0; i < n; i++) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int j = 0; j < n; j++) {
          row.add(a[i][j]);
          col.add(a[j][i]);
        }
        sum += a[i][i];
        if (col.size() != n) cols++;
        if (row.size() != n) rows++;
      }
      System.out.printf("Case #%d: %d %d %d\n", (testCase + 1), sum, rows, cols);
    }
  }

  public static void main(String[] args) throws IOException {
    new Solution().run();
  }

  void run() throws IOException {
    reader = new BufferedReader(new InputStreamReader(System.in));
//		reader = new BufferedReader(new FileReader("input.txt"));
    tokenizer = null;
    out = new PrintWriter(new OutputStreamWriter(System.out));
//		out = new PrintWriter(new FileWriter("output.txt"));
    solve();
    reader.close();
    out.flush();

  }

  BufferedReader reader;
  StringTokenizer tokenizer;
  PrintWriter out;

  int nextInt() throws IOException {
    return Integer.parseInt(nextToken());
  }

  long nextLong() throws IOException {
    return Long.parseLong(nextToken());
  }

  double nextDouble() throws IOException {
    return Double.parseDouble(nextToken());
  }

  String nextToken() throws IOException {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      tokenizer = new StringTokenizer(reader.readLine());
    }
    return tokenizer.nextToken();
  }
}
