import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.util.Pair;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int numEvents = sc.nextInt();
            List<int[]> events = new ArrayList<>();
            int[] results = new int[numEvents];
            boolean[] scheduleC = new boolean[1440];
            boolean[] scheduleJ = new boolean[1440];

            for (int i = 0; i < numEvents; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                events.add(new int[]{start, end});
            }

            Pair<List<int[]>, List<Integer>> sortedEvents = sortEvents(events);
            boolean impossible = false;

            for (int i = 0; i < sortedEvents.getKey().size(); i++) {
                int start = sortedEvents.getKey().get(i)[0];
                int end = sortedEvents.getKey().get(i)[1];
                boolean canAssignC = canAssign(scheduleC, start, end);
                boolean canAssignJ = canAssign(scheduleJ, start, end);

                if (canAssignC) {
                    assignSchedule(scheduleC, start, end);
                    results[sortedEvents.getValue().get(i)] = 'C';
                } else if (canAssignJ) {
                    assignSchedule(scheduleJ, start, end);
                    results[sortedEvents.getValue().get(i)] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }

            printResult(caseIndex, impossible, results);
        }
    }

    private static Pair<List<int[]>, List<Integer>> sortEvents(List<int[]> events) {
        List<int[]> sortedEvents = new ArrayList<>();
        List<Integer> originalIndices = new ArrayList<>();
        boolean[] used = new boolean[events.size()];

        while (sortedEvents.size() < events.size()) {
            int minStartTime = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < events.size(); i++) {
                if (!used[i] && events.get(i)[0] < minStartTime) {
                    minStartTime = events.get(i)[0];
                    minIndex = i;
                }
            }

            if (minIndex != -1) {
                sortedEvents.add(events.get(minIndex));
                originalIndices.add(minIndex);
                used[minIndex] = true;
            }
        }

        return new Pair<>(sortedEvents, originalIndices);
    }

    private static boolean canAssign(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void assignSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }

    private static void printResult(int caseIndex, boolean impossible, int[] results) {
        if (impossible) {
            System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
        } else {
            StringBuilder resultString = new StringBuilder();
            for (int result : results) {
                resultString.append((char) result);
            }
            System.out.println("Case #" + (caseIndex + 1) + ": " + resultString);
        }
    }
}