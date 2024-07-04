import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        int caseNumber = 1;

        while (testCaseCount-- > 0) {
            int activityCount = sc.nextInt();
            List<Activity> activities = new ArrayList<>();
            char[] schedule = new char[activityCount];

            for (int i = 0; i < activityCount; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                activities.add(new Activity(start, end, i));
            }

            Collections.sort(activities);

            int cameronEnd = 0, jamieEnd = 0;
            boolean isPossible = true;

            for (Activity activity : activities) {
                if (activity.start >= cameronEnd) {
                    cameronEnd = activity.end;
                    schedule[activity.index] = 'C';
                } else if (activity.start >= jamieEnd) {
                    jamieEnd = activity.end;
                    schedule[activity.index] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + caseNumber + ": " + new String(schedule));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }

            caseNumber++;
        }

        sc.close();
    }

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            } else {
                return Integer.compare(this.end, other.end);
            }
        }
    }
}