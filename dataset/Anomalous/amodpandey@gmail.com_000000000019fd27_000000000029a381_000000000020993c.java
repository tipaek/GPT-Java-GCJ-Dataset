import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in); PrintWriter pw = new PrintWriter(System.out)) {
      int testCases = sc.nextInt();
      for (int testCase = 1; testCase <= testCases; testCase++) {
        int n = sc.nextInt();
        int k = 0, r = 0, c = 0;

        HashMap<Integer, HashSet<Integer>> rowMap = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> colMap = new HashMap<>();

        for (int p = 0; p < n * n; p++) {
          int i = p / n;
          int j = p % n;
          int val = sc.nextInt();
          if (i == j) k += val;

          rowMap.computeIfAbsent(i, key -> new HashSet<>()).add(val);
          colMap.computeIfAbsent(j, key -> new HashSet<>()).add(val);
        }

        for (HashSet<Integer> rowSet : rowMap.values()) {
          if (rowSet.size() != n) r++;
        }

        for (HashSet<Integer> colSet : colMap.values()) {
          if (colSet.size() != n) c++;
        }

        pw.printf("Case #%d: %d %d %d\n", testCase, k, r, c);
        pw.flush();
      }
    }
  }
}