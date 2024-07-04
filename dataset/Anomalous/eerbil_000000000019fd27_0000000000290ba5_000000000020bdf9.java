import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[numCases];

        for (int i = 0; i < numCases; i++) {
            int numActivities = scanner.nextInt();
            int[] schedule = new int[1440];
            String[] tasks = new String[1440];
            String[] assignments = new String[numActivities];
            Arrays.fill(tasks, "");

            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            TreeMap<Integer, Integer> sortedActivities = new TreeMap<>();

            for (int j = 0; j < numActivities; j++) {
                assignments[j] = "";
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
                sortedActivities.put(startTimes[j], j);
            }

            List<Integer> sortedIndices = new ArrayList<>(sortedActivities.values());
            int[] sortedStartTimes = new int[numActivities];
            int[] sortedEndTimes = new int[numActivities];

            for (int j = 0; j < sortedIndices.size(); j++) {
                int index = sortedIndices.get(j);
                sortedStartTimes[j] = startTimes[index];
                sortedEndTimes[j] = endTimes[index];
            }

            String result = "";
            for (int j = 0; j < numActivities; j++) {
                if (!assignTask(schedule, tasks, startTimes[j], endTimes[j], j)) {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                for (int j = 0; j < schedule.length; j++) {
                    if (!tasks[j].isEmpty()) {
                        String[] taskIndices = tasks[j].split("\\s");
                        if (taskIndices.length == 1) {
                            int taskIndex = Integer.parseInt(taskIndices[0]);
                            if (assignments[taskIndex].isEmpty()) {
                                assignments[taskIndex] = "C";
                            }
                        } else if (taskIndices.length == 2) {
                            int firstTask = Integer.parseInt(taskIndices[0]);
                            int secondTask = Integer.parseInt(taskIndices[1]);
                            assignTasks(assignments, firstTask, secondTask);
                        }
                    }
                }
            }

            results[i] = result.equals("IMPOSSIBLE") ? result : String.join("", assignments);
        }

        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }

    private static boolean assignTask(int[] schedule, String[] tasks, int start, int end, int taskIndex) {
        for (int i = start; i < end; i++) {
            schedule[i]++;
            tasks[i] += taskIndex + " ";
            if (schedule[i] > 2) {
                return false;
            }
        }
        return true;
    }

    private static void assignTasks(String[] assignments, int firstTask, int secondTask) {
        if (assignments[firstTask].isEmpty() && assignments[secondTask].isEmpty()) {
            assignments[firstTask] = "C";
            assignments[secondTask] = "J";
        } else if (assignments[firstTask].equals("C") && assignments[secondTask].isEmpty()) {
            assignments[secondTask] = "J";
        } else if (assignments[firstTask].equals("J") && assignments[secondTask].isEmpty()) {
            assignments[secondTask] = "C";
        } else if (assignments[secondTask].equals("C") && assignments[firstTask].isEmpty()) {
            assignments[firstTask] = "J";
        } else if (assignments[secondTask].equals("J") && assignments[firstTask].isEmpty()) {
            assignments[firstTask] = "C";
        }
    }
}