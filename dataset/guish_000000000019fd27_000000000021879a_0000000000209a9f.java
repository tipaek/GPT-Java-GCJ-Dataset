
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

  public static Scanner scanner = new Scanner(System.in);
  public static PrintStream out = System.out;

  public static void main(String[] args) throws IOException {

    int testCases = scanner.nextInt();
    scanner.nextLine();
    for (int i = 1; i <= testCases; i++) {

      String resp = solve(scanner.nextLine());
      out.printf("Case #%d: %s\n", i, resp);
    }

  }

  private static String solve(String s) {
    String r = "";
    int open = 0;

    for (char c : s.toCharArray()) {
      int i = Integer.parseInt(String.valueOf(c));
      int openNew = i - open;
      if (openNew > 0) {
        r += fill(openNew, "(");
      } else if (openNew < 0) {
        r += fill(openNew * -1, ")");
      }

      r += i;
      open += openNew;
    }

    if (open > 0) {
      r += fill(open, ")");
    }
    return r;

  }

  private static String fill(int n, String s) {
    return String.format("%0" + n + "d", 0).replace("0", s);
  }

}