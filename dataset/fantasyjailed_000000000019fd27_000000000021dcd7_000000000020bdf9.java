import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    private static class Activity implements Comparable<Activity> {
        Integer beg;
        Integer end;

        public Activity(Integer beg, Integer end) {
            this.beg = beg;
            this.end = end;
        }

        @Override
        public int compareTo(Activity o) {
            return this.beg.compareTo(o.beg);
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
                activities[i] = new Activity(begArr[i], endArr[i]);
            }

            Arrays.sort(begArr);
            Arrays.sort(endArr);
            Arrays.sort(activities);

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
                Activity jamie = activities[0];
                Activity cameron = activities[1];
                sb.append("JC");
                for (int i = 2; i < activities.length; i++) {
                    Activity next = activities[i];
                    if (next.beg >= jamie.end) {
                        sb.append("J");
                        jamie = next;
                    } else if (next.beg >= cameron.end) {
                        sb.append("C");
                        cameron = next;
                    }
                }
            }

            System.out.println(String.format("Case #%s: %s",
                    testCase, sb.toString()));
        }
    }

}
