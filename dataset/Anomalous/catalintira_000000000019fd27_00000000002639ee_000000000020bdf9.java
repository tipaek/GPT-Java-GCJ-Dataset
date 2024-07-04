import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            System.out.print("Case #" + testCase + ": ");
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < n; ++i) {
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
                    activity.person = "J";
                } else {
                    cam.assign(activity);
                    activity.person = "C";
                }
            }

            activities.stream()
                      .sorted(Comparator.comparingInt(a -> a.id))
                      .forEach(a -> System.out.print(a.person));

            System.out.println();
        }
    }

    private static boolean isImpossible(List<Activity> activities) {
        int[] seconds = new int[60 * 60 * 24];

        for (Activity activity : activities) {
            for (int i = activity.startTime; i < activity.endTime; ++i) {
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
    private boolean[] daySeconds;

    public Person() {
        daySeconds = new boolean[60 * 60 * 24];
    }

    public void assign(Activity activity) {
        for (int i = activity.startTime; i < activity.endTime; ++i) {
            daySeconds[i] = true;
        }
    }

    public boolean canAssign(Activity activity) {
        for (int i = activity.startTime; i < activity.endTime; ++i) {
            if (daySeconds[i]) {
                return false;
            }
        }
        return true;
    }
}

class Activity implements Comparable<Activity> {
    int startTime, endTime, id;
    String person;

    public Activity(int startTime, int endTime, int id) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
        this.person = "";
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.endTime, other.endTime);
    }
}