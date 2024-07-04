import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final String CAMERON = "C";
    private static final String JAMIE = "J";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = in.nextInt();
        in.nextLine();
        for (int k = 1; k <= numberOfTestCases; ++k) {
            final int numberOfActivities = in.nextInt();
            List<Integer> cameronsActivities = new ArrayList<>();
            List<Integer> jamiesActivities = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < numberOfActivities; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                if (canAddActivity(start, end, cameronsActivities)) {
                    addActivity(start, end, cameronsActivities);
                    result.append(CAMERON);
                } else if (canAddActivity(start, end, jamiesActivities)) {
                    addActivity(start, end, jamiesActivities);
                    result.append(JAMIE);
                } else {
                    result = new StringBuilder();
                    result.append("IMPOSSIBLE");
                }
            }
            System.out.println(String.format("Case #%d: %s", k, result.toString()));
        }
    }

    private static boolean endsBeforeFirst(int end, List<Integer> activities) {
        return end <= activities.get(0);
    }

    private static boolean startsAfterLast(int start, List<Integer> activities) {
        return start >= activities.get(activities.size() - 1);
    }

    private static boolean thereAreNoActivities(List<Integer> activities) {
        return activities.isEmpty();
    }

    private static boolean canAddActivity(int start, int end, List<Integer> activities) {
        if (thereAreNoActivities(activities) || startsAfterLast(start, activities) || endsBeforeFirst(end, activities)) {
            return true;
        }
        final List<Boolean> booleans = new ArrayList<>();
        for (int i = 0; i < activities.size(); i+=2) {
            boolean canAdd = true;
            final Integer currentStart = activities.get(i);
            final Integer currentEnd = activities.get(i + 1);
            if (start < currentEnd) {
                canAdd = false;
            } else if (end < currentStart) {
                canAdd = false;
            }
            booleans.add(canAdd);
        }
        return booleans.contains(Boolean.TRUE);
    }

    private static void addActivity(int start, int end, List<Integer> activities) {
        final List<Integer> activity = Arrays.asList(start, end);
        if (thereAreNoActivities(activities) || startsAfterLast(start, activities)) {
            activities.addAll(activity);
            return;
        }
        if (endsBeforeFirst(end, activities)) {
            activities.addAll(0, activity);
            return;
        }
        int insertIndex = getInsertIndex(start, activities);
        activities.addAll(insertIndex, activity);
    }

    private static int getInsertIndex(final int value, final List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        int index = -1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (value >= list.get(middle)) {
                start = middle + 1;
            } else {
                index = middle;
                end = middle - 1;
            }
        }
        return index;
    }
}