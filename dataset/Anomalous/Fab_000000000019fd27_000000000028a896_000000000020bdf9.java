import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numberOfSchedules = scanner.nextInt();
            int[] cameronSchedule = new int[1441]; // 24 * 60 + 1
            int[] jamieSchedule = new int[1441];
            StringBuilder result = new StringBuilder();

            boolean possible = true;

            for (int scheduleIndex = 0; scheduleIndex < numberOfSchedules; scheduleIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isFree(cameronSchedule, start, end)) {
                    fillSchedule(cameronSchedule, start, end);
                    result.append("C");
                } else if (isFree(jamieSchedule, start, end)) {
                    fillSchedule(jamieSchedule, start, end);
                    result.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + result.toString());
            }
        }
    }

    private static boolean isFree(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void fillSchedule(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}