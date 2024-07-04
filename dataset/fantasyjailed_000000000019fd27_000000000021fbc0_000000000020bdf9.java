import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

        private static class Activity {

        Integer beg;
        Integer end;
        Integer order;
        Character assigned;

        public Activity(Integer beg, Integer end, Integer order) {
            this.beg = beg;
            this.end = end;
            this.order = order;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "beg=" + beg +
                    ", end=" + end +
                    ", order=" + order +
                    ", assigned=" + assigned +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = in.nextInt();

            int[] begArr = new int[n];
            int[] endArr = new int[n];
            Activity[] activities = new Activity[n];

            for (int i = 0; i < n; i++) {
                begArr[i] = in.nextInt();
                endArr[i] = in.nextInt();
                activities[i] = new Activity(begArr[i], endArr[i], i);
            }

            Arrays.sort(begArr);
            Arrays.sort(endArr);

            boolean isImpossible = false;
            for (int i = 0; i < endArr.length - 2 && !isImpossible; i++) {
                if (endArr[i] > begArr[i + 2]) {
                    isImpossible = true;
                }
                if (begArr[i] == begArr[i + 1] && begArr[i] == begArr[i + 2]
                        || endArr[i] == endArr[i + 1] && endArr[i] == endArr[i + 2]) {
                    isImpossible = true;
                }
            }

            StringBuilder sb = new StringBuilder();
            if (isImpossible) {
                sb.append("IMPOSSIBLE");
            } else {
                Comparator<Activity> comparator = Comparator.comparing(activity -> activity.beg);
                comparator = comparator.thenComparing(activity -> activity.end);

                Arrays.sort(activities, comparator);

                Activity jamie = activities[0];
                jamie.assigned = 'J';
                Activity cameron = activities[1];
                cameron.assigned = 'C';
                for (int i = 2; i < activities.length; i++) {
                    Activity next = activities[i];
                    if (next.beg >= jamie.end) {
                        jamie = next;
                        jamie.assigned = 'J';
                    } else if (next.beg >= cameron.end) {
                        cameron = next;
                        cameron.assigned = 'C';
                    }
                }
//                System.out.println(Arrays.toString(activities));

                Arrays.sort(activities, Comparator.comparing(activity -> activity.order));
                for (Activity activity : activities) {
                    sb.append(activity.assigned);
                }
            }

            System.out.println(String.format("Case #%s: %s",
                    testCase, sb.toString()));
        }
    }

}
