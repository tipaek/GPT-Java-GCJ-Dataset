import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            int[] currentTimes = new int[2];
            StringBuilder schedule = new StringBuilder("C");
            currentTimes[1] = intervals[0][1];
            currentTimes[0] = intervals[0][0];
            boolean conflict = false;

            for (int i = 1; i < n; i++) {
                conflict = false;
                for (int j = 0; j < 2; j++) {
                    if (intervals[i][j] < currentTimes[1]) {
                        int result = currentTimes[0] - intervals[i][j];
                        if (result < 0) {
                            if (j == 0) {
                                currentTimes[0] = intervals[i][j];
                                currentTimes[1] = intervals[i][j + 1];
                            } else {
                                currentTimes[0] = intervals[i][j - 1];
                                currentTimes[1] = intervals[i][j];
                            }
                            conflict = true;
                        } else if (result < 0) {
                            if (intervals[i][j] < currentTimes[1]) {
                                result = currentTimes[0] - intervals[i][j];
                                if (result < 0) {
                                    schedule = new StringBuilder("Impossible");
                                    break;
                                }
                            }
                            conflict = true;
                        }
                    } else {
                        conflict = false;
                    }
                }
                if (conflict && !schedule.toString().equals("Impossible")) {
                    schedule.append("J");
                } else if (!conflict && !schedule.toString().equals("Impossible")) {
                    schedule.append("C");
                }
            }
            System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            caseNumber++;
        }
    }
}