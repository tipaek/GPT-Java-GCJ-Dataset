import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int rr = 1; rr <= t; rr++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            int[] sortedStartTimes = startTimes.clone();
            int[] sortedEndTimes = endTimes.clone();

            // Sorting the intervals based on start times
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (sortedStartTimes[j] > sortedStartTimes[j + 1]) {
                        swap(sortedStartTimes, j, j + 1);
                        swap(sortedEndTimes, j, j + 1);
                    }
                }
            }

            int cEndTime = 0;
            int jEndTime = 0;
            boolean isPossible = true;
            HashMap<String, LinkedList<String>> scheduleMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                if (sortedStartTimes[i] >= cEndTime) {
                    addSchedule(scheduleMap, sortedStartTimes[i], sortedEndTimes[i], "C");
                    cEndTime = sortedEndTimes[i];
                } else if (sortedStartTimes[i] >= jEndTime) {
                    addSchedule(scheduleMap, sortedStartTimes[i], sortedEndTimes[i], "J");
                    jEndTime = sortedEndTimes[i];
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + rr + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    LinkedList<String> tasks = scheduleMap.get(startTimes[i] + "" + endTimes[i]);
                    result.append(tasks.removeFirst());
                }
                System.out.println("Case #" + rr + ": " + result);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void addSchedule(HashMap<String, LinkedList<String>> scheduleMap, int start, int end, String person) {
        String key = start + "" + end;
        scheduleMap.computeIfAbsent(key, k -> new LinkedList<>()).add(person);
    }
}