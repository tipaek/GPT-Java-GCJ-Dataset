import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCaseCount; t++) {
            int n = Integer.parseInt(br.readLine());
            Activity[] activities = new Activity[n];

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                activities[i] = new Activity(start, end, i);
            }

            char[] schedule = new char[n];
            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            int endJ = 0, endC = 0;
            boolean possible = true;

            for (Activity activity : activities) {
                if (activity.start >= endJ) {
                    endJ = activity.end;
                    schedule[activity.index] = 'J';
                } else if (activity.start >= endC) {
                    endC = activity.end;
                    schedule[activity.index] = 'C';
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + new String(schedule));
            }
        }
    }

    static class Activity {
        int start, end, index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}