import java.util.*;
import java.io.*;
    
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int countTest = in.nextInt();
    for (int i = 1; i <= countTest; i++) {
      int sizeI = in.nextInt();
      int[][] m = new int[sizeI][sizeI];
      for (int j = 0; j < sizeI; j++) {
        for (int k = 0; k < sizeI; k++) {
          m[j][k] = in.nextInt();
        }
      }
      calculate(m, i);
    }
  }
  
   public static void calculate(int[][] m, int num) {
    int d = 0, row = 0, col = 0;
    if (m == null || m.length == 0) {
      System.out.println("Case #" + num + ": " + d + " " + row + " " + col);
      return;
    }
    // d
    for (int i = 0; i < m.length; i++) {
      d += m[i][i];
    }
    // row
    Set<Integer> s = new HashSet<>();
    for (int i = 0; i < m.length; i++) {
      s = new HashSet<>();
      for (int j = 0; j < m[0].length; j++) {
        if (s.contains(m[i][j])) {
          row++;
          break;
        }
        s.add(m[i][j]);
      }
    }
    // col
    for (int i = 0; i < m[0].length; i++) {
      s = new HashSet<>();
      for (int j = 0; j < m.length; j++) {
        if (s.contains(m[j][i])) {
          col++;
          break;
        }
        s.add(m[j][i]);
      }
    }
    System.out.println("Case #" + num + ": " + d + " " + row + " " + col);
  }
}
    