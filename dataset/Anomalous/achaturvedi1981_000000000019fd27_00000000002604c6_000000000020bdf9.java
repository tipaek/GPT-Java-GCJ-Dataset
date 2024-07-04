import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int T = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character
                String[] tasks = new String[N];

                for (int j = 0; j < N; j++) {
                    tasks[j] = scanner.nextLine();
                }

                String result = processSchedule(N, tasks);
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }

    private static String processSchedule(int n, String[] tasks) {
        if (n == 2) {
            return "CJ";
        }

        StringBuilder result = new StringBuilder();
        int[] cTime = new int[1440];
        int[] jTime = new int[1440];

        for (String task : tasks) {
            String[] times = task.split(" ");
            int startTime = Integer.parseInt(times[0]);
            int endTime = Integer.parseInt(times[1]);

            if (allocateTask(cTime, startTime, endTime)) {
                result.append('C');
            } else if (allocateTask(jTime, startTime, endTime)) {
                result.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    private static boolean allocateTask(int[] timeTable, int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            if (timeTable[i] == 1) {
                // Reset the timeTable for the current task duration
                for (int j = startTime; j < i; j++) {
                    timeTable[j] = 0;
                }
                return false;
            }
            timeTable[i] = 1;
        }
        return true;
    }
}