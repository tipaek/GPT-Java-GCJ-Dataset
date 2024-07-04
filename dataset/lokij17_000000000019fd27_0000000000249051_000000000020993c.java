import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

 class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int i = 0; i < T; i++) {
      int n = in.nextInt();
      int dupRows = 0, dupCols = 0;
      int trace = 0;
      ArrayList<HashSet<Integer>> arr = new ArrayList<>(n);
      for (int k =0; k < n; k++) {
        HashSet<Integer> rowSet = new HashSet<>();
        for (int j = 0; j < n; j++) {
          if (arr.size() < n) {
            arr.add(new HashSet<>());
          }
          int ele = in.nextInt();
          arr.get(j).add(ele);
          rowSet.add(ele);
          if (j==k) {
            trace+=ele;
          }
        }
        if (rowSet.size() < n) {
          dupRows++;
        }
      }

      for (HashSet set : arr) {
        if (set.size() < n) {
          dupCols++;
        }
      }

      System.out.println("Case #" + (i+1) +": " + trace + " " + dupRows + " " + dupCols);
    }
  }

}
