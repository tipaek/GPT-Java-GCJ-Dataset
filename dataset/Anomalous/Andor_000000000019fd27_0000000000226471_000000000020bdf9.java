import java.io.*;
import java.util.*;

public class Solution {
    static int t, n;
    static Activity[] activities;
    static int[] cSchedule, jSchedule;
    static String[] result;
    static boolean isImpossible;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        t = input.nextInt();
        for (int a = 1; a <= t; a++) {
            n = input.nextInt();
            activities = new Activity[n];
            result = new String[n];
            isImpossible = false;

            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(i, input.nextInt(), input.nextInt());
            }

            Arrays.sort(activities);

            System.out.print("Case #" + a + ": ");
            cSchedule = new int[1440];
            jSchedule = new int[1440];

            for (int i = 0; i < n; i++) {
                if (assignToC(activities[i].start, activities[i].end)) {
                    result[activities[i].index] = "C";
                } else if (assignToJ(activities[i].start, activities[i].end)) {
                    result[activities[i].index] = "J";
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.print("IMPOSSIBLE");
            } else {
                for (String res : result) {
                    System.out.print(res);
                }
            }
            System.out.println();
        }
    }

    static boolean assignToC(int start, int end) {
        for (int i = start; i < end; i++) {
            cSchedule[i]++;
            if (cSchedule[i] > 1) {
                for (int j = i; j >= start; j--) {
                    cSchedule[j]--;
                }
                return false;
            }
        }
        return true;
    }

    static boolean assignToJ(int start, int end) {
        for (int i = start; i < end; i++) {
            jSchedule[i]++;
            if (jSchedule[i] > 1) {
                for (int j = i; j >= start; j--) {
                    jSchedule[j]--;
                }
                return false;
            }
        }
        return true;
    }
}

class Activity implements Comparable<Activity> {
    int index, start, end;

    public Activity(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.start, other.start);
    }
}