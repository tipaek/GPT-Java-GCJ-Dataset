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
        if (possible) break;

        possible = true;
        solution = new int[N][N];
        for (int i = 0; i < N; i++) {
          solution[i][i] = p[i];
        }
        
        for (int i = 0; i < N; i++) {
          boolean[] used = new boolean[N + 1];
          used[p[i]] = true;

          possible = fillRowCol(i, 0, used);
          if (!possible) break;
        }
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

  private static boolean fillRowCol(int r, int c, boolean[] used) {
    if (c == N) {
      return true;
    }

    if (r == c) {
      return fillRowCol(r, c + 1, used);
    }

    boolean[] _used = used.clone();
    for (int _r = 0; _r < r; _r++) {
      _used[solution[_r][c]] = true;
    }
    _used[solution[c][c]] = true;

    for (int v = 1; v <= N; v++) {
      if (!_used[v]) {
        used[v] = true;
        solution[r][c] = v;
        boolean possible = fillRowCol(r, c + 1, used);
        if (possible) {
          return true;
        }
        used[v] = false;
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
