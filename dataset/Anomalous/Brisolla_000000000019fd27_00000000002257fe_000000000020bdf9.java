import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfActivities = scanner.nextInt();

            boolean isJamieAvailable = true;
            boolean isCameronAvailable = true;
            int jamieNextFreeTime = -1;
            int cameronNextFreeTime = -1;

            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));
            }

            Collections.sort(activities);

            StringBuilder assignment = new StringBuilder();
            for (Activity activity : activities) {
                if (!isJamieAvailable && activity.start >= jamieNextFreeTime) {
                    isJamieAvailable = true;
                }

                if (!isCameronAvailable && activity.start >= cameronNextFreeTime) {
                    isCameronAvailable = true;
                }

                if (isCameronAvailable) {
                    assignment.append("C");
                    cameronNextFreeTime = activity.end;
                    isCameronAvailable = false;
                } else if (isJamieAvailable) {
                    assignment.append("J");
                    jamieNextFreeTime = activity.end;
                    isJamieAvailable = false;
                } else {
                    assignment = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            String result = reorderResult(activities, assignment.toString());
            System.out.printf("Case #%d: %s%n", caseNumber, result);
        }
    }

    private static String reorderResult(List<Activity> activities, String unbalancedResult) {
        char[] resultArray = new char[unbalancedResult.length()];
        for (Activity activity : activities) {
            resultArray[activity.originalIndex] = unbalancedResult.charAt(activities.indexOf(activity));
        }
        return new String(resultArray);
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;
    int originalIndex;

    Activity(int start, int end, int originalIndex) {
        this.start = start;
        this.end = end;
        this.originalIndex = originalIndex;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.start, other.start);
    }

    @Override
    public String toString() {
        return "[" + start + " - " + end + "]";
    }
}