import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(in.nextLine());
        String[] results = new String[numCases];

        for (int i = 0; i < numCases; i++) {
            int numActivities = in.nextInt();
            int[] schedule = new int[1440];
            String[] tasks = new String[1440];
            String[] assignments = new String[numActivities];
            Arrays.fill(tasks, "");

            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            TreeMap<Integer, Integer> sortedActivities = new TreeMap<>();

            for (int j = 0; j < numActivities; j++) {
                assignments[j] = "";
                startTimes[j] = in.nextInt();
                endTimes[j] = in.nextInt();
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
                if (!updateSchedule(schedule, tasks, startTimes[j], endTimes[j], j)) {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!"IMPOSSIBLE".equals(result)) {
                for (int j = 0; j < schedule.length; j++) {
                    if (!tasks[j].isEmpty()) {
                        String[] taskIndices = tasks[j].trim().split("\\s+");
                        if (taskIndices.length == 1) {
                            int next = Integer.parseInt(taskIndices[0]);
                            if (assignments[next].isEmpty()) {
                                assignments[next] = "C";
                            }
                        } else if (taskIndices.length == 2) {
                            int first = Integer.parseInt(taskIndices[0]);
                            int second = Integer.parseInt(taskIndices[1]);
                            if (assignments[first].isEmpty() && assignments[second].isEmpty()) {
                                assignments[first] = "C";
                                assignments[second] = "J";
                            } else if ("C".equals(assignments[first]) && assignments[second].isEmpty()) {
                                assignments[second] = "J";
                            } else if ("J".equals(assignments[first]) && assignments[second].isEmpty()) {
                                assignments[second] = "C";
                            } else if ("C".equals(assignments[second]) && assignments[first].isEmpty()) {
                                assignments[first] = "J";
                            } else if ("J".equals(assignments[second]) && assignments[first].isEmpty()) {
                                assignments[first] = "C";
                            }
                        }
                    }
                }
            }

            String finalResult = "";
            if (!"IMPOSSIBLE".equals(result)) {
                for (String assignment : assignments) {
                    finalResult += assignment;
                }
                results[i] = finalResult;
            } else {
                results[i] = "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        in.close();
    }

    private static boolean updateSchedule(int[] schedule, String[] tasks, int start, int end, int index) {
        for (int i = start; i < end; i++) {
            schedule[i]++;
            tasks[i] += index + " ";
            if (schedule[i] > 2) {
                return false;
            }
        }
        return true;
    }
}