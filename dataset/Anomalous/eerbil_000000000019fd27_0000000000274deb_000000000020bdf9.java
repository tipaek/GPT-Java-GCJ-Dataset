import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(in.nextLine());
        String[] results = new String[numCases];

        for (int i = 0; i < numCases; i++) {
            int numActivities = in.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            TreeMap<Integer, Integer> sortedActivities = new TreeMap<>();

            for (int j = 0; j < numActivities; j++) {
                startTimes[j] = in.nextInt();
                endTimes[j] = in.nextInt();
                sortedActivities.put(startTimes[j], j);
            }

            int[] p1 = new int[1440];
            int[] p2 = new int[1440];
            StringBuilder result = new StringBuilder();

            for (int j : sortedActivities.values()) {
                int start = startTimes[j];
                int end = endTimes[j];

                if (isAvailable(p1, start, end)) {
                    assignTime(p1, start, end);
                    result.append("C");
                } else if (isAvailable(p2, start, end)) {
                    assignTime(p2, start, end);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (!result.toString().equals("IMPOSSIBLE")) {
                StringBuilder finalResult = new StringBuilder();
                for (int j = 0; j < numActivities; j++) {
                    finalResult.append(result.charAt(sortedActivities.values().stream().toList().indexOf(j)));
                }
                results[i] = finalResult.toString();
            } else {
                results[i] = "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        in.close();
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private static void assignTime(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i]++;
        }
    }
}