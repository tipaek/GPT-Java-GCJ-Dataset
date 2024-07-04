import java.io.*;
import java.util.*;

public class Solution {

private static int[] convertToIntArr(String[] data) {
  int[] res = new int[data.length];
  for (int i = 0; i < data.length; ++i) {
    res[i] = Integer.parseInt(data[i]);
  }
  return res;
}

private static int getDiagonal(int[][] m, int n) {
  int res = 0;
  for (int i = 0; i < n; ++i) {
    res += m[i][i];
  }
 return res;
} 

private static int matrixRowsWithRepeats(int[][] m) {
  int count = 0;
  for (int i = 0; i < m.length; ++i) {
    HashSet<Integer> set = new HashSet<Integer>();
    int[] row = m[i];
    for (int j = 0; j < row.length; ++j) {
      if (!set.contains(row[j])) {
        set.add(row[j]);
      } else {
        ++count;
        break;
      }
    }
  }
  return count;
}

private static int matrixColsWithRepeats(int[][] m) {
  int count = 0;
  for (int i = 0; i < m.length; ++i) {
    HashSet<Integer> set = new HashSet<Integer>();
    for (int j = 0; j < m.length; ++j) {
      if (!set.contains(m[j][i])) {
        set.add(m[j][i]);
      } else {
        ++count;
        break;
      }
    }
  }
  return count;
}


public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());

    int cs = 1;
    while (tc-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[][] matrix = new int[n][n];
      for (int i = 0; i < n; ++i) {
        String[] inp = br.readLine().split(" ");
        matrix[i] = convertToIntArr(inp);
      }
      int dg = getDiagonal(matrix, n);
      int r = matrixRowsWithRepeats(matrix);
      int c = matrixColsWithRepeats(matrix);
      System.out.println("Case #" + cs + ": " + dg + " " + r + " " + c);
      ++cs;
    }
  }
}
