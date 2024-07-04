import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
            activities.add(new Activity(Integer.parseInt(times[0]), Integer.parseInt(times[1])));
        }

        Collections.sort(activities);
        generateSchedule(testCaseIndex, activities);
    }

    private static void generateSchedule(int testCaseIndex, List<Activity> activities) {
        StringBuilder schedule = new StringBuilder();
        Person cameron = new Person("C");
        Person jamie = new Person("J");

        for (Activity activity : activities) {
            if (cameron.isAvailable(activity)) {
                cameron.assignActivity(activity);
                schedule.append(cameron.getName());
            } else if (jamie.isAvailable(activity)) {
                jamie.assignActivity(activity);
                schedule.append(jamie.getName());
            } else {
                schedule = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        System.out.println(String.format("Case #%d: %s", testCaseIndex, schedule.toString()));
    }
}

class Activity implements Comparable<Activity> {
    private final int start;
    private final int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.start, other.start);
    }
}

class Person {
    private final String name;
    private Activity currentActivity;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable(Activity activity) {
        return currentActivity == null || currentActivity.getEnd() <= activity.getStart();
    }

    public void assignActivity(Activity activity) {
        currentActivity = activity;
    }
}