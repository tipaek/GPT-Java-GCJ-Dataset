import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();

        for (int i = 0; i < numOfCases; i++) {
            List<Activity> activities = new ArrayList<>();
            int n = scanner.nextInt();

            for (int j = 0; j < n; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), j));
            }
            Collections.sort(activities);

            System.out.println("Case #" + (i + 1) + ": " + assignTeachers(activities));
        }
    }

    private static String assignTeachers(List<Activity> activities) {
        Activity cActivity = null;
        Activity jActivity = null;

        for (Activity activity : activities) {
            if (cActivity == null || !activity.isOverlap(cActivity)) {
                activity.setTeacher("C");
                cActivity = activity;
            } else if (jActivity == null || !activity.isOverlap(jActivity)) {
                activity.setTeacher("J");
                jActivity = activity;
            } else {
                return "IMPOSSIBLE";
            }
        }

        activities.sort(Comparator.comparingInt(activity -> activity.index));
        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.getTeacher());
        }

        return result.toString();
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;
    int index;
    private String teacher;

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

    public boolean isOverlap(Activity other) {
        return !(this.end <= other.start || other.end <= this.start);
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.end, other.end);
    }
}