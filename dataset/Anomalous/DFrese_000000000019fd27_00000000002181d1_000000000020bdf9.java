import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestcases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfTestcases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int index, Scanner scanner) {
        int activityCount = Integer.parseInt(scanner.nextLine());
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < activityCount; i++) {
            activities.add(new Activity(scanner.nextLine().split(" ")));
        }

        Collections.sort(activities);
        generateSchedule(index, activities);
    }

    private static void generateSchedule(int index, List<Activity> activities) {
        StringBuilder schedule = new StringBuilder();
        Person cameron = new Person("C");
        Person jamie = new Person("J");

        for (Activity activity : activities) {
            cameron.clearIfPossible(activity);
            jamie.clearIfPossible(activity);

            if (jamie.isAvailable()) {
                jamie.assignActivity(activity);
                schedule.append(jamie.getName());
            } else if (cameron.isAvailable()) {
                cameron.assignActivity(activity);
                schedule.append(cameron.getName());
            } else {
                schedule = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        System.out.printf("Case #%d: %s%n", index, schedule.toString());
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;

    public Activity(String[] times) {
        this(Integer.parseInt(times[0]), Integer.parseInt(times[1]));
    }

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
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

    public void assignActivity(Activity activity) {
        this.currentActivity = activity;
    }

    public boolean isAvailable() {
        return currentActivity == null;
    }

    public void clearIfPossible(Activity nextActivity) {
        if (currentActivity != null && currentActivity.end <= nextActivity.start) {
            currentActivity = null;
        }
    }
}