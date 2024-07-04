import java.util.*;
import java.io.*;

class Activity implements Comparable<Activity> {
    int start;
    int end;

    @Override
    public int compareTo(Activity other) {
        return this.start - other.start;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Activity activity = (Activity) obj;
        return start == activity.start && end == activity.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return start + ":" + end;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            Integer[][] tasks = new Integer[n][2];

            for (int i = 0; i < n; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }

            String result = solve(tasks);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    public static String solve(Integer[][] tasks) {
        TreeSet<Activity> J = new TreeSet<>();
        TreeSet<Activity> C = new TreeSet<>();
        return findNextValidAssignment(tasks, "", J, C);
    }

    public static String findNextValidAssignment(Integer[][] tasks, String assignment, TreeSet<Activity> J, TreeSet<Activity> C) {
        if (assignment.length() > tasks.length) {
            return "IMPOSSIBLE";
        }

        char[] assignmentArray = assignment.toCharArray();
        Activity currentActivity = new Activity();
        currentActivity.start = tasks[assignmentArray.length][0];
        currentActivity.end = tasks[assignmentArray.length][1];

        if (canAddActivity(J, currentActivity)) {
            J.add(currentActivity);
            if (assignmentArray.length == tasks.length - 1) {
                return assignment + "J";
            }
            String result = findNextValidAssignment(tasks, assignment + "J", J, C);
            if (!result.equals("IMPOSSIBLE")) {
                return result;
            }
            J.remove(currentActivity);
        }

        if (canAddActivity(C, currentActivity)) {
            C.add(currentActivity);
            if (assignmentArray.length == tasks.length - 1) {
                return assignment + "C";
            }
            String result = findNextValidAssignment(tasks, assignment + "C", J, C);
            if (!result.equals("IMPOSSIBLE")) {
                return result;
            }
            C.remove(currentActivity);
        }

        return "IMPOSSIBLE";
    }

    private static boolean canAddActivity(TreeSet<Activity> activities, Activity newActivity) {
        if (activities.isEmpty()) {
            return true;
        }

        Activity before = activities.lower(newActivity);
        Activity after = activities.higher(newActivity);

        if (before == null) {
            return newActivity.end <= after.start;
        } else if (after == null) {
            return before.end <= newActivity.start;
        } else {
            return before.end <= newActivity.start && newActivity.end <= after.start;
        }
    }
}