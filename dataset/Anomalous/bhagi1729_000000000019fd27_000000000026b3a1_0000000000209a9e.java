import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int originalTestCases = testCases;

        while (testCases > 0) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] originalIndices = new int[n];

            for (int i = 0; i < n; i++) {
                originalIndices[i] = i;
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
            }

            // Sort intervals by start time using selection sort
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (startTimes[j] < startTimes[minIndex]) {
                        minIndex = j;
                    }
                }
                swap(startTimes, i, minIndex);
                swap(endTimes, i, minIndex);
                swap(originalIndices, i, minIndex);
            }

            int[] duties = new int[2]; // duties[0] for Cameron, duties[1] for Jamie
            Arrays.fill(duties, 0);
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (startTimes[i] >= duties[0]) {
                    duties[0] = endTimes[i];
                    schedule.append('C');
                } else if (startTimes[i] >= duties[1]) {
                    duties[1] = endTimes[i];
                    schedule.append('J');
                } else {
                    possible = false;
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (possible) {
                char[] scheduleArray = schedule.toString().toCharArray();
                // Reorder the schedule to match the original input order
                for (int i = 0; i < n - 1; i++) {
                    int minIndex = i;
                    for (int j = i + 1; j < n; j++) {
                        if (originalIndices[j] < originalIndices[minIndex]) {
                            minIndex = j;
                        }
                    }
                    swap(originalIndices, i, minIndex);
                    swap(scheduleArray, i, minIndex);
                }
                schedule = new StringBuilder(String.valueOf(scheduleArray));
            }

            System.out.println("Case #" + (originalTestCases - testCases + 1) + ": " + schedule);
            testCases--;
        }
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