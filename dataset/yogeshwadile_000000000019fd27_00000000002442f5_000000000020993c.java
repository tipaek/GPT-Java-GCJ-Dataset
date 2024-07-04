
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

  public static void main(String[] args) throws IOException {
    String resultString = "Case #%s: %s %s %s";
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int t = Integer.parseInt(line);

    int resultx = 1;
    for (int i = 0; i < t; i++) {
      line = br.readLine();
      int n = Integer.parseInt(line);
      int arr[][] = new int[n][n];
      int rowCount = 0;
      int resultk = 0;
      int resultr = 0;
      int resultc = 0;
      for (int row = 0; row < n; row++) {
        String s = br.readLine();
        if (s.isEmpty()) {
          continue;
        }
        int colCount = 0;
        String[] rows = s.split(" ");
        Set<Integer> set = new HashSet<>();
        boolean rowDuplicate = false;
        for (int rowc = 0; rowc < rows.length; rowc++) {
          int currValue = Integer.parseInt(rows[rowc]);
          arr[rowCount][colCount] = currValue;
          if (set.contains(currValue)) {
            rowDuplicate = true;
          }
          set.add(currValue);
          if (rowCount == colCount) {
            resultk += arr[rowCount][colCount];
          }
          colCount += 1;
        }
        rowCount += 1;
        if (rowDuplicate) {
          resultr += 1;
        }
      }

      for (int col = 0; col < arr[0].length; col++) {
        Set<Integer> set = new HashSet<>();
        boolean colDuplicate = false;
        for (int row = 0; row < arr.length; row++) {
          int currValue = arr[row][col];
          if (set.contains(currValue)) {
            colDuplicate = true;
          }
          set.add(currValue);
        }
        if (colDuplicate) {
          resultc += 1;
        }
      }
      System.out.println(String.format(resultString, resultx, resultk, resultr, resultc));
      resultx++;
    }
  }
}