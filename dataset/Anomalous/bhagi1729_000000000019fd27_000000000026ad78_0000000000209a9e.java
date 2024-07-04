import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] originalIndices = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
                originalIndices[i] = i;
            }

            // Sort intervals by start time
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (startTimes[j] < startTimes[i]) {
                        swap(startTimes, i, j);
                        swap(endTimes, i, j);
                        swap(originalIndices, i, j);
                    }
                }
            }

            // Assign tasks
            int[] dutyEndTimes = {0, 0};
            char[] result = new char[n];
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (startTimes[i] >= dutyEndTimes[0]) {
                    dutyEndTimes[0] = endTimes[i];
                    result[originalIndices[i]] = 'C';
                } else if (startTimes[i] >= dutyEndTimes[1]) {
                    dutyEndTimes[1] = endTimes[i];
                    result[originalIndices[i]] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            // Output result
            System.out.println("Case #" + caseNumber++ + ": " + (possible ? new String(result) : "IMPOSSIBLE"));
        }

        sc.close();
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}