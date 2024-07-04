import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        processInput();
    }

    public static void processInput() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int testCases = scanner.nextInt();

        List<String> results = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            Map<Integer, Activity> activityMap = new HashMap<>();

            for (int j = 0; j < activitiesCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Activity newActivity = new Activity(start, end);
                activities.add(newActivity);
                activityMap.put(j, newActivity);
            }

            activities.sort(new ActivityComparator());

            String result = assignActivities(activities, activitiesCount);
            results.add(result);
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static String assignActivities(List<Activity> activities, int n) {
        List<Activity> cameronSchedule = new ArrayList<>();
        List<Activity> jamieSchedule = new ArrayList<>();
        boolean assignToCameron = true;
        StringBuilder result = new StringBuilder();

        for (Activity activity : activities) {
            int start = activity.getStart();
            int end = activity.getEnd();

            if (assignToCameron && (cameronSchedule.isEmpty() || cameronSchedule.get(cameronSchedule.size() - 1).getEnd() <= start)) {
                activity.setPerson('C');
                cameronSchedule.add(activity);
            } else if (!assignToCameron && (jamieSchedule.isEmpty() || jamieSchedule.get(jamieSchedule.size() - 1).getEnd() <= start)) {
                activity.setPerson('J');
                jamieSchedule.add(activity);
            } else if (assignToCameron && cameronSchedule.get(cameronSchedule.size() - 1).getEnd() > start && (jamieSchedule.isEmpty() || jamieSchedule.get(jamieSchedule.size() - 1).getEnd() <= start)) {
                assignToCameron = false;
                activity.setPerson('J');
                jamieSchedule.add(activity);
            } else if (!assignToCameron && jamieSchedule.get(jamieSchedule.size() - 1).getEnd() > start && (cameronSchedule.isEmpty() || cameronSchedule.get(cameronSchedule.size() - 1).getEnd() <= start)) {
                assignToCameron = true;
                activity.setPerson('C');
                cameronSchedule.add(activity);
            } else {
                return "IMPOSSIBLE";
            }
            assignToCameron = !assignToCameron;
        }

        Map<Integer, Character> personMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            personMap.put(i, activities.get(i).getPerson());
        }

        for (int i = 0; i < n; i++) {
            result.append(personMap.get(i));
        }

        return result.toString();
    }
}

class Activity {
    private final int start;
    private final int end;
    private char person;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setPerson(char person) {
        this.person = person;
    }

    public char getPerson() {
        return person;
    }
}

class ActivityComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity o1, Activity o2) {
        if (o1.getStart() == o2.getStart()) {
            return Integer.compare(o1.getEnd(), o2.getEnd());
        }
        return Integer.compare(o1.getStart(), o2.getStart());
    }
}