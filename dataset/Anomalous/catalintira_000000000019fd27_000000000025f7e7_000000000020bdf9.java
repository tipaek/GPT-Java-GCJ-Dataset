import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTests; ++testCase) {
            System.out.print("Case #" + testCase + ": ");
            int numberOfActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < numberOfActivities; ++i) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));
            }

            if (isImpossible(activities)) {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            Collections.sort(activities);

            Person joe = new Person();
            Person cam = new Person();

            for (Activity activity : activities) {
                if (joe.canAssign(activity)) {
                    joe.assign(activity);
                    activity.setPerson("J");
                } else {
                    cam.assign(activity);
                    activity.setPerson("C");
                }
            }

            activities.sort(Comparator.comparingInt(Activity::getId));
            activities.forEach(activity -> System.out.print(activity.getPerson()));
            System.out.println();
        }
    }

    private static boolean isImpossible(List<Activity> activities) {
        int[] seconds = new int[60 * 60];
        for (Activity activity : activities) {
            for (int i = activity.getStartTime(); i < activity.getEndTime(); i++) {
                seconds[i]++;
                if (seconds[i] > 2) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Person {
    private boolean[] schedule;

    public Person() {
        schedule = new boolean[60 * 60];
    }

    public void assign(Activity activity) {
        for (int i = activity.getStartTime(); i < activity.getEndTime(); ++i) {
            schedule[i] = true;
        }
    }

    public boolean canAssign(Activity activity) {
        for (int i = activity.getStartTime(); i < activity.getEndTime(); ++i) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }
}

class Activity implements Comparable<Activity> {
    private int startTime, endTime, id;
    private String person;

    public Activity(int startTime, int endTime, int id) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
        this.person = "";
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getId() {
        return id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.endTime, other.endTime);
    }
}