import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    for(int i = 0; i < t; ++i) {
      int n = sc.nextInt();
      sc.nextLine();
      //int[][] mat = new int[n][n];

      int k = 0, r = 0, c = 0;

      Map<Integer, Set<Integer>> seenColumn = new HashMap<>();
      Map<Integer, Boolean> columnFlag = new HashMap<>();
      for(int j = 0; j < n; ++j) {
        seenColumn.put(j, new HashSet<>());
        columnFlag.put(j, true);
      }

      for(int j = 0; j < n; ++j) {
        String[] ipInts = sc.nextLine().split(" ");
        Set<Integer> seenRow = new HashSet<>();
        boolean rowFlag = true;
        for(int l = 0; l < n; ++l) {
          //mat[j][l] = Integer.parseInt(ipInts[l]);
          int temp = Integer.parseInt(ipInts[l]);
          if(j == l) {
            //k += mat[j][l];
            k += temp;
          }
          if(rowFlag && seenRow.contains(temp)) {
            ++r;
            rowFlag = false;
          }
          seenRow.add(temp);
          if(columnFlag.get(l) && seenColumn.get(l).contains(temp)) {
            ++c;
            columnFlag.put(l, false);
          }
          seenColumn.get(l).add(temp);
        }
      }
      /*for(int j = 0; j < n; ++j) {
        for(int l = 0; l < n; ++l) {
          System.out.print(mat[j][l] + " ");
        }
        System.out.println();
      }*/

      System.out.println("Case #" + (i + 1) + ": " + k + " " + r + " " + c);
    }
  }
}
