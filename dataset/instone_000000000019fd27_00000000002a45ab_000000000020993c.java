import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    int m[] = new int[n];
    Integer xy[][][] = new Integer[n][][];
    for (int i = 0; i < n; i++) {
      m[i] = Integer.parseInt(bf.readLine());
      xy[i] = new Integer[m[i]][m[i]];
      for (int j = 0; j < m[i]; j++) {
        String temp = bf.readLine();
        int k = 0;
        for (String a : temp.split(" ")) {
          xy[i][j][k++] = Integer.parseInt(a);
        }
      }
    }
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < xy.length; i++) {
      int sum = 0;
      for (int j = 0; j < xy[i].length; j++) {
        sum += xy[i][j][j];
      }
      int x = 0;
      int y = 0;
      for (int j = 0; j < xy[i].length; j++) {
        for (int k = 0; k < xy[i][j].length; k++) {
          if (set.contains(xy[i][j][k])) {
            x++;
            break;
          } else {
            set.add(xy[i][j][k]);
          }
        }
        set.clear();
      }

      for (int j = 0; j < xy[i].length; j++) {
        for (int k = 0; k < xy[i][j].length; k++) {
          if (set.contains(xy[i][k][j])) {
            y++;
            break;
          } else {
            set.add(xy[i][k][j]);
          }
        }
        set.clear();
      }
      System.out.println("Case #" + (i+1) +": " + sum + " " + x + " " + y + " ");
    }

  }
}