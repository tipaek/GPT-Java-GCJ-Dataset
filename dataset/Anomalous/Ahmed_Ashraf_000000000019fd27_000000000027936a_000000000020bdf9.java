import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int z = 0; z < testCases; z++) {
            int n = scanner.nextInt();
            boolean impossible = false;
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            int maxEndTime = intervals[0][1];
            for (int i = 1; i < n; i++) {
                if (intervals[i][1] > maxEndTime) {
                    maxEndTime = intervals[i][1];
                }
            }

            boolean[] jBusy = new boolean[n];
            boolean[] cBusy = new boolean[n];
            boolean[] jOccupied = new boolean[maxEndTime + 1];
            boolean[] cOccupied = new boolean[maxEndTime + 1];

            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                for (int time = start; time < end; time++) {
                    if (jOccupied[time]) {
                        jBusy[i] = true;
                        break;
                    }
                }

                if (jBusy[i]) {
                    for (int time = start; time < end; time++) {
                        if (cOccupied[time]) {
                            cBusy[i] = true;
                            break;
                        }
                    }

                    if (jBusy[i] && cBusy[i]) {
                        System.out.println("Case #" + (z + 1) + ": IMPOSSIBLE");
                        impossible = true;
                        break;
                    } else {
                        for (int time = start; time < end; time++) {
                            cOccupied[time] = true;
                        }
                    }
                } else {
                    for (int time = start; time < end; time++) {
                        jOccupied[time] = true;
                    }
                }
            }

            if (!impossible) {
                StringBuilder schedule = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (!jBusy[i]) {
                        schedule.append("J");
                    } else {
                        schedule.append("C");
                    }
                }
                System.out.println("Case #" + (z + 1) + ": " + schedule);
            }
        }
        scanner.close();
    }
}