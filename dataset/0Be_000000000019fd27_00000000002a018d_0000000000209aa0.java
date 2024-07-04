import java.util.*;
import java.io.*;

class Solution {
  private static ArrayList<int[]> possiblities;
  private static HashSet<Integer> possibilitiesHash;
  private static int N, K;
  private static int[][] solution;
  private static boolean possible;
  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    int TT = Integer.parseInt(in.readLine());
    int currTT = 0;
    StringBuilder output = new StringBuilder();

    while (currTT++ < TT) {
      output.append("Case #" + currTT + ": ");

      String[] input = in.readLine().split("\\s+");
      N = Integer.parseInt(input[0]);
      K = Integer.parseInt(input[1]);

      possiblities = new ArrayList<int[]>();
      possibilitiesHash = new HashSet<Integer>();

      int max = N <= K / 2 ? N : K / 2;
      for (int i = 1; i <= max; i++) {
        int[] used = new int[N];
        used[0] = i;
        findPossibilites(1, K - i, used);
      }

      possible = false;
      for (int[] p: possiblities) {
        solution = new int[N][N];
        for (int i = 0; i < N; i++) {
          solution[i][i] = p[i];
        }
        
        boolean[][] usedR = new boolean[N][N + 1];
        boolean[][] usedC = new boolean[N][N + 1];
        for (int i = 0; i < N; i++) {
          usedR[i][p[i]] = true;
          usedC[i][p[i]] = true;
        }

        possible = fill(0, 0, usedR, usedC);
        if (possible) break;
      }

      if (!possible) {
        output.append("IMPOSSIBLE\n");
      } else {
        output.append("POSSIBLE\n");
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < N - 1; j++) {
            output.append(solution[i][j] + " ");
          }
          output.append(solution[i][N - 1] + "\n");
        }
      }
      
      // output.append('\n');
    }

    out.print(output);

    in.close();
    out.close();
  }

  private static boolean fill(int r, int c, boolean[][] usedR, boolean[][] usedC) {
    if (r == N) {
      return true;
    }

    if (c == N) {
      return fill(r + 1, 0, usedR, usedC);
    }

    if (r == c) {
      return fill(r, c + 1, usedR, usedC);
    }

    for (int v = 1; v <= N; v++) {
      if (!usedR[r][v] && !usedC[c][v]) {
        usedR[r][v] = true;
        usedC[c][v] = true;
        solution[r][c] = v;
        boolean possible = fill(r, c + 1, usedR, usedC);
        if (possible) {
          return true;
        }
        usedR[r][v] = false;
        usedC[c][v] = false;
        solution[r][c] = 0;
      }
    }

    return false;
  }

  private static void findPossibilites(int i, int r, int[] used) {
    if (r == 0 && i == N) {
      int[] newPossibility = used.clone();
      Arrays.sort(newPossibility);
      if (!possibilitiesHash.contains(Arrays.hashCode(newPossibility))) {
        possibilitiesHash.add(Arrays.hashCode(newPossibility));
        possiblities.add(newPossibility);
      }
      return;
    } else if (r == 0 || i == N) {
      return;
    }

    int max = N <= r ? N : r;
    for (int j = 1; j <= max; j++) {
      if (r - j >= 0) {
        used[i] = j;
        findPossibilites(i + 1, r - j, used);
        used[i] = 0;
      }
    }
  }
  
}
