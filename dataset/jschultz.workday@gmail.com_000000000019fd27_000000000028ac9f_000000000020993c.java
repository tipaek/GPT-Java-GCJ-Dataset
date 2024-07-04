import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; i++) {
        int n = in.nextInt();
        in.nextLine();

        int traceSum = 0;
        int rowCount = 0;
        int colCount = 0;

        HashMap<Integer, ArrayList<String>> rowDictionary = new HashMap<>();
        HashMap<Integer, Boolean> rowCounters = new HashMap<>();

        for (int row = 0; row < n; row++) {
            String[] values = in.nextLine().split(" ");
            traceSum += Integer.parseInt(values[row]);
            
            ArrayList<String> cols = new ArrayList<>();
            boolean colCounter = false;
            for (int col = 0; col < n; col++) {
              Boolean rowCounter = rowCounters.get(col);
              if (rowCounter == null) rowCounter = false;
              ArrayList<String> rows = rowDictionary.get(col);
              if (rows == null) rows = new ArrayList<>();

              rowCounter = rowCounter || rows.contains(values[col]);
              colCounter = colCounter || cols.contains(values[col]);

              rows.add(values[col]);
              cols.add(values[col]);
              rowDictionary.put(col, rows);
              rowCounters.put(col, rowCounter);

              if (row == n-1 && rowCounter) {
                rowCount++;
              }
              if (col == n-1 && colCounter) {
                colCount++;
              }
            }
        }

        System.out.println("Case #" + i + ": " + traceSum + " " + colCount + " " + rowCount);
    }
    in.close();
  }
}