import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tests = Integer.parseInt(scanner.nextLine());
    for (int testNumber = 1; testNumber <= tests; testNumber++) {
      int n = Integer.parseInt(scanner.nextLine());
      int trace = 0;
      int duplicateRows = 0;
      int duplicateColumns = 0;
      List<Set<String>> columnsSets = new ArrayList<>();
      for (int columnCounter = 0; columnCounter < n; columnCounter++) {
        columnsSets.add(new HashSet<>());
      }
      for (int rowCounter = 0; rowCounter < n; rowCounter++) {
        String mi = scanner.nextLine();
        String[] row = mi.split(" ");
        Set<String> rowSet = new HashSet<>();
        for (int columnCounter = 0; columnCounter < n; columnCounter++) {
          columnsSets.get(columnCounter).add(row[columnCounter]);
          rowSet.add(row[columnCounter]);
          if(rowCounter == columnCounter) {
            trace = trace + Integer.parseInt(row[columnCounter]);
          }
        }
        if(rowSet.size() < n) {
          duplicateRows++;
        }
      }
      for (int columnCounter = 0; columnCounter < n; columnCounter++) {
        if(columnsSets.get(columnCounter).size() < n) {
          duplicateColumns++;
        }
      }
      System.out.println("Case #" + testNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }
  }

}
