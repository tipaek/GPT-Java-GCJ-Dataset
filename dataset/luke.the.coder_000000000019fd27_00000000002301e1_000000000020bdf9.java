import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        String parent;

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
            Activity[] activities1 = new Activity[n];
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(scanner.nextInt(), scanner.nextInt());
                activities1[i] = activities[i];
            }

            Arrays.sort(activities);

            Activity c = null, j = null;

            for (int i = 0; i < n; i++) {
                Activity a = activities[i];
                if (c == null || !c.isOverlap(a)) {
                    c = a;
                    a.parent = "C";
                } else if (j == null || !j.isOverlap(a)) {
                    j = a;
                    a.parent = "J";
                } else {
                    return "IMPOSSIBLE";
                }
            }

            return Stream.of(activities1).map(a -> a.parent).collect(Collectors.joining());
        }).run();
    }
}
