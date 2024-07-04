import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    StringTokenizer st;

    int numberTestCases = Integer.parseInt(in.readLine());

    int[][] matrix;

    for (int i = 1; i <= numberTestCases; i++) {
      int N = Integer.parseInt(in.readLine());
      matrix = new int[N][N];
      // get matrix
      for (int r = 0; r < N; r++) {
        st = new StringTokenizer(in.readLine());
        for (int c = 0; c < N; c++) {
          matrix[r][c] = Integer.parseInt(st.nextToken());
        }
      }

      // three numbers: trace, num rows wrong, num cols wrong
      int trace = 0;
      for (int j = 0; j < N; j++) {
        trace += matrix[j][j];
      }

      int numRows = 0;
      for (int r = 0; r < N; r++) {
        HashSet<Integer> hs = new HashSet<>();
        for (int c = 0; c < N; c++) {
          hs.add(matrix[r][c]);
        }
        if (hs.size() != N) {
          numRows++;
        }
      }

      int numCols = 0;
      for (int c = 0; c < N; c++) {
        HashSet<Integer> hs = new HashSet<>();
        for (int r = 0; r < N; r++) {
          hs.add(matrix[r][c]);
        }
        if (hs.size() != N) {
          numCols++;
        }
      }

      out.printf("Case #%d: %d %d %d\n", i, trace, numRows, numCols);
    }
    out.close();
  }
}
