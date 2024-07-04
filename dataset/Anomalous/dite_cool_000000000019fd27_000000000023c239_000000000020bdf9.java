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

    public static int selectActivities(Solution[] activities, int currentIndex, Map<Integer, Integer> selectedIndices, int totalActivities) {
        int nextIndex = 0;
        if (!activities[currentIndex].visited) {
            selectedIndices.put(activities[currentIndex].index, 0);
            activities[currentIndex].visited = true;
        }
        for (int i = currentIndex + 1; i < totalActivities; i++) {
            if (activities[i].start >= activities[currentIndex].end && !activities[i].visited) {
                selectedIndices.put(activities[i].index, 0);
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

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Solution(start, end, i);
            }

            StringBuilder schedule = new StringBuilder("0".repeat(numActivities));
            Arrays.sort(activities);

            Map<Integer, Integer> cameronActivities = new HashMap<>();
            Map<Integer, Integer> jamieActivities = new HashMap<>();

            int nextIndex = selectActivities(activities, 0, cameronActivities, numActivities);
            if (cameronActivities.size() != numActivities) {
                selectActivities(activities, nextIndex, jamieActivities, numActivities);
            }

            for (Map.Entry<Integer, Integer> entry : cameronActivities.entrySet()) {
                schedule.setCharAt(entry.getKey(), 'C');
            }
            for (Map.Entry<Integer, Integer> entry : jamieActivities.entrySet()) {
                schedule.setCharAt(entry.getKey(), 'J');
            }

            if (schedule.indexOf("0") == -1) {
                results.add(schedule.toString());
            } else {
                results.add("IMPOSSIBLE");
            }
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}