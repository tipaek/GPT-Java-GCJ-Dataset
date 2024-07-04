import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int testCases = in.nextInt();
    for (int i = 1; i <= testCases; i++) {
      int matrixSize = in.nextInt();
      in.nextLine();

      int diagonal = 0;
      int duplicateRow = 0;
      int duplicateCol = 0;

      Map<Integer, Set<Integer>> cols = new HashMap<>();
      Map<Integer, Set<Integer>> rows = new HashMap<>();

      for (int j = 0; j < matrixSize; j++) {
        String line = in.nextLine().trim();
        String[] splits = line.split(" ");

        rows.put(j, new HashSet<>());

        for (int k = 0; k < matrixSize; k++) {
          int num = Integer.parseInt(splits[k]);

          if (!cols.containsKey(k))
            cols.put(k, new HashSet<>());

          rows.get(j).add(num);
          cols.get(k).add(num);

          if (j == k)
            diagonal += num;
        }
      }

      for (Set<Integer> set: rows.values()) {
        if (set.size() < matrixSize) duplicateRow++;
      }

      for(Set<Integer> set: cols.values()) {
        if (set.size() < matrixSize) duplicateCol++;
      }

      System.out.println("Case #" + i + ": " + diagonal + " " + duplicateRow + " " + duplicateCol);
    }
  }
}
