import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int[] cameronSchedule = new int[1441];
            int[] jamieSchedule = new int[1441];
            int numActivities = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int a = 0; a < numActivities; a++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assignedToCameron = tryAssignActivity(cameronSchedule, start, end);

                if (assignedToCameron) {
                    result.append("C");
                } else {
                    boolean assignedToJamie = tryAssignActivity(jamieSchedule, start, end);
                    if (assignedToJamie) {
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static boolean tryAssignActivity(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] != 0) {
                return false;
            }
        }
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
        return true;
    }
}