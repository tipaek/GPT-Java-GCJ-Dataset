import java.io.*;
import java.util.*;

public class Solution implements Comparable<Solution> {
    int start, end;
    boolean visited;
    int index;

    public Solution(int a, int b, int in) {
        this.start = a;
        this.end = b;
        this.index = in;
        this.visited = false;
    }

    @Override
    public int compareTo(Solution o) {
        if (this.end != o.end) {
            return this.end - o.end;
        }
        return this.start - o.start;
    }

    public static int activitySelection(Solution[] activities, int currentIndex, Map<Integer, Integer> selectedActivities, int totalActivities) {
        int nextIndex = 0;
        if (!activities[currentIndex].visited) {
            selectedActivities.put(activities[currentIndex].index, 0);
            activities[currentIndex].visited = true;
        }
        for (int i = currentIndex + 1; i < totalActivities; i++) {
            if (activities[i].start >= activities[currentIndex].end && !activities[i].visited) {
                selectedActivities.put(activities[i].index, 0);
                currentIndex = i;
                activities[i].visited = true;
            } else if (nextIndex == 0) {
                nextIndex = i;
            }
        }
        return nextIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> results = new ArrayList<>();
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numActivities = sc.nextInt();
            Solution[] activities = new Solution[numActivities];

            for (int i = 0; i < numActivities; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                activities[i] = new Solution(start, end, i);
            }

            StringBuilder schedule = new StringBuilder("0".repeat(numActivities));
            Arrays.sort(activities);

            Map<Integer, Integer> cameronActivities = new HashMap<>();
            Map<Integer, Integer> jamieActivities = new HashMap<>();

            int nextIndex = activitySelection(activities, 0, cameronActivities, numActivities);
            if (cameronActivities.size() != numActivities) {
                activitySelection(activities, nextIndex, jamieActivities, numActivities);
            }

            for (Map.Entry<Integer, Integer> entry : cameronActivities.entrySet()) {
                schedule.setCharAt(entry.getKey(), 'J');
            }

            for (Map.Entry<Integer, Integer> entry : jamieActivities.entrySet()) {
                schedule.setCharAt(entry.getKey(), 'C');
            }

            if (!schedule.toString().contains("0")) {
                results.add(schedule.toString());
            } else {
                results.add("IMPOSSIBLE");
            }
        }

        for (String result : results) {
            System.out.println(result);
        }

        sc.close();
    }
}