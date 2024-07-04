import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(input.nextLine());

        for (int i = 0; i < numCases; i++) {
            int numActivities = Integer.parseInt(input.nextLine());
            PriorityQueue<Activity> activitiesQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.start));
            char[] schedule = new char[numActivities];
            String result = "";

            for (int j = 0; j < numActivities; j++) {
                String[] times = input.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                activitiesQueue.add(new Activity(start, end, j));
            }

            int endC = 0;
            int endJ = 0;
            boolean isPossible = true;

            while (!activitiesQueue.isEmpty()) {
                Activity currentActivity = activitiesQueue.poll();
                if (endC <= currentActivity.start) {
                    endC = currentActivity.end;
                    schedule[currentActivity.index] = 'C';
                } else if (endJ <= currentActivity.start) {
                    endJ = currentActivity.end;
                    schedule[currentActivity.index] = 'J';
                } else {
                    result = "IMPOSSIBLE";
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                result = new String(schedule);
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}

class Activity {
    int start;
    int end;
    int index;

    public Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}