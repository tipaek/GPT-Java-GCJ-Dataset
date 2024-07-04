import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] jActivities = new int[n + 1][2];
            int jCount = 0;
            int[][] cActivities = new int[n + 1][2];
            int cCount = 0;
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (possible) {
                    boolean jAvailable = true;
                    for (int k = 0; k < jCount; k++) {
                        int jStart = jActivities[k][0];
                        int jEnd = jActivities[k][1];
                        if ((jStart <= start && start < jEnd) || (jStart < end && end <= jEnd) || (start <= jStart && jEnd <= end)) {
                            jAvailable = false;
                            break;
                        }
                    }

                    boolean cAvailable = true;
                    for (int k = 0; k < cCount; k++) {
                        int cStart = cActivities[k][0];
                        int cEnd = cActivities[k][1];
                        if ((cStart <= start && start < cEnd) || (cStart < end && end <= cEnd) || (start <= cStart && cEnd <= end)) {
                            cAvailable = false;
                            break;
                        }
                    }

                    if (jAvailable) {
                        jActivities[jCount][0] = start;
                        jActivities[jCount][1] = end;
                        jCount++;
                        result.append("J");
                    } else if (cAvailable) {
                        cActivities[cCount][0] = start;
                        cActivities[cCount][1] = end;
                        cCount++;
                        result.append("C");
                    } else {
                        result.setLength(0);
                        result.append("IMPOSSIBLE");
                        possible = false;
                    }
                }
            }
            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }
        scanner.close();
    }
}