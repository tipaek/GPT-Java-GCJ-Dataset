import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfCases = input.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            List<Activity> activities = readActivities(input);
            String result = assignActivities(activities);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static List<Activity> readActivities(Scanner input) {
        int numberOfActivities = input.nextInt();
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < numberOfActivities; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
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