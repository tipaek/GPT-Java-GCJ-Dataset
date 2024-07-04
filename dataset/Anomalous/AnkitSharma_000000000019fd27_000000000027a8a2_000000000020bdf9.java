import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean[] cSchedule = new boolean[1441];
            boolean[] jSchedule = new boolean[1441];
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                boolean cAvailable = true;
                boolean jAvailable = true;

                for (int k = start; k < end; k++) {
                    if (cSchedule[k]) {
                        cAvailable = false;
                        break;
                    }
                }

                if (cAvailable) {
                    for (int k = start; k < end; k++) {
                        cSchedule[k] = true;
                    }
                    result.append("C");
                } else {
                    for (int k = start; k < end; k++) {
                        if (jSchedule[k]) {
                            jAvailable = false;
                            break;
                        }
                    }
                    if (jAvailable) {
                        for (int k = start; k < end; k++) {
                            jSchedule[k] = true;
                        }
                        result.append("J");
                    }
                }

                if (!cAvailable && !jAvailable) {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
        scanner.close();
    }
}