import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] sortedEndTimes = new int[n];
            int[] indices = new int[n];

            for (int i = 0; i < n; i++) {
                indices[i] = i;
            }

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            // Sort startTimes and maintain the original indices
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (startTimes[i] > startTimes[j]) {
                        swap(startTimes, i, j);
                        swap(indices, i, j);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                sortedEndTimes[i] = endTimes[indices[i]];
            }

            boolean isPossible = true;
            int cEnd = sortedEndTimes[0];
            int jEnd = 0;
            StringBuilder schedule = new StringBuilder("C");

            for (int i = 1; i < n; i++) {
                if (startTimes[i] >= cEnd) {
                    cEnd = sortedEndTimes[i];
                    schedule.append("C");
                } else if (startTimes[i] >= jEnd) {
                    jEnd = sortedEndTimes[i];
                    schedule.append("J");
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                char[] result = new char[n];
                char[] scheduleArray = schedule.toString().toCharArray();
                for (int i = 0; i < n; i++) {
                    result[indices[i]] = scheduleArray[i];
                }
                System.out.print("Case #" + t + ": ");
                System.out.println(result);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}