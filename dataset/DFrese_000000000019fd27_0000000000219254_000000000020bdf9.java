import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfTestcases = Integer.parseInt(in.nextLine());

        for(int i = 1; i <= numberOfTestcases; i++) {
            findSolution(i, in);
        }
    }

    private static void findSolution(int index, Scanner in) {
        int activityCount = Integer.parseInt(in.nextLine());
        List<Activity> activities = new ArrayList<Activity>();

        for(int i = 0; i < activityCount; i++) {
            activities.add(new Activity(in.nextLine().split(" "), i));
        }

        Collections.sort(activities);

        try {
            computeSchedule(index, activities);
            printSchedule(index, activities);
        } catch (Exception e) {
            System.out.println(String.format("Case #%s: %s", index, "IMPOSSIBLE"));
        }

    }

    private static void printSchedule(int index, List<Activity> scheduledActivities) {
        String schedule = "";

        for(Activity activity : scheduledActivities) {
            schedule += activity.person;
        }

        System.out.println(String.format("Case #%s: %s", index, schedule));
    }

    private static void computeSchedule(int index, List<Activity> activities) {
        Person cameron = new Person("C");
        Person jamie = new Person("J");

        for(Activity nextActivity : activities) {
            clearActivityIfPossible(cameron, nextActivity);
            clearActivityIfPossible(jamie, nextActivity);

            if(jamie.activity == null) {
                jamie.activity = nextActivity;
                jamie.activity.person = jamie.name;
            } else if(cameron.activity == null) {
                cameron.activity = nextActivity;
                cameron.activity.person = cameron.name;
            } else {
                throw new RuntimeException();
            }
        }

        Collections.sort(activities, new ActivityOrderComparator());
    }

    private static void clearActivityIfPossible(Person person, Activity nextActivity) {
        if(person.activity != null && person.activity.end <= nextActivity.start) {
            person.activity = null;
        }
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;
    int order;
    String person;

    public Activity(String[] startAndEnd, int order) {
        this(Integer.parseInt(startAndEnd[0]), Integer.parseInt(startAndEnd[1]));
        this.order = order;
    }

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Activity other) {
        return this.start < other.start ? -1 : 1;
    }
}

class ActivityOrderComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity first, Activity second) {
        return first.order < second.order ? -1 : 1;
    }
}

class Person {
    String name;
    Activity activity = null;

    public Person(String name) {
        this.name = name;
    }

    public void clearActivity() {
        this.activity = null;
    }
}