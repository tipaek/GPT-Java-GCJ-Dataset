import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Solution {
  private static final String USER_DIR = System.getProperty("user.dir");
  private static final String CNAME = MethodHandles.lookup().lookupClass().getName();
  private static final Random RAND = new Random();

  private static String join(Collection<?> objs, String delimiter) {
    StringBuilder sb = new StringBuilder();
    Iterator<?> it = objs.iterator();
    while (it.hasNext()) {
      sb.append(it.next());
      if (it.hasNext()) {
        sb.append(delimiter);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) throws FileNotFoundException {
    File inputFile = new File(USER_DIR + "/io/" + CNAME + ".in");
    Scanner scanner = inputFile.exists() ? new Scanner(inputFile) : new Scanner(System.in);
    int testCases = scanner.nextInt();

    for (int t = 1; t <= testCases; t++) {
      int numActivities = scanner.nextInt();
      int[][] activities = new int[numActivities][3];
      for (int i = 0; i < numActivities; i++) {
        activities[i][0] = scanner.nextInt();
        activities[i][1] = scanner.nextInt();
        activities[i][2] = i;
      }

      Arrays.sort(activities, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));

      StringBuilder schedule = new StringBuilder(" ".repeat(numActivities));
      int endCameron = 0;
      int endJamie = 0;

      for (int[] activity : activities) {
        if (endCameron <= activity[0]) {
          schedule.setCharAt(activity[2], 'C');
          endCameron = activity[1];
        } else if (endJamie <= activity[0]) {
          schedule.setCharAt(activity[2], 'J');
          endJamie = activity[1];
        } else {
          schedule.setLength(0);
          schedule.append("IMPOSSIBLE");
          break;
        }
      }

      System.out.printf("Case #%d: %s%n", t, schedule.toString());
    }

    scanner.close();
  }
}