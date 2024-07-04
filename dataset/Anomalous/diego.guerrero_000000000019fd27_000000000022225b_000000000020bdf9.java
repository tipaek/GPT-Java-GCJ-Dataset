import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private enum Parent {
        J, C
    }

    private static class Activity {
        private final int start;
        private final int end;
        private final int index;
        private Parent parent;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.parent = Parent.J;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d, %d, %s)", start, end, index, parent);
        }
    }

    private static final String CASE_TEMPLATE = "Case #%d: %s";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));
            }

            activities.sort(Comparator.comparingInt(a -> a.end));
            int lastEndC = 0;

            for (Activity activity : activities) {
                if (activity.start >= lastEndC) {
                    activity.parent = Parent.C;
                    lastEndC = activity.end;
                }
            }

            int lastEndJ = 0;
            boolean isImpossible = false;

            for (Activity activity : activities) {
                if (activity.parent == Parent.C) {
                    continue;
                }
                if (activity.start < lastEndJ) {
                    isImpossible = true;
                    break;
                } else {
                    lastEndJ = activity.end;
                }
            }

            String solution;
            if (isImpossible) {
                solution = IMPOSSIBLE;
            } else {
                activities.sort(Comparator.comparingInt(a -> a.index));
                StringBuilder result = new StringBuilder();

                for (Activity activity : activities) {
                    result.append(activity.parent);
                }

                solution = result.toString();
            }

            System.out.println(String.format(CASE_TEMPLATE, caseIndex, solution));
        }
    }
}