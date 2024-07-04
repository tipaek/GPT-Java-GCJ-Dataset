import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int i = 1; i <= numberOfCases; i++) {
            short[] cameronSchedule = new short[10000];
            short[] jamieSchedule = new short[10000];
            int numberOfActivities = scanner.nextInt();
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < numberOfActivities; j++) {
                short startTime = scanner.nextShort();
                short endTime = scanner.nextShort();
                boolean assignedToCameron = tryAssignActivity(cameronSchedule, startTime, endTime);

                if (assignedToCameron) {
                    result.append('C');
                } else {
                    boolean assignedToJamie = tryAssignActivity(jamieSchedule, startTime, endTime);
                    if (assignedToJamie) {
                        result.append('J');
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static boolean tryAssignActivity(short[] schedule, short start, short end) {
        for (int k = start; k < end; k++) {
            if (schedule[k] == 1) {
                return false;
            }
        }
        for (int k = start; k < end; k++) {
            schedule[k] = 1;
        }
        return true;
    }
}