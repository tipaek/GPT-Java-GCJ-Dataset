import java.util.*;

class Activity {
    private int start, end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }
}

public class ActivitySelection {
    // Activity-Selection problem
    public static String selectActivities(List<Activity> activities) {
        int lastSelectedIndex = 0;
        StringBuilder schedule = new StringBuilder("J");

        for (int i = 1; i < activities.size(); i++) {
            if (activities.get(i).getStart() >= activities.get(lastSelectedIndex).getEnd()) {
                schedule.append("J");
                lastSelectedIndex = i;
            } else {
                schedule.append("C");
            }
        }

        if (schedule.length() < activities.size()) {
            return "IMPOSSIBLE";
        }

        return schedule.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activityCount; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }

            activities.sort(Comparator.comparingInt(Activity::getEnd));
            String result = selectActivities(activities);
            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }
}