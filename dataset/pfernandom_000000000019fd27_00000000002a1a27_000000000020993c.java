import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
  public static void main(String... args) throws IOException {
    try {
      StringBuilder sb = new StringBuilder();
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int examples = in.nextInt(); // Scanner has functions to read ints, longs, strings,
      for (int x = 0; x < examples; x++) {
        int n = in.nextInt();

        int colCount = 0;
        int rowCount = 0;

        int rowRepeated[][] = new int[n + 1][n + 1];
        boolean[] isColRepeated = new boolean[n + 1];
        int trace = 0;

        for (int i = 0; i < n; i++) {
          int colRepeated[] = new int[n + 1];
          colRepeated[0] = -1;

          boolean isRowRepeated = false;

          for (int j = 0; j < n; j++) {
            int num = in.nextInt();

            if (i == j) {
              trace += num;
            }

            if (colRepeated[num] == 1 && isRowRepeated == false) {
              rowCount++;
              isRowRepeated = true;
            }
            if (rowRepeated[j][num] == 1 && isColRepeated[j] == false) {
              colCount++;
              isColRepeated[j] = true;
            }
            colRepeated[num] = 1;
            rowRepeated[j][num] = 1;
          }
        }

        String result = String.format("Case #%d: %d %d %d\n", x + 1, trace, rowCount, colCount);
        sb.append(result);
      }
      System.out.println(sb);

    } catch (Exception ie) {
      System.out.println("Error: " + ie.getMessage());
        ie.printStackTrace();
        
    }

  }

}