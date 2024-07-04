import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; ++i) {
            int numActivities = scanner.nextInt();
            Person cameron = new Person();
            Person jamie = new Person();
            StringBuilder schedule = new StringBuilder();

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (cameron.addActivity(start, end)) {
                    schedule.append('C');
                } else if (jamie.addActivity(start, end)) {
                    schedule.append('J');
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + schedule.toString());
        }
    }

    static class Person {
        private final Diary diary;

        Person() {
            this.diary = new Diary();
        }

        boolean addActivity(int start, int end) {
            return diary.add(new Activity(start, end));
        }
    }

    static class Diary {
        private final List<Activity> activities;

        Diary() {
            this.activities = new ArrayList<>();
        }

        boolean add(Activity activity) {
            if (isOccupied(activity)) {
                return false;
            } else {
                activities.add(activity);
                return true;
            }
        }

        private boolean isOccupied(Activity activity) {
            for (Activity assignedActivity : activities) {
                if (!(assignedActivity.end <= activity.start || assignedActivity.start >= activity.end)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Activity {
        final int start;
        final int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}