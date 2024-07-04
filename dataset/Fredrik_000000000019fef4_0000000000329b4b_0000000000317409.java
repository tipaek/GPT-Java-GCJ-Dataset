import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int testCases = in.nextInt();
    in.nextLine();
    testcase: for (int i = 1; i <= testCases; i++) {
      String line = in.nextLine();
      int[] coords = readCoordinates(line);
      String moves = readMoves(line);

      int x1 = coords[0];
      int y1 = coords[1];

      int x2 = 0;
      int y2 = 0;

      if (x1 == x2 && y1 == y2) {
        System.out.println(String.format("Case %d: %d", i, 0));
        continue testcase;
      }

      int minutes = 1;
      for (char move: moves.toCharArray()) {
          if (move == 'S') {
            y1--;
          } else if (move == 'N') {
            y1++;
          }

          if (x1 > x2) {
            x2++;
          } else if (x1 < x2) {
            x2--;
          } else if (y1 > y2) {
            y2++;
          } else if (y1 < y2) {
            y2--;
          }

          if (x1 == x2 && y1 == y2) {
            System.out.println(String.format("Case %d: %d", i, minutes));
            continue testcase;
          }
          minutes++;
      }

      System.out.println(String.format("Case %d: IMPOSSIBLE", i));
    }
  }

  private static int[] readCoordinates (String line) {
    int[] coords = new int[2];

    String[] splits = line.split(" ");
    coords[0] = Integer.parseInt(splits[0]);
    coords[1] = Integer.parseInt(splits[1]);

    return coords;
  }

  private static String readMoves (String line) {
    String[] splits = line.split(" ");
    return splits[splits.length - 1];
  }
}
