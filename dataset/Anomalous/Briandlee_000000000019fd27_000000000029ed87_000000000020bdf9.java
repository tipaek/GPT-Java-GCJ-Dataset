import java.util.*;

public class Solution {

  public static void main(String[] args) {
    performCalculations();
  }

  public static void performCalculations() {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for (int i = 0; i < T; i++) {
      int N = scanner.nextInt();
      int[] startingTimes = new int[N];
      int[] endingTimes = new int[N];
      for (int j = 0; j < N; j++) {
        startingTimes[j] = scanner.nextInt();
        endingTimes[j] = scanner.nextInt();
      }

      int maxTime = Arrays.stream(startingTimes).max().orElse(0);
      maxTime = Math.max(maxTime, Arrays.stream(endingTimes).max().orElse(0));

      int[] cameronSchedule = new int[maxTime];
      int[] jamieSchedule = new int[maxTime];
      StringBuilder result = new StringBuilder();

      boolean possible = true;
      for (int j = 0; j < N; j++) {
        if (isAvailable(cameronSchedule, startingTimes[j], endingTimes[j])) {
          markSchedule(cameronSchedule, startingTimes[j], endingTimes[j]);
          result.append("C");
        } else if (isAvailable(jamieSchedule, startingTimes[j], endingTimes[j])) {
          markSchedule(jamieSchedule, startingTimes[j], endingTimes[j]);
          result.append("J");
        } else {
          possible = false;
          break;
        }
      }

      String output = possible ? result.toString() : "IMPOSSIBLE";
      System.out.println("Case #" + (i + 1) + ": " + output);
    }
  }

  private static boolean isAvailable(int[] schedule, int start, int end) {
    for (int k = start; k < end; k++) {
      if (schedule[k] == 1) return false;
    }
    return true;
  }

  private static void markSchedule(int[] schedule, int start, int end) {
    for (int k = start; k < end; k++) {
      schedule[k] = 1;
    }
  }
}