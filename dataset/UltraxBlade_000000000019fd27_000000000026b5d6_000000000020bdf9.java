import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = in.nextInt();
            PriorityQueue<Activity> heap = new PriorityQueue<Activity>(N, new ActivityComparator());
            for (int i = 0; i < N; i++) {
                heap.add(new Activity(in.nextInt(), in.nextInt(), i));
            }
            System.out.println("Case #" + testCase + ": " + makeSchedule(heap, N));
        }
    }
    private static String makeSchedule(PriorityQueue<Activity> heap, int N) {
        int Cend = 0;
        int Jend = 0;
        String[] schedule = new String[N];
        while (!heap.isEmpty()) {
            Activity next = heap.remove();
            if (next.startTime >= Cend) {
                schedule[next.number] = "C";
                Cend = next.endTime;
            } else if (next.startTime >= Jend) {
                schedule[next.number] = "J";
                Jend = next.endTime;
            } else {
                return "IMPOSSIBLE";
            }
        }
        String s = "";
        for (int i = 0; i < N; i++) {
            s += schedule[i];
        }
        return s;
    }
    private static class Activity {
        public int startTime;
        public int endTime;
        public int number;
        public Activity(int start, int end, int n) {
            startTime = start;
            endTime = end;
            number = n;
        }
    }
    private static class ActivityComparator implements Comparator<Activity> {
        public int compare(Activity a, Activity b) {
            return a.startTime - b.startTime;
        }
    }
}
