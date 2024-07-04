import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int numberOfActivities = scanner.nextInt();
            
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < numberOfActivities; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }

            Collections.sort(activities);

            boolean isJamieFree = true, isCameronFree = true;
            int jamieFreeUntil = -1, cameronFreeUntil = -1;
            StringBuilder result = new StringBuilder();

            for (Activity activity : activities) {
                if (!isJamieFree && activity.start >= jamieFreeUntil) {
                    isJamieFree = true;
                }
                if (!isCameronFree && activity.start >= cameronFreeUntil) {
                    isCameronFree = true;
                }

                if (isCameronFree) {
                    result.append('C');
                    cameronFreeUntil = activity.end;
                    isCameronFree = false;
                } else if (isJamieFree) {
                    result.append('J');
                    jamieFreeUntil = activity.end;
                    isJamieFree = false;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (!"IMPOSSIBLE".equals(result.toString())) {
                result = new StringBuilder(normalizeResult(activities, result.toString()));
            }

            System.out.printf("Case #%d: %s%n", caseIndex, result);
        }
    }

    private static String normalizeResult(List<Activity> activities, String unbalancedResult) {
        char[] normalizedResult = new char[unbalancedResult.length()];
        for (Activity activity : activities) {
            normalizedResult[activity.originalIndex] = unbalancedResult.charAt(activity.originalIndex);
        }
        return new String(normalizedResult);
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