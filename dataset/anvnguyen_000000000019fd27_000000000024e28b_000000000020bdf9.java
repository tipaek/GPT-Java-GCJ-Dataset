import java.util.*;
import java.io.*;

public class Solution {
    private static class Activity implements Comparable<Activity> {
        Integer index;
        Character person;
        Integer start;
        Integer end;

        public Activity(Integer index, Character person, Integer start, Integer end) {
            this.index = index;
            this.person = person;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity a) {
            if (this.start.equals(a.start)) {
                return this.end.compareTo(a.end);
            }

            return this.start.compareTo(a.start);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            List<Activity> activities = new ArrayList<>();
            for (int s = 0; s < n; s++) {
                int start = in.nextInt();
                int end = in.nextInt();

                Activity a = new Activity(s, null, start, end);
                activities.add(a);
            }

            System.out.println("Case #" + i + ": " + schedule(activities));
        }
    }

    private static String schedule(List<Activity> activities) {
        Collections.sort(activities);

        int cEnd = 0;
        int jEnd = 0;
        boolean canBeScheduled = true;

        for (Activity a : activities) {
            if (a.start >= cEnd) {
                a.person = 'C';
                cEnd = a.end;
                continue;
            }

            if (a.start >= jEnd) {
                a.person = 'J';
                jEnd = a.end;
                continue;
            }

            canBeScheduled = false;
            break;
        }

        if (!canBeScheduled) {
            return "IMPOSSIBLE";
        }

        Character[] schedules = new Character[activities.size()];
        for (Activity a : activities) {
            schedules[a.index] = a.person;
        }

        StringBuilder result = new StringBuilder();
        for (Character c : schedules) {
            result.append(c);
        }

        return result.toString();
    }
}