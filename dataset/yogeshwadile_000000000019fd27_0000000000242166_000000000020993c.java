
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int t = Integer.parseInt(line);

    for (int i = 0; i < t; i++) {
      line = br.readLine();
      int n = Integer.parseInt(line);
      int arr[][] = new int[n][n];
      int rowCount = 0;

      for (int row = 0; row < n; row++) {
        String s = br.readLine();
        if (s.isEmpty()) {
          continue;
        }
        int colCount = 0;
        String[] rows = s.split(" ");
        for (int rowc = 0; rowc < rows.length; rowc++) {
          arr[rowCount][colCount] = Integer.parseInt(rows[rowc]);
          colCount += 1;
        }
        rowCount += 1;
      }
      
    }
  }
}