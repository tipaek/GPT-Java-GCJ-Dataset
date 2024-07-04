import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (testCases > 0) {
            int n = Integer.parseInt(reader.readLine());
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] originalStartTimes = new int[n];
            int[] originalEndTimes = new int[n];

            for (int i = 0; i < n; i++) {
                String[] times = reader.readLine().split(" ");
                startTimes[i] = Integer.parseInt(times[0]);
                endTimes[i] = Integer.parseInt(times[1]);
                originalStartTimes[i] = startTimes[i];
                originalEndTimes[i] = endTimes[i];
            }

            // Sort the tasks by their end times
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (endTimes[j] > endTimes[j + 1]) {
                        swap(endTimes, j, j + 1);
                        swap(startTimes, j, j + 1);
                    }
                }
            }

            boolean isImpossible = false;
            int cameronEnd = 0, jamieEnd = 0;

            for (int i = 0; i < n; i++) {
                if (startTimes[i] >= cameronEnd) {
                    cameronEnd = endTimes[i];
                } else if (startTimes[i] >= jamieEnd) {
                    jamieEnd = endTimes[i];
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                StringBuilder schedule = new StringBuilder();
                cameronEnd = 0;
                jamieEnd = 0;
                int cameronStart = 0, jamieStart = 0;

                for (int i = 0; i < n; i++) {
                    if (originalStartTimes[i] >= cameronEnd || originalEndTimes[i] <= cameronStart) {
                        cameronStart = originalStartTimes[i];
                        cameronEnd = originalEndTimes[i];
                        schedule.append("C");
                    } else if (originalStartTimes[i] >= jamieEnd || originalEndTimes[i] <= jamieStart) {
                        jamieStart = originalStartTimes[i];
                        jamieEnd = originalEndTimes[i];
                        schedule.append("J");
                    } else {
                        isImpossible = true;
                        break;
                    }
                }

                if (isImpossible) {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + caseNumber + ": " + schedule.toString());
                }
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }

            caseNumber++;
            testCases--;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}