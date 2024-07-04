import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private enum Parent {
        J, C, N
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
            this.parent = Parent.N;
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

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, j));
            }

            activities.sort(Comparator.comparingInt(a -> a.start));
            int lastEndC = 0, lastEndJ = 0;

            for (Activity activity : activities) {
                if (activity.start >= lastEndC) {
                    activity.parent = Parent.C;
                    lastEndC = activity.end;
                } else if (activity.start >= lastEndJ) {
                    activity.parent = Parent.J;
                    lastEndJ = activity.end;
                } else {
                    activity.parent = Parent.N;
                }
            }

            boolean isImpossible = activities.stream().anyMatch(a -> a.parent == Parent.N);
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

            System.out.println(String.format(CASE_TEMPLATE, i, solution));
        }
    }
}