import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    private static boolean canAddActivity(int start, int end, List<Integer> activities) {
        if (activities.isEmpty()) {
            return true;
        }
        if (activities.get(activities.size() -1) <= start) {
            return true;
        }
        if (activities.get(0) >= end) {
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
        if (activities.isEmpty()) {
            activities.add(start);
            activities.add(end);
            return;
        }
        if (end <= activities.get(0)) {
            activities.add(0, end);
            activities.add(0, start);
            return;
        }
        if (start >= activities.get(activities.size() - 1)) {
            activities.add(start);
            activities.add(end);
            return;
        }
        int i = 0;
        while (i < activities.size()) {
            if (start > activities.get(i)) {
                activities.add(i, start);
            }
            i+=2;
        }
        i = 1;
        while (i < activities.size()) {
            if (start > activities.get(i)) {
                activities.add(i, end);
            }
            i+=2;
        }
    }
}