import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCaseCount; ++caseNumber) {
            boolean[] cOccupied = new boolean[1441];
            boolean[] jOccupied = new boolean[1441];
            boolean isPossible = true;
            StringBuilder schedule = new StringBuilder("C");

            int activityCount = scanner.nextInt();
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            for (int time = start; time <= end; time++) {
                cOccupied[time] = true;
            }

            for (int activity = 2; activity <= activityCount; activity++) {
                boolean canCameron = true;
                boolean canJamie = true;

                start = scanner.nextInt();
                end = scanner.nextInt();

                if (isPossible) {
                    for (int time = start + 1; time < end; time++) {
                        if (cOccupied[time]) {
                            canCameron = false;
                            break;
                        }
                    }

                    if (canCameron) {
                        for (int time = start; time <= end; time++) {
                            cOccupied[time] = true;
                        }
                        schedule.append("C");
                    } else {
                        for (int time = start + 1; time < end; time++) {
                            if (jOccupied[time]) {
                                canJamie = false;
                                break;
                            }
                        }

                        if (canJamie) {
                            for (int time = start; time <= end; time++) {
                                jOccupied[time] = true;
                            }
                            schedule.append("J");
                        }
                    }

                    if (!canCameron && !canJamie) {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        isPossible = false;
                    }
                }
            }
            System.out.println("Case #" + caseNumber + ": " + schedule);
        }
    }
}