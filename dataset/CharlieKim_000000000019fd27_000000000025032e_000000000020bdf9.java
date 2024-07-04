import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();

        for (int i = 0; i < numOfCases; i++) {
            List<Activity> activities = new ArrayList<>();

            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), j));
            }
            Collections.sort(activities);

            System.out.println("Case #" + (i + 1) + ": " + solve(activities));
        }
    }

    private static String solve(List<Activity> activities) {
        Activity cActivity = null;
        Activity jActivity = null;

        for (Activity activity : activities) {
            if (cActivity == null) {
                activity.setTeacher("C");
                cActivity = activity;
            } else {
                if (activity.isOverlap(cActivity)) {
                    if (jActivity == null) {
                        activity.setTeacher("J");
                        jActivity = activity;
                    } else {
                        if (activity.isOverlap(jActivity)) {
                            return "IMPOSSIBLE";
                        } else {
                            activity.setTeacher("J");
                            jActivity = activity;
                        }
                    }
                } else {
                    if (jActivity == null) {
                        activity.setTeacher("C");
                        cActivity = activity;
                    } else {
                        if (activity.isOverlap(jActivity)) {
                            activity.setTeacher("C");
                            cActivity = activity;
                        } else {
                            if (cActivity.end < jActivity.end) {
                                activity.setTeacher("J");
                                jActivity = activity;
                            } else {
                                activity.setTeacher("C");
                                cActivity = activity;
                            }
                        }
                    }
                }
            }
        }

        activities.sort(Comparator.comparingInt(activity -> activity.index));
        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.teacher);
        }

        return result.toString();
    }
}

class Activity implements Comparable<Activity> {

    int start;
    int end;
    int index;
    String teacher = null;

    Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher;
    }

    public boolean isOverlap(Activity activity) {
        return !(end <= activity.start || activity.end <= start);
    }

    @Override
    public int compareTo(Activity activity) {
        return end - activity.end;
    }
}