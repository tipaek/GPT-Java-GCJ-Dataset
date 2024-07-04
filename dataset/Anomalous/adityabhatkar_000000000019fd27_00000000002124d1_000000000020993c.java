import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCases = Integer.parseInt(scanner.nextLine());

    for (int testCase = 1; testCase <= testCases; testCase++) {
      int n = Integer.parseInt(scanner.nextLine());
      int trace = 0;
      int duplicateRows = 0;
      int duplicateColumns = 0;

      List<Set<String>> columnSets = new ArrayList<>(Collections.nCopies(n, new HashSet<>()));

      for (int i = 0; i < n; i++) {
        String[] row = scanner.nextLine().split(" ");
        Set<String> rowSet = new HashSet<>(Arrays.asList(row));

        if (rowSet.size() < n) {
          duplicateRows++;
        }

        for (int j = 0; j < n; j++) {
          columnSets.get(j).add(row[j]);

          if (i == j) {
            trace += Integer.parseInt(row[j]);
          }
        }
      }

      for (Set<String> columnSet : columnSets) {
        if (columnSet.size() < n) {
          duplicateColumns++;
        }
      }

      System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    scanner.close();
  }
}