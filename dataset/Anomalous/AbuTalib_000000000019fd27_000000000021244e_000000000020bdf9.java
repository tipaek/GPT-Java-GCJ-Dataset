import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numActivities = scanner.nextInt();
            boolean[] cameronSchedule = new boolean[24 * 60];
            boolean[] jamieSchedule = new boolean[24 * 60];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < numActivities; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                boolean isCameronAvailable = true;

                for (int time = startTime; time < endTime; time++) {
                    if (cameronSchedule[time]) {
                        isCameronAvailable = false;
                        break;
                    }
                }

                if (isCameronAvailable) {
                    result.append("C");
                    for (int time = startTime; time < endTime; time++) {
                        cameronSchedule[time] = true;
                    }
                } else {
                    boolean isJamieAvailable = true;
                    for (int time = startTime; time < endTime; time++) {
                        if (jamieSchedule[time]) {
                            isJamieAvailable = false;
                            break;
                        }
                    }

                    if (isJamieAvailable) {
                        result.append("J");
                        for (int time = startTime; time < endTime; time++) {
                            jamieSchedule[time] = true;
                        }
                    } else {
                        result.append("Q");
                    }
                }
            }

            if (result.toString().contains("Q")) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}