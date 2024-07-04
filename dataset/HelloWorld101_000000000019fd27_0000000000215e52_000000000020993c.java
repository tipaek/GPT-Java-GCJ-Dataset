import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
  private static void calc(int N, int[][] A, int caseNo) {
    int dSum = 0;
    int dupRows = 0;
    int dupCols = 0;

    // diagonal sum
    for (int i = 0; i < N; i++) {
      dSum += A[i][i];
    }

    // check rows
    for (int i = 0; i < N; i++) {
      boolean[] X = new boolean[N + 1];
      for (int j = 0; j < N; j++) {
        int n = A[i][j];
        if (X[n]) {
          dupRows++;
          break;
        } else {
          X[n] = true;
        }
      }
    }

    // check columns
    for (int i = 0; i < N; i++) {
      boolean[] X = new boolean[N + 1];
      for (int j = 0; j < N; j++) {
        int n = A[j][i];
        if (X[n]) {
          dupCols++;
          break;
        } else {
          X[n] = true;
        }
      }
    }

    System.out.println("Case #" + caseNo + ": " + dSum + " "  + dupRows + " " + dupCols);
  }


  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int T = Integer.parseInt(br.readLine());

      for (int input = 1; input <= T; input++) {

        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][];

        for (int i = 0; i < N; i++) {
          String[] inp = br.readLine().split(" ");
          A[i] = new int[N];
          for (int j = 0; j < N; j++) {
            A[i][j] = Integer.parseInt(inp[j]);
          }
        }

        calc(N, A, input);

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
