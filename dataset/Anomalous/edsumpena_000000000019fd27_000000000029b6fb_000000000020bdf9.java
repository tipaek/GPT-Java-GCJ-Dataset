import java.util.*;
import java.io.*;

public class Solution {
    private static List<Integer> completedIndex = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases
        for (int x = 1; x <= t; ++x) {
            int cases = in.nextInt();

            List<String> schedules = new ArrayList<>();

            for (int i = 0; i < cases; i++) {
                schedules.add(String.valueOf(in.nextInt()));
                schedules.add(String.valueOf(in.nextInt()));
            }

            completedIndex.clear();
            System.out.println("Case #" + x + ": " + getPossibleCombo(schedules));
        }
    }

    private static String getPossibleCombo(List<String> schedule) {
        int[] occupiedUntil = new int[]{0, 0};  // [0] = C, [1] = J
        StringBuilder output = new StringBuilder();

        List<String> order = new ArrayList<>(Collections.nCopies(schedule.size(), null));
        List<String> tempAns = new ArrayList<>();

        while (!schedule.isEmpty()) {
            int[][] next = getNextSchedule(schedule);

            if (next[0][0] >= occupiedUntil[0]) {
                occupiedUntil[0] = next[0][1];
                tempAns.add("C");
            } else if (next[0][0] >= occupiedUntil[1]) {
                occupiedUntil[1] = next[0][1];
                tempAns.add("J");
            } else {
                return "IMPOSSIBLE";
            }

            if (completedIndex.size() >= schedule.size() / 2) {
                schedule.clear();
            }
        }

        for (int i = 0; i < completedIndex.size() * 2; i += 2) {
            for (int j = 0; j < completedIndex.size(); j++) {
                if (i == completedIndex.get(j)) {
                    output.append(tempAns.get(j));
                }
            }
        }

        return output.toString();
    }

    private static int[][] getNextSchedule(List<String> schedulesLeft) {
        int earliest = Integer.MAX_VALUE;
        int[][] output = new int[2][2];

        for (int i = 0; i < schedulesLeft.size(); i += 2) {
            int startTime = Integer.parseInt(schedulesLeft.get(i));
            if (startTime < earliest && !completedIndex.contains(i)) {
                output[0][0] = startTime;
                output[0][1] = Integer.parseInt(schedulesLeft.get(i + 1));
                output[1][0] = i;
                output[1][1] = i + 1;
                earliest = startTime;
            }
        }

        completedIndex.add(output[1][0]);
        return output;
    }
}