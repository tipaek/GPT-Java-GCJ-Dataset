import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        scanner.nextLine();

        for (int test = 1; test <= tests; test++) {
            String result = runSingleTest(scanner);
            System.out.printf("Case #%d: %s%n", test, result);
        }
    }

    public static String runSingleTest(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine();

        List<Activity> activities = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            activities.add(new Activity(i, start, end));
        }

        activities.sort(Comparator.comparing((Activity a) -> a.start).thenComparing(a -> a.end).thenComparing(a -> a.index));

        List<Activity> cameron = new ArrayList<>();
        List<Activity> jamie = new ArrayList<>();
        for (Activity activity : activities) {
            if (cameron.isEmpty() || cameron.get(cameron.size() - 1).end <= activity.start) {
                cameron.add(activity);
                activity.assignee = "C";
            } else if (jamie.isEmpty() || jamie.get(jamie.size() - 1).end <= activity.start) {
                jamie.add(activity);
                activity.assignee = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        activities.sort(Comparator.comparing((Activity a) -> a.index));
        return activities.stream().map(a -> a.assignee).collect(Collectors.joining(""));
    }

    public static class Activity {
        private final int index;

        private final int start;

        private final int end;

        private String assignee;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
}