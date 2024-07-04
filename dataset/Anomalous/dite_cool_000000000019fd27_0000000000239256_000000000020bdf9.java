import java.io.*;
import java.util.*;

public class Solution implements Comparable<Solution> {
    int start, end, index;
    boolean visited;

    public Solution(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
        this.visited = false;
    }

    @Override
    public int compareTo(Solution other) {
        if (this.end != other.end) {
            return this.end - other.end;
        }
        return this.start - other.start;
    }

    public static int selectActivities(Solution[] activities, int currentIndex, Map<Integer, Integer> selectedActivities, int totalActivities) {
        int nextIndex = 0;
        selectedActivities.put(activities[currentIndex].index, 0);
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
        Scanner scanner = new Scanner(System.in);
        List<String> results = new ArrayList<>();
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numActivities = scanner.nextInt();
            Solution[] activities = new Solution[numActivities];

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[j] = new Solution(start, end, j);
            }

            String initialSchedule = "0".repeat(numActivities);
            StringBuilder scheduleBuilder = new StringBuilder(initialSchedule);

            Arrays.sort(activities);
            Map<Integer, Integer> cameronActivities = new HashMap<>();
            Map<Integer, Integer> jamieActivities = new HashMap<>();

            int nextIndex = selectActivities(activities, 0, cameronActivities, numActivities);
            selectActivities(activities, nextIndex, jamieActivities, numActivities);

            for (Map.Entry<Integer, Integer> entry : cameronActivities.entrySet()) {
                scheduleBuilder.setCharAt(entry.getKey(), 'J');
            }
            for (Map.Entry<Integer, Integer> entry : jamieActivities.entrySet()) {
                scheduleBuilder.setCharAt(entry.getKey(), 'C');
            }

            if (scheduleBuilder.indexOf("0") == -1) {
                results.add(scheduleBuilder.toString());
            } else {
                results.add("IMPOSSIBLE");
            }
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}