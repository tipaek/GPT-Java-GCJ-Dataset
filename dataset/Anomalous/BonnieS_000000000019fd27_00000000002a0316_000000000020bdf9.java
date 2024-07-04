import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.next());
        
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numActivities = Integer.parseInt(scanner.next());
            boolean[] cSchedule = new boolean[1440];
            boolean[] jSchedule = new boolean[1440];
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (int i = 0; i < numActivities; i++) {
                int start = Integer.parseInt(scanner.next());
                int end = Integer.parseInt(scanner.next());

                if (!possible) {
                    continue;
                }

                if (isAvailable(start, end, cSchedule)) {
                    markBusy(start, end, cSchedule);
                    schedule.append('C');
                } else if (isAvailable(start, end, jSchedule)) {
                    markBusy(start, end, jSchedule);
                    schedule.append('J');
                } else {
                    possible = false;
                    schedule.setLength(0);
                    schedule.append("IMPOSSIBLE");
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + schedule.toString());
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