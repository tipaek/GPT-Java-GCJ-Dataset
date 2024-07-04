import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine().trim());
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int taskCount = Integer.parseInt(scanner.nextLine().trim());
            StringBuilder schedule = new StringBuilder();
            boolean[] cOccupied = new boolean[1441];
            boolean[] jOccupied = new boolean[1441];
            boolean possible = true;

            for (int j = 0; j < taskCount; j++) {
                String[] task = scanner.nextLine().trim().split(" ");
                int start = Integer.parseInt(task[0]);
                int end = Integer.parseInt(task[1]);

                boolean cAvailable = isAvailable(cOccupied, start, end);
                boolean jAvailable = isAvailable(jOccupied, start, end);

                if (cAvailable) {
                    schedule.append('C');
                    Arrays.fill(cOccupied, start, end, true);
                } else if (jAvailable) {
                    schedule.append('J');
                    Arrays.fill(jOccupied, start, end, true);
                } else {
                    schedule.setLength(0);
                    schedule.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            results[i] = schedule.toString();
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }

    private static boolean isAvailable(boolean[] occupied, int start, int end) {
        for (int i = start; i < end; i++) {
            if (occupied[i]) {
                return false;
            }
        }
        return true;
    }
}