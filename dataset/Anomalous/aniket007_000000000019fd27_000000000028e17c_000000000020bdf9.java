import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            for (int l = 0; l < n; l++) {
                intervals[l][0] = sc.nextInt();
                intervals[l][1] = sc.nextInt();
            }

            int cCount = 0, jCount = 0;
            int[][] cIntervals = new int[n][2];
            int[][] jIntervals = new int[n][2];
            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;

            outerLoop:
            for (int l = 0; l < n; l++) {
                int start = intervals[l][0];
                int end = intervals[l][1];
                boolean assigned = false;

                if (cCount == 0) {
                    cIntervals[cCount][0] = start;
                    cIntervals[cCount][1] = end;
                    schedule.append("J");
                    cCount++;
                    assigned = true;
                } else {
                    for (int u = 0; u < cCount; u++) {
                        if ((start >= cIntervals[u][0] && start < cIntervals[u][1]) || 
                            (end > cIntervals[u][0] && end <= cIntervals[u][1])) {
                            assigned = false;
                            break;
                        } else {
                            assigned = true;
                        }
                    }
                    if (assigned) {
                        cIntervals[cCount][0] = start;
                        cIntervals[cCount][1] = end;
                        schedule.append("J");
                        cCount++;
                    } else {
                        assigned = false;
                        if (jCount == 0) {
                            jIntervals[jCount][0] = start;
                            jIntervals[jCount][1] = end;
                            schedule.append("C");
                            jCount++;
                            assigned = true;
                        } else {
                            for (int y = 0; y < jCount; y++) {
                                if ((start >= jIntervals[y][0] && start < jIntervals[y][1]) || 
                                    (end > jIntervals[y][0] && end <= jIntervals[y][1])) {
                                    assigned = false;
                                    break;
                                } else {
                                    assigned = true;
                                }
                            }
                            if (assigned) {
                                jIntervals[jCount][0] = start;
                                jIntervals[jCount][1] = end;
                                schedule.append("C");
                                jCount++;
                            } else {
                                impossible = true;
                                System.out.println("Case #" + i + ": IMPOSSIBLE");
                                break outerLoop;
                            }
                        }
                    }
                }
            }

            if (!impossible) {
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }
        sc.close();
    }
}