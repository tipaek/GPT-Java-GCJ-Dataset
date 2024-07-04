import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    private static class Activity {
        private final int startTime;
        private final int endTime;
        private final int index;

        private String owner;

        public Activity(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getIndex() {
            return index;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getOwner() {
            return owner;
        }
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        for (int testCase = 1; testCase <= n; ++testCase) {
            int number = scanner.nextInt();
            printResult(testCase, solve(number));
        }
    }

    private static String solve(int N) {
        List<Activity> activities = new ArrayList<>(N);
        for (int index = 0; index < N; ++index) {
            activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), index));
        }

        activities.sort(Comparator.comparingInt(Activity::getStartTime));

        int cameron = 0, jamie = 0;
        for (Activity activity : activities) {
            if (cameron <= activity.startTime) {
                cameron = activity.endTime;
                activity.setOwner("C");
            } else if (jamie <= activity.startTime) {
                jamie = activity.endTime;
                activity.setOwner("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        activities.sort(Comparator.comparingInt(Activity::getIndex));

        return activities.stream()
            .map(Activity::getOwner)
            .collect(Collectors.joining());
    }

    private static void printResult(int testCase, String result) {
        System.out.println("Case #" + testCase + ": " + result);
    }
}