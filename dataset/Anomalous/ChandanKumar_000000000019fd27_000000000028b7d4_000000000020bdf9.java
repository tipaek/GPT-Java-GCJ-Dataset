import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int numActivities = scanner.nextInt();
            List<Activity>[] adjacencyList = createAdjacencyList(numActivities);
            List<Activity> activities = readActivities(scanner, numActivities);

            populateAdjacencyList(adjacencyList, activities);
            results[i] = determineSchedule(adjacencyList, numActivities);
        }

        printResults(results);
    }

    private static List<Activity>[] createAdjacencyList(int size) {
        List<Activity>[] adjacencyList = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        return adjacencyList;
    }

    private static List<Activity> readActivities(Scanner scanner, int numActivities) {
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < numActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(start, end));
        }
        return activities;
    }

    private static void populateAdjacencyList(List<Activity>[] adjacencyList, List<Activity> activities) {
        int size = activities.size();
        for (int i = 0; i < size; i++) {
            Activity activity1 = activities.get(i);
            for (int j = i + 1; j < size; j++) {
                Activity activity2 = activities.get(j);
                if (activity1.isClashing(activity2)) {
                    addEdge(adjacencyList, i, j);
                }
            }
        }
    }

    private static void addEdge(List<Activity>[] adjacencyList, int i, int j) {
        adjacencyList[i].add(new Activity(i, j));
        adjacencyList[j].add(new Activity(j, i));
    }

    private static String determineSchedule(List<Activity>[] adjacencyList, int numActivities) {
        int[] assignments = new int[numActivities];
        Arrays.fill(assignments, -1);
        assignments[0] = 0;

        boolean[] available = new boolean[numActivities];
        Arrays.fill(available, true);

        for (int i = 1; i < numActivities; i++) {
            for (Activity neighbor : adjacencyList[i]) {
                if (assignments[neighbor.getEnd()] != -1) {
                    available[assignments[neighbor.getEnd()]] = false;
                }
            }

            int color;
            for (color = 0; color < numActivities; color++) {
                if (available[color]) break;
            }

            assignments[i] = color;
            Arrays.fill(available, true);
        }

        return buildSchedule(assignments, numActivities);
    }

    private static String buildSchedule(int[] assignments, int numActivities) {
        StringBuilder schedule = new StringBuilder();

        for (int i = 0; i < numActivities; i++) {
            switch (assignments[i]) {
                case 0:
                    schedule.append("C");
                    break;
                case 1:
                    schedule.append("J");
                    break;
                default:
                    return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static void printResults(String[] results) {
        for (int i = 0; i < results.length; i++) {
            System.out.println(String.format("Case #%d: %s", i + 1, results[i]));
        }
    }

    private static class Activity {
        private final int start;
        private final int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getStart() {
            return start;
        }

        int getEnd() {
            return end;
        }

        boolean isClashing(Activity other) {
            return !(this.start >= other.end || this.end <= other.start);
        }
    }
}