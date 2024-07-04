
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class Jam {
    /**
     * Scanner of StdIn.
     */
    private final Scanner scanner;

    /**
     * Number of test cases.
     */
    private final int numberOfCases;

    /**
     * The function that reads one test case and returns the solution.
     */
    private final Function<Scanner, String> solution;

    public Jam(Function<Scanner, String> solution) {
        scanner = new Scanner(System.in);
        numberOfCases = scanner.nextInt();
        this.solution = solution;
    }

    public void run() {
        for (int i = 0; i < numberOfCases; i++) {
            final String answer = solution.apply(scanner);
            System.out.printf("Case #%d: %s\n", i + 1, answer);
        }
    }
}

public class Solution {
    private static class Activity implements Comparable<Activity> {
        final int start;
        final int end;

        private Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Activity{" + "start=" + start + ", end=" + end + '}';
        }

        @Override
        public int compareTo(Activity o) {
            return Integer.compare(start, o.start);
        }

        public boolean isOverlap(Activity o) {
            return containsTimePoint(o.start) || o.containsTimePoint(start);
        }

        public boolean containsTimePoint(int tp) {
            return start <= tp && tp < end;
        }
    }

    public static void main(String[] args) {
        new Jam(scanner -> {
            int n = scanner.nextInt();

            Activity[] activities = new Activity[n];
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(activities);

            Activity c = null, j = null;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                Activity a = activities[i];
                if (c == null || !c.isOverlap(a)) {
                    c = a;
                    sb.append('C');
                } else if (j == null || !j.isOverlap(a)) {
                    j = a;
                    sb.append('J');
                } else {
                    return "IMPOSSIBLE";
                }
            }

            return sb.toString();
        }).run();
    }
}
