import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int caseNo = 1; caseNo <= t; caseNo++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            int[] sortedStartTimes = Arrays.copyOf(startTimes, n);
            int[] sortedEndTimes = Arrays.copyOf(endTimes, n);

            // Sort the intervals by start times
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (sortedStartTimes[i] > sortedStartTimes[j]) {
                        swap(sortedStartTimes, i, j);
                        swap(sortedEndTimes, i, j);
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            int[] endTracker = new int[2]; // To track the end times of C and J

            if (sortedEndTimes[0] > sortedStartTimes[1]) {
                result.append("CJ");
                endTracker[0] = sortedEndTimes[0];
                endTracker[1] = sortedEndTimes[1];
            } else {
                result.append("CC");
                endTracker[0] = sortedEndTimes[1];
            }

            for (int i = 2; i < n; i++) {
                if (sortedStartTimes[i] >= endTracker[0]) {
                    endTracker[0] = sortedEndTimes[i];
                    result.append("C");
                } else if (sortedStartTimes[i] >= endTracker[1]) {
                    endTracker[1] = sortedEndTimes[i];
                    result.append("J");
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    break;
                }
            }

            if (!result.toString().equals("IMPOSSIBLE")) {
                StringBuilder output = new StringBuilder();
                boolean[] used = new boolean[n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (!used[j] && startTimes[i] == sortedStartTimes[j]) {
                            used[j] = true;
                            output.append(result.charAt(j));
                            break;
                        }
                    }
                }
                System.out.println("Case #" + caseNo + ": " + output);
            } else {
                System.out.println("Case #" + caseNo + ": " + result);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}