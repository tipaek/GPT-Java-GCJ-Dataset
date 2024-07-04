import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfTestCases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int testCaseIndex, Scanner scanner) {
        int activityCount = Integer.parseInt(scanner.nextLine());
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < activityCount; i++) {
            String[] times = scanner.nextLine().split(" ");
            activities.add(new Activity(Integer.parseInt(times[0]), Integer.parseInt(times[1]), i));
        }

        Collections.sort(activities);

        try {
            scheduleActivities(activities);
            printSchedule(testCaseIndex, activities);
        } catch (RuntimeException e) {
            System.out.printf("Case #%d: IMPOSSIBLE%n", testCaseIndex);
        }
    }

    private static void printSchedule(int testCaseIndex, List<Activity> activities) {
        StringBuilder schedule = new StringBuilder();

        for (Activity activity : activities) {
            schedule.append(activity.assignedPerson);
        }

        System.out.printf("Case #%d: %s%n", testCaseIndex, schedule.toString());
    }

    private static void scheduleActivities(List<Activity> activities) {
        Person cameron = new Person("C");
        Person jamie = new Person("J");

        for (Activity activity : activities) {
            if (cameron.canTakeActivity(activity)) {
                cameron.assignActivity(activity);
            } else if (jamie.canTakeActivity(activity)) {
                jamie.assignActivity(activity);
            } else {
                throw new RuntimeException("No available person to take the activity");
            }
        }

        activities.sort(Comparator.comparingInt(a -> a.originalOrder));
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;
    int originalOrder;
    String assignedPerson;

    public Activity(int start, int end, int originalOrder) {
        this.start = start;
        this.end = end;
        this.originalOrder = originalOrder;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.start, other.start);
    }
}

class Person {
    String name;
    Activity currentActivity;

    public Person(String name) {
        this.name = name;
    }

    public boolean canTakeActivity(Activity activity) {
        return currentActivity == null || currentActivity.end <= activity.start;
    }

    public void assignActivity(Activity activity) {
        currentActivity = activity;
        activity.assignedPerson = name;
    }
}