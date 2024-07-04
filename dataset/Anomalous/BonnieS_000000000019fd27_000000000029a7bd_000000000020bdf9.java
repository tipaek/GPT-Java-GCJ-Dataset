import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.next());
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activities = Integer.parseInt(scanner.next());
            boolean[] cameronSchedule = new boolean[1441];
            boolean[] jamieSchedule = new boolean[1441];
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int i = 0; i < activities; i++) {
                int start = Integer.parseInt(scanner.next());
                int end = Integer.parseInt(scanner.next());

                if (possible) {
                    if (isAvailable(start, end, cameronSchedule)) {
                        markBusy(start, end, cameronSchedule);
                        result.append('C');
                    } else if (isAvailable(start, end, jamieSchedule)) {
                        markBusy(start, end, jamieSchedule);
                        result.append('J');
                    } else {
                        possible = false;
                        result.setLength(0); // Clear the result
                        result.append("IMPOSSIBLE");
                    }
                }
            }
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }

    private static boolean isAvailable(int start, int end, boolean[] schedule) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markBusy(int start, int end, boolean[] schedule) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}