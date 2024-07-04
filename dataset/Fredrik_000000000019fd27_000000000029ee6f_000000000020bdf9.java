import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int testCases = in.nextInt();
    for (int i = 1; i <= testCases; i++) {
      printSolution(i, getSequence(in));
    }
  }

  private static String getSequence(Scanner in) {
    int schedules = in.nextInt();
    in.nextLine();

    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    for (int j = 0; j < schedules; j++) {
      String line = in.nextLine();
      String[] splits = line.split(" ");

      int start = Integer.parseInt(splits[0]);
      int end = Integer.parseInt(splits[1]);

      queue.offer(new int[] { start, end, j });
    }

    int cameronFinished = 0;
    int jamieFinished = 0;
    char[] ans = new char[queue.size()];

    while(!queue.isEmpty()) {
      int[] interval = queue.poll();

      int start = interval[0];
      int end = interval[1];
      int index = interval[2];

      if (cameronFinished <= start) {
        ans[index] = 'C';
        cameronFinished = end;
      } else if (jamieFinished <= start) {
        ans[index] = 'J';
        jamieFinished = end;
      } else {
        return "IMPOSSIBLE";
      }
    }
    return new String(ans);
  }

  private static void printSolution(int i, String line) {
    System.out.println("Case #" + i + ": " + line);
  }
}
