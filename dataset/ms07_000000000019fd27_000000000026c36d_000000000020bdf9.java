import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
    static class Interval implements Comparable<Interval>
    {
        int start;

        int end;

        public int getEnd()
        {
            return end;
        }

        public int compareTo(Interval interval)
        {
            int compareEndTime = interval.getEnd();
            return this.end - compareEndTime;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int testCase = 0;
        int activities = 0;

        testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            activities = sc.nextInt();
            Interval[] schedules = new Interval[activities];

            for (int j = 0; j < activities; j++) {
                Interval interval = new Interval();
                interval.start = sc.nextInt();
                interval.end = sc.nextInt();
                schedules[j] = interval;
            }

            String result = schedule(schedules, activities);
            if (result == null) {
                System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }

    private static String schedule(Interval[] schedules, int activities)
    {
        int cameronPrev = 0;
        int jamiePrev = 0;
        boolean possible = true;
        StringBuilder builder = new StringBuilder();

        Arrays.sort(schedules);

        for (int i = 0; i < schedules.length; i++) {
            Interval interval = schedules[i];
            if (interval.start >= cameronPrev) {
                builder.append("C");
                cameronPrev = interval.end;
            } else if (interval.start >= jamiePrev) {
                builder.append("J");
                jamiePrev = interval.end;
            } else {
                possible = false;
                break;
            }
        }
        if (possible) {
            return builder.toString();
        } else {
            return null;
        }
    }
}
