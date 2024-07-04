import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        short testCases = scanner.nextShort();
        StringBuilder finalResult = new StringBuilder();

        for (int test = 1; test <= testCases; ++test) {
            short taskCount = scanner.nextShort();
            if (taskCount == 0) {
                return;
            }

            StringBuilder caseResult = new StringBuilder();
            HashMap<Short, Short> cameronSchedule = new HashMap<>();
            HashMap<Short, Short> jamieSchedule = new HashMap<>();

            boolean possible = true;

            for (int i = 0; i < taskCount; i++) {
                short start = scanner.nextShort();
                short end = scanner.nextShort();

                if (canSchedule(jamieSchedule, start, end)) {
                    caseResult.append("J");
                } else if (canSchedule(cameronSchedule, start, end)) {
                    caseResult.append("C");
                } else {
                    caseResult.setLength(0);
                    caseResult.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            finalResult.append("Case #").append(test).append(": ").append(caseResult).append("\n");
        }

        System.out.print(finalResult);
    }

    static boolean canSchedule(HashMap<Short, Short> schedule, short start, short end) {
        for (Map.Entry<Short, Short> entry : schedule.entrySet()) {
            if (end > entry.getKey() && start < entry.getValue()) {
                return false;
            }
        }
        schedule.put(start, end);
        return true;
    }
}