import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            System.out.print("Case #" + testCase + ": ");
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            int[] timeSlots = new int[86400]; // 86400 seconds in a day

            for (int i = 0; i < numActivities; ++i) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));

                for (int j = start; j < end; ++j) {
                    timeSlots[j]++;
                }
            }

            boolean impossible = false;
            for (int i = 0; i < 86400; ++i) {
                if (timeSlots[i] > 2) {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            Collections.sort(activities);

            Person joe = new Person();
            Person cam = new Person();

            for (Activity activity : activities) {
                if (joe.canAssign(activity)) {
                    joe.assign(activity);
                    activity.assignedTo = "J";
                } else {
                    cam.assign(activity);
                    activity.assignedTo = "C";
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < numActivities; ++i) {
                for (Activity activity : activities) {
                    if (activity.id == i) {
                        result.append(activity.assignedTo);
                    }
                }
            }

            System.out.println(result);
        }
    }
}

class Person {
    boolean[] timeSlots;

    public Person() {
        timeSlots = new boolean[86400]; // 86400 seconds in a day
    }

    public void assign(Activity activity) {
        for (int i = activity.startTime; i < activity.endTime; ++i) {
            timeSlots[i] = true;
        }
    }

    public boolean canAssign(Activity activity) {
        for (int i = activity.startTime; i < activity.endTime; ++i) {
            if (timeSlots[i]) {
                return false;
            }
        }
        return true;
    }
}

class Activity implements Comparable<Activity> {
    int startTime, endTime, id;
    String assignedTo;

    public Activity(int startTime, int endTime, int id) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
        this.assignedTo = "";
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.endTime, other.endTime);
    }
}