import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private Scanner input;
    private PrintStream output;

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in); PrintStream output = System.out) {
            int numCases = input.nextInt();

            for (int t = 0; t < numCases; t++) {
                output.printf("Case #%d: ", t + 1);
                output.println(new Solution(input, output).solve());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    public Solution(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public String solve() {
        int n = input.nextInt();
        StringBuilder sb = new StringBuilder();
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            activities.add(new Activity(input.nextInt(), input.nextInt()));
        }

        for (int i = 0; i < (1 << n); i++) {
            String distribution = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            if (isValidDistribution(activities, distribution)) {
                for (char c : distribution.toCharArray()) {
                    sb.append(c == '0' ? 'C' : 'J');
                }
                return sb.toString();
            }
        }

        return "IMPOSSIBLE";
    }

    private boolean isValidDistribution(List<Activity> activities, String distribution) {
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();

        for (int i = 0; i < distribution.length(); i++) {
            if (distribution.charAt(i) == '0') {
                cameronActivities.add(activities.get(i));
            } else {
                jamieActivities.add(activities.get(i));
            }
        }

        return areNonOverlapping(cameronActivities) && areNonOverlapping(jamieActivities);
    }

    private boolean areNonOverlapping(List<Activity> activities) {
        Collections.sort(activities);
        for (int i = 1; i < activities.size(); i++) {
            if (activities.get(i).overlaps(activities.get(i - 1))) {
                return false;
            }
        }
        return true;
    }

    private static class Activity implements Comparable<Activity> {
        private final int start;
        private final int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }

        public boolean overlaps(Activity other) {
            return this.start < other.end && this.end > other.start;
        }
    }
}