import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        
        for (int i = 0; i < n; i++) {
            int g = Integer.parseInt(in.readLine());
            ArrayList<Integer> start = new ArrayList<>();
            ArrayList<Integer> end = new ArrayList<>();
            HashMap<Integer, Integer> startTable = new HashMap<>();
            HashMap<Integer, Integer> endTable = new HashMap<>();
            
            for (int j = 0; j < g; j++) {
                String[] s = in.readLine().split(" ");
                int startTime = Integer.parseInt(s[0]);
                int endTime = Integer.parseInt(s[1]);
                start.add(startTime);
                end.add(endTime);
                startTable.put(startTime, j);
                endTable.put(endTime, j);
            }

            String handled = findSchedule(start, end, g, startTable, endTable);
            System.out.println("Case #" + (i + 1) + ": " + handled);
        }
    }

    private static String findSchedule(ArrayList<Integer> start, ArrayList<Integer> end, int length, HashMap<Integer, Integer> startTable, HashMap<Integer, Integer> endTable) {
        String[] output = new String[length];
        ArrayList<Integer> sortedEnd = new ArrayList<>(end);
        Collections.sort(sortedEnd);
        ArrayList<Integer> sortedStart = sortBasedOnEnd(sortedEnd, start, endTable);

        int[] increasing = new int[length];
        int[] parent = new int[length];
        for (int i = 0; i < length; i++) {
            increasing[i] = 1;
            parent[i] = i;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (sortedEnd.get(i) > sortedEnd.get(j) && increasing[i] < increasing[j] + 1 && sortedStart.get(i) >= sortedEnd.get(j)) {
                    increasing[i] = increasing[j] + 1;
                    parent[i] = j;
                }
            }
        }

        ArrayList<Integer> firstSchedule = findLongestIncreasingSubsequence(sortedEnd, increasing, parent, endTable);
        if (!assignTasks(output, firstSchedule, 'J')) {
            return "IMPOSSIBLE";
        }

        ArrayList<Integer> secondSchedule = findLongestIncreasingSubsequence(sortedEnd, increasing, parent, endTable);
        if (!secondSchedule.isEmpty()) {
            return "IMPOSSIBLE";
        }

        assignRemainingTasks(output, 'C');
        return String.join("", output);
    }

    private static ArrayList<Integer> findLongestIncreasingSubsequence(ArrayList<Integer> sortedEnd, int[] increasing, int[] parent, HashMap<Integer, Integer> endTable) {
        int max = 0, index = 0;
        for (int i = 0; i < sortedEnd.size(); i++) {
            if (increasing[i] > max) {
                max = increasing[i];
                index = i;
            }
        }

        ArrayList<Integer> schedule = new ArrayList<>();
        for (int i = max; i > 0; i--) {
            schedule.add(endTable.get(sortedEnd.get(index)));
            index = parent[index];
        }
        return schedule;
    }

    private static boolean assignTasks(String[] output, ArrayList<Integer> schedule, char task) {
        for (int i : schedule) {
            if (output[i] != null) {
                return false;
            }
            output[i] = String.valueOf(task);
        }
        return true;
    }

    private static void assignRemainingTasks(String[] output, char task) {
        for (int i = 0; i < output.length; i++) {
            if (output[i] == null) {
                output[i] = String.valueOf(task);
            }
        }
    }

    private static ArrayList<Integer> sortBasedOnEnd(ArrayList<Integer> sortedEnd, ArrayList<Integer> start, HashMap<Integer, Integer> endTable) {
        ArrayList<Integer> sortedStart = new ArrayList<>();
        for (int end : sortedEnd) {
            sortedStart.add(start.get(endTable.get(end)));
        }
        return sortedStart;
    }
}