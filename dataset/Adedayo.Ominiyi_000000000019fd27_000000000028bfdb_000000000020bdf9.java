
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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

      for (int testCase = 0; testCase < numberOfTestCases;
              testCase++) {
        boolean isImpossible = false;
        final int activityCount = Integer.parseInt(scanner.nextLine());
        final TreeSet<ActivityDuration> activitiesSet = new TreeSet<>();
        for (int activity = 0; activity < activityCount; activity++) {
          final String line = scanner.nextLine();
          final String[] lineParts = line.split(" ");

          activitiesSet.add(new ActivityDuration(
                  Integer.parseInt(lineParts[0]),
                  Integer.parseInt(lineParts[1]),
                  activity));
        }

        ActivityDuration[] sortedActivities = activitiesSet.toArray(
                new ActivityDuration[0]);
        final char defaultParent = 'C';
        final Schedule[] parentAssigned = new Schedule[sortedActivities.length];
        parentAssigned[0] = new Schedule(defaultParent,
                sortedActivities[0].originalActivityIndex);

        for (int i = 1; i < sortedActivities.length; i++) {
          final Set<Character> overlappingParent = new HashSet<>();
          final ActivityDuration currentActivity = sortedActivities[i];

          for (int j = 0; j < i; j++) {
            final ActivityDuration previousActivity = sortedActivities[j];
            final boolean doesNotOverlap = doesNotOverlap(previousActivity,
                    currentActivity);
            if (!doesNotOverlap) {
              overlappingParent.add(parentAssigned[j].parentChar);
            }
          }
          if (overlappingParent.size() >= 2) {
            parentAssigned[i] = new Schedule(' ',
                    currentActivity.originalActivityIndex);
            isImpossible = true;
          }

          if (overlappingParent.isEmpty()) {
            parentAssigned[i] = new Schedule(defaultParent,
                    currentActivity.originalActivityIndex);
          }

          if (overlappingParent.size() == 1) {
            if (overlappingParent.contains('C')) {
              parentAssigned[i] = new Schedule('J',
                      currentActivity.originalActivityIndex);
            } else if (overlappingParent.contains('J')) {
              parentAssigned[i] = new Schedule('C',
                      currentActivity.originalActivityIndex);
            }
          }
        }

        if (isImpossible) {
          System.out.println(String.format("Case #%d: %s", testCase + 1,
                  "IMPOSSIBLE"));
        } else {
          Arrays.sort(parentAssigned, new Comparator<Schedule>() {
            @Override
            public int compare(Schedule o1, Schedule o2) {
              return Integer.compare(o1.originalActivityIndex,
                      o2.originalActivityIndex);
            }
          });

          StringBuilder builder = new StringBuilder();
          for (int i = 0; i < parentAssigned.length; i++) {
            builder.append(parentAssigned[i].parentChar);
          }
          System.out.println(String.format("Case #%d: %s", testCase + 1,
                  builder.toString()));
        }
      }
    }
  }

  private static boolean doesNotOverlap(final ActivityDuration previousActivity,
          final ActivityDuration currentActivity) {
    return previousActivity.startTime >= currentActivity.endTime
            || currentActivity.startTime >= previousActivity.endTime;
  }
  
  static final class Schedule {
    final char parentChar;
    final int originalActivityIndex;

    Schedule(final char parentChar, final int originalActivityIndex) {
      this.parentChar = parentChar;
      this.originalActivityIndex = originalActivityIndex;
    }
    
    @Override
    public String toString() {
      return String.format("parentChar: %s; Original Activity Index: %s", 
              parentChar, originalActivityIndex);
    }
  }

  static final class ActivityDuration implements Comparable<ActivityDuration> {

    final int startTime;
    final int endTime;
    final int originalActivityIndex;

    ActivityDuration(final int startTime, final int endTime,
            final int originalActivityIndex) {
      this.startTime = startTime;
      this.endTime = endTime;
      this.originalActivityIndex = originalActivityIndex;
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
      return String.format("Start time: %d; End Time: %s; "
              + "Original Activity Index: %s", 
              startTime, endTime, originalActivityIndex);
    }
  }
}
