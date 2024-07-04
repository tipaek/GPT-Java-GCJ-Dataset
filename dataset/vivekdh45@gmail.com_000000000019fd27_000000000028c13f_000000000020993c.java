import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i1 = 0; i1 < t; i1++) {
      int n = Integer.parseInt(br.readLine());
      int arr[][] = new int[n][n];
      int rows = 0;
      int columns = 0;
      int trace = 0;
      for (int j = 0; j < n; j++) {
        String[] values = br.readLine().split(" ");
        for (int k = 0; k < values.length; k++) {
          arr[j][k] = Integer.parseInt(values[k]);
        }
      }
      Map<Integer, Set<Integer>> map = new HashMap<>();
      Set<Integer> col = new HashSet<>();
      for (int i = 0; i < n; i++) {
        Set<Integer> set = new HashSet<>();
        boolean chosen = false;
        for (int j = 0; j < n; j++) {
          if (set.contains(arr[i][j]) && !chosen) {
            chosen = true;
            rows++;
          } else {
            set.add(arr[i][j]);
          }
          if (map.containsKey(j)) {
            if (map.get(j).contains(arr[i][j]) && !col.contains(j)) {
              ++columns;
              col.add(j);
            } else {
              map.get(j).add(arr[i][j]);
            }
          } else {
            Set<Integer> set1 = new HashSet<Integer>();
            set1.add(arr[i][j]);
            map.put(j, set1);
          }
          if(i==j)
            trace+=arr[i][j];
        }
      }
      System.out.println("Case #" + (i1 + 1) + ": " + trace + " " + rows + " " + columns);
    }
  }

}
