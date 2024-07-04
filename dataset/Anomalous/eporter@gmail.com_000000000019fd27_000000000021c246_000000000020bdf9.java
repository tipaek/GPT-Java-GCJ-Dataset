import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner;

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            Solution solution = new Solution(scanner);
            solution.execute();
        }
    }

    public Solution(Scanner scanner) {
        this.scanner = scanner;
    }

    public void execute() {
        int numberOfCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            processCase(caseNumber);
        }
    }

    private void processCase(int caseNumber) {
        int n = scanner.nextInt();
        List<Activity> activities = new ArrayList<>(n * 2);
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(i, start, true));
            activities.add(new Activity(i, end, false));
        }

        Collections.sort(activities);

        char[] schedule = new char[n];
        boolean isCFree = true;
        boolean isJFree = true;
        boolean isImpossible = false;

        for (Activity activity : activities) {
            if (activity.isStart) {
                if (isCFree) {
                    schedule[activity.index] = 'C';
                    isCFree = false;
                } else if (isJFree) {
                    schedule[activity.index] = 'J';
                    isJFree = false;
                } else {
                    isImpossible = true;
                    break;
                }
            } else {
                if (schedule[activity.index] == 'C') {
                    isCFree = true;
                } else {
                    isJFree = true;
                }
            }
        }

        String result = isImpossible ? "IMPOSSIBLE" : new String(schedule);
        System.out.printf("Case #%d: %s%n", caseNumber, result);
    }

    private static class Activity implements Comparable<Activity> {
        int index;
        int time;
        boolean isStart;

        public Activity(int index, int time, boolean isStart) {
            this.index = index;
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Activity other) {
            if (time != other.time) {
                return Integer.compare(time, other.time);
            }
            return Boolean.compare(!isStart, !other.isStart);
        }

        @Override
        public String toString() {
            return "Activity [index=" + index + ", time=" + time + ", isStart=" + isStart + "]";
        }
    }
}