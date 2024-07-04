import java.util.*;
import java.io.*;

class Solution {

  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    int TT = Integer.parseInt(in.readLine());
    int currTT = 0;
    StringBuilder output = new StringBuilder();

    while (currTT++ < TT) {
      int N = Integer.parseInt(in.readLine());

      int[][] matrix = new int[N][N];
      for (int i = 0; i < N; i++) {
        String[] input = in.readLine().split("\\s+");
        for (int j = 0; j < N; j++) {
          matrix[i][j] = Integer.parseInt(input[j]);
        }
      }

      int k = 0;
      for (int i = 0; i < N; i++) k += matrix[i][i];
      
      int r = 0;
      for (int i = 0; i < N; i++) {
        boolean[] repeated = new boolean[N+1];
        for (int j = 0; j < N; j++) {
          if (repeated[matrix[i][j]]) {
            r++;
            break;
          }
          repeated[matrix[i][j]] = true;
        }
      }
      
      int c = 0;
      for (int i = 0; i < N; i++) {
        boolean[] repeated = new boolean[N+1];
        for (int j = 0; j < N; j++) {
          if (repeated[matrix[j][i]]) {
            c++;
            break;
          }
          repeated[matrix[j][i]] = true;
        }
      }

      output.append("Case #" + currTT + ": " + k + " " + r + " " + c + "\n");
    }

    out.print(output);

    in.close();
    out.close();
  }

}