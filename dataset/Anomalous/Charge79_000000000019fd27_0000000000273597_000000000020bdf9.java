import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String[] tasks = new String[n];

            for (int i = 0; i < n; i++) {
                tasks[i] = scanner.nextLine();
            }

            boolean[] cTime = new boolean[1440];
            boolean[] jTime = new boolean[1440];
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String[] task = tasks[i].split(" ");
                int start = Integer.parseInt(task[0]);
                int end = Integer.parseInt(task[1]);

                boolean cAvailable = isAvailable(cTime, start, end);
                boolean jAvailable = isAvailable(jTime, start, end);

                if (cAvailable) {
                    fillTime(cTime, start, end);
                    output.append('C');
                } else if (jAvailable) {
                    fillTime(jTime, start, end);
                    output.append('J');
                } else {
                    output.setLength(0);
                    output.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + output.toString());
        }

        scanner.close();
    }

    private static boolean isAvailable(boolean[] time, int start, int end) {
        for (int i = start; i < end; i++) {
            if (time[i]) {
                return false;
            }
        }
        return true;
    }

    private static void fillTime(boolean[] time, int start, int end) {
        for (int i = start; i < end; i++) {
            time[i] = true;
        }
    }
}