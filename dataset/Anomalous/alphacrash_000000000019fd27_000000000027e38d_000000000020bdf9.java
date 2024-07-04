import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            int[] originalStart = new int[n];
            int[] originalFinish = new int[n];

            for (int i = 0; i < n; i++) {
                originalStart[i] = sc.nextInt();
                originalFinish[i] = sc.nextInt();
            }

            Activity[] activities = new Activity[n];
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(i, originalStart[i], originalFinish[i]);
            }
            Arrays.sort(activities);

            int[] start = new int[n];
            int[] finish = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = activities[i].s;
                finish[i] = activities[i].f;
            }

            Object[] cameron = getMaxActivities(start, finish, n);
            int remainingCount = n - cameron.length;
            Activity[] remaining = new Activity[remainingCount];

            int j = 0;
            for (int i = 0; i < n; i++) {
                if (!inList(i, cameron)) {
                    remaining[j++] = new Activity(i, start[i], finish[i]);
                }
            }

            int[] remainingStart = new int[remainingCount];
            int[] remainingFinish = new int[remainingCount];
            for (int i = 0; i < remainingCount; i++) {
                remainingStart[i] = remaining[i].s;
                remainingFinish[i] = remaining[i].f;
            }

            Object[] james = getMaxActivities(remainingStart, remainingFinish, remainingCount);
            int possibleActivity = cameron.length + (remainingCount == 0 ? 0 : james.length);

            ReSort[] result = new ReSort[n];
            System.out.print("Case #" + x + ": ");
            if (possibleActivity == n) {
                for (int i = 0; i < n; i++) {
                    if (inList(i, cameron)) {
                        result[i] = new ReSort('C', activities[i]);
                    } else {
                        result[i] = new ReSort('J', activities[i]);
                    }
                }
                System.out.print(getResult(result));
            } else {
                System.out.print("IMPOSSIBLE");
            }
            System.out.println();
        }
        sc.close();
    }

    public static Object[] getMaxActivities(int[] s, int[] f, int n) {
        List<Integer> selected = new ArrayList<>();
        int i = 0;
        selected.add(i);

        for (int j = 1; j < n; j++) {
            if (s[j] >= f[i]) {
                selected.add(j);
                i = j;
            }
        }
        return selected.toArray();
    }

    public static boolean inList(int num, Object[] objects) {
        for (Object o : objects) {
            if (num == (int) o) {
                return true;
            }
        }
        return false;
    }

    public static String getResult(ReSort[] x) {
        Arrays.sort(x);
        StringBuilder result = new StringBuilder();
        for (ReSort reSort : x) {
            result.append(reSort.c);
        }
        return result.toString();
    }
}

class Activity implements Comparable<Activity> {
    int i, s, f;

    public Activity(int i, int s, int f) {
        this.i = i;
        this.s = s;
        this.f = f;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.f, other.f);
    }

    @Override
    public String toString() {
        return "Activity [i=" + i + ", s=" + s + ", f=" + f + "]";
    }
}

class ReSort implements Comparable<ReSort> {
    char c;
    Activity a;

    public ReSort(char c, Activity a) {
        this.c = c;
        this.a = a;
    }

    @Override
    public int compareTo(ReSort other) {
        return Integer.compare(this.a.i, other.a.i);
    }
}