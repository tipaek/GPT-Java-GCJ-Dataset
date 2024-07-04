import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            StringBuilder schedule = new StringBuilder();

            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }

            // Sort intervals by start times
            for (int l = 0; l < n; l++) {
                int minIndex = l;
                for (int m = l + 1; m < n; m++) {
                    if (startTimes[m] < startTimes[minIndex]) {
                        minIndex = m;
                    }
                }
                // Swap start times
                int temp = startTimes[l];
                startTimes[l] = startTimes[minIndex];
                startTimes[minIndex] = temp;
                // Swap end times
                temp = endTimes[l];
                endTimes[l] = endTimes[minIndex];
                endTimes[minIndex] = temp;
            }

            int cEnd = 0, jEnd = 0;
            boolean cFree = true, jFree = true;
            boolean impossible = false;

            for (int current = 0; current <= 1440; current++) {
                if (cEnd == current) cFree = true;
                if (jEnd == current) jFree = true;

                for (int i = 0; i < n; i++) {
                    if (startTimes[i] == current) {
                        if (cFree) {
                            cFree = false;
                            cEnd = endTimes[i];
                            schedule.append('C');
                        } else if (jFree) {
                            jFree = false;
                            jEnd = endTimes[i];
                            schedule.append('J');
                        } else {
                            System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                            impossible = true;
                            break;
                        }
                    }
                }
                if (impossible) break;
            }

            if (!impossible) {
                System.out.println("Case #" + (t + 1) + ": " + schedule.toString());
            }
        }

        scanner.close();
    }
}