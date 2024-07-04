import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static char J = 'J';
    private static char C = 'C';

    public static void main(String... args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int testCasesCount = scanner.nextInt();
        for (int i=1; i<=testCasesCount; i++) {
            int jLastIndex = -1;
            int cLastIndex = -1;
            int activityCount = scanner.nextInt();
            Interval[] intervals = new Interval[activityCount];
            char[] chars = new char[activityCount];

            for (int j=0; j<activityCount; j++) {
                int lowerLimit = scanner.nextInt();
                int upperLimit = scanner.nextInt();
                intervals[j] = new Interval(lowerLimit, upperLimit, j);
            }
            Arrays.sort(intervals);

            for (int k=0; k<activityCount; k++) {
                if (jLastIndex != -1) {
                    if (intervals[jLastIndex].isIntervalOverlapping(intervals[k].lowerLimit, intervals[k].upperLimit)) {
                        if (cLastIndex != -1) {
                            if (intervals[cLastIndex].isIntervalOverlapping(intervals[k].lowerLimit, intervals[k].upperLimit)) {
                                chars = null;
                                break;
                            } else {
                                cLastIndex = k;
                                chars[intervals[k].activityIndex] = C;
                            }
                        } else {
                            cLastIndex = k;
                            chars[intervals[k].activityIndex] = C;
                        }
                    } else {
                        jLastIndex = k;
                        chars[intervals[k].activityIndex] = J;
                    }
                } else {
                    jLastIndex = k;
                    chars[intervals[k].activityIndex] = J;
                }
            }
            printResult(i, chars);
        }
        scanner.close();
    }

    private static void printResult(int i, char[] chars) {
        System.out.print("Case #");
        System.out.print(i);
        System.out.print(": ");
        if (chars != null) {
            for (char c : chars) {
                System.out.print(c);
            }
        } else {
            System.out.print("IMPOSSIBLE");
        }
        System.out.println();
    }

    private static class Interval implements Comparable<Interval> {
        int lowerLimit;
        int upperLimit;
        int activityIndex;

        public Interval(int lowerLimit, int upperLimit, int activityIndex) {
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
            this.activityIndex = activityIndex;
        }

        @Override
        public int compareTo(Interval o) {
            int result = lowerLimit - o.lowerLimit;
            if (result == 0) {
                result = upperLimit - o.upperLimit;
            }
            return result;
        }

        private boolean isIntervalOverlapping(int lowerLimit, int upperLimit) {
            return (lowerLimit > this.lowerLimit && lowerLimit < this.upperLimit) ||
                    (upperLimit < this.upperLimit && upperLimit > this.lowerLimit);
        }

        @Override
        public String toString() {
            return "(" + lowerLimit +
                    ", " + upperLimit +
                    ")";
        }
    }

}
