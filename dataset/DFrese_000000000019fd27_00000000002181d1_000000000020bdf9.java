import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
            activities.add(new Activity(in.nextLine().split(" ")));
        }

        Collections.sort(activities);
        printSchedule(index, activities);
    }

    private static void printSchedule(int index, List<Activity> activities) {
        String schedule = "";
        Person cameron = new Person("C");
        Person jamie = new Person("J");

        for(Activity nextActivity : activities) {
            clearActivityIfPossible(cameron, nextActivity);
            clearActivityIfPossible(jamie, nextActivity);

            if(jamie.activity == null) {
                jamie.activity = nextActivity;
                schedule += jamie.name;
            } else if(cameron.activity == null) {
                cameron.activity = nextActivity;
                schedule += cameron.name;
            } else {
                schedule = "IMPOSSIBLE";
                break;
            }
        }

        System.out.println(String.format("Case #%s: %s", index, schedule));
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

    public Activity(String[] startAndEnd) {
        this(Integer.parseInt(startAndEnd[0]), Integer.parseInt(startAndEnd[1]));
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
