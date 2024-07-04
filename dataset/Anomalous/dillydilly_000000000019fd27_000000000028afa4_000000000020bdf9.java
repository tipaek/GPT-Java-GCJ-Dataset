import java.util.*;

public class ParentingPartnerReturns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            List<Activity> activities = getActivities(scanner);
            String result = assignActivities(activities);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static List<Activity> getActivities(Scanner scanner) {
        int numActivities = scanner.nextInt();
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < numActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(i, start, end));
        }

        return activities;
    }

    private static String assignActivities(List<Activity> activities) {
        Collections.sort(activities);
        char[] schedule = new char[activities.size()];
        Arrays.fill(schedule, 'C');

        for (int i = 1; i < activities.size(); i++) {
            if (activities.get(i).start < activities.get(i - 1).end) {
                if (schedule[activities.get(i - 1).index] == 'J') {
                    return "IMPOSSIBLE";
                }
                schedule[activities.get(i).index] = 'J';
            }
        }

        return new String(schedule);
    }

    private static class Activity implements Comparable<Activity> {
        int index;
        int start;
        int end;

        Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}