import java.io.*;
import java.util.*;

public class Solution {
  public static int trace(int[][] m, int n) {
    int sum = 0;
    for(int i = 0; i < n; i++) {
      sum += m[i][i];
    }
    return sum;
  }
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(f.readLine());
		for(int num = 1; num <= t; num++) {
      int n = Integer.parseInt(f.readLine());
      int[][] m = new int[n][n];
      for(int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int j = 0; j < n; j++) {
          m[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int trace = trace(m, n);
      
      int numRowsWithRepeats = 0;
      for(int i = 0; i < n; i++) {
        Set<Integer> seen = new HashSet<Integer>();
        for(int j = 0; j < n; j++) {
          if (seen.contains(m[i][j])) {
            numRowsWithRepeats++;
            break;
          } else {
            seen.add(m[i][j]);
          }
        }
      }

      int numColsWithRepeats = 0;
      for(int i = 0; i < n; i++) {
        Set<Integer> seen = new HashSet<Integer>();
        for(int j = 0; j < n; j++) {
          if (seen.contains(m[j][i])) {
            numColsWithRepeats++;
            break;
          } else {
            seen.add(m[j][i]);
          }
        }
      }

      System.out.println("Case #" + num + ": " + trace + " " + numRowsWithRepeats + " " + numColsWithRepeats);
		}
		f.close();
	}
}