
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Adedayo Ominiyi
 */
public class Solution {

  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));) {
      final int numberOfTestCases = Integer.parseInt(scanner.nextLine());

      activityLoop: for (int testCase = 0; testCase < numberOfTestCases; 
              testCase++) {
        final int activityCount = Integer.parseInt(scanner.nextLine());

        final Set<ActivityDuration> activitiesSet = new LinkedHashSet<>();
        for (int activity = 0; activity < activityCount; activity++) {
          final String line = scanner.nextLine();

          final String[] lineParts = line.split(" ");

          activitiesSet.add(new ActivityDuration(
                  Integer.parseInt(lineParts[0]), Integer.parseInt(lineParts[1])));
        }

        ActivityDuration[] sortedActivities = activitiesSet.toArray(
                new ActivityDuration[0]);
        final char defaultParent = 'J';
        final char[] parentAssigned = new char[sortedActivities.length];
        parentAssigned[0] = defaultParent;
        
        for (int i = 1; i < sortedActivities.length; i++) {
          final Set<Character> overlappingParent = new HashSet<>();
          
          for (int j = 0; j < i; j++) {
            ActivityDuration currentActivity = sortedActivities[i];
            ActivityDuration previousActivity = sortedActivities[j];
            
            final boolean doesNotOverlap = doesNotOverlap(previousActivity, 
                    currentActivity);
            if (!doesNotOverlap) {
              overlappingParent.add(parentAssigned[j]);
            }
          }
          if (overlappingParent.size() >= 2) {
            System.out.println(String.format("Case #%d: %s", testCase + 1,
                    "IMPOSSIBLE"));
            continue activityLoop;
          }
          
          if (overlappingParent.isEmpty()) {
            parentAssigned[i] = defaultParent;
          }
          
          if (overlappingParent.size() == 1) {
            if (overlappingParent.contains('C')) {
              parentAssigned[i] = 'J';
            } else if (overlappingParent.contains('J')) {
              parentAssigned[i] = 'C';
            }
          }
        }
        
        final String schedule = new String(parentAssigned);
        System.out.println(String.format("Case #%d: %s", testCase + 1,
               schedule));
      }
    }
  }
  
  private static boolean doesNotOverlap(final ActivityDuration previousActivity,
          final ActivityDuration currentActivity) {
    return previousActivity.startTime >= currentActivity.endTime 
            ||  currentActivity.startTime >= previousActivity.endTime;
  }

  static final class ActivityDuration implements Comparable<ActivityDuration> {

    final int startTime;
    final int endTime;

    ActivityDuration(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }

    @Override
    public int compareTo(ActivityDuration other) {
      final int compareStartTime = Integer.compare(startTime, other.startTime);

      if (compareStartTime == 0) {
        return Integer.compare(endTime, other.endTime);
      }

      return compareStartTime;
    }

    @Override
    public String toString() {
      return String.format("Start time: %d; End Time %s", startTime, endTime);
    }
  }
}