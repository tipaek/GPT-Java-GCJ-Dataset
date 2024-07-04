import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
  public static void main(String... args) throws IOException {
    try {
      StringBuilder sb = new StringBuilder();

      // File file = new File("src/test/resources/input.txt");

      BufferedReader br = null;

      // Scanner in = new Scanner(new BufferedReader(new FileReader(file)));
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int examples = in.nextInt(); // Scanner has functions to read ints, longs, strings,
      for (int x = 0; x < examples; x++) {
        int n = in.nextInt();
        int k = in.nextInt();

        // n(n+1) / 2
        boolean r = false;

        if (n % 2 != 0) {
          r = k == (n * (n + 1)) / 2;
          if (!r) {
            for (int i = 1; i <= n; i++) {
              if (k == i * n) {
                r = true;
                break;
              }
            }
          }
        }

        String result = String.format("Case #%d: %s\n", x + 1, r == true ? "POSSIBLE" : "IMPOSSIBLE");
        sb.append(result);
      }
      System.out.println(sb);

    } catch (Exception ie) {
      System.out.println("Error: " + ie.getMessage());
    }

  }

}