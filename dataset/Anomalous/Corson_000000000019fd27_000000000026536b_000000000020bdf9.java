import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int activitiesCount = scanner.nextInt();
            StringBuilder output = new StringBuilder();
            int[] cameronSchedule = new int[1440];
            int[] jamieSchedule = new int[1440];
            boolean isImpossible = false;

            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assignedToCameron = true;

                if (!isImpossible) {
                    boolean isCameronBusy = false;
                    for (int j = start; j < end; j++) {
                        if (cameronSchedule[j] != 0) {
                            isCameronBusy = true;
                            break;
                        }
                    }
                    if (!isCameronBusy) {
                        for (int j = start; j < end; j++) {
                            cameronSchedule[j]++;
                        }
                    } else {
                        assignedToCameron = false;
                        boolean isJamieBusy = false;
                        for (int j = start; j < end; j++) {
                            if (jamieSchedule[j] != 0) {
                                isJamieBusy = true;
                                break;
                            }
                        }
                        if (!isJamieBusy) {
                            for (int j = start; j < end; j++) {
                                jamieSchedule[j]++;
                            }
                        } else {
                            isImpossible = true;
                        }
                    }
                }
                output.append(assignedToCameron ? "C" : "J");
            }

            if (isImpossible) {
                output = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + (testCase + 1) + ": " + output);
        }
    }
}