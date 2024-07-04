import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int T = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                String[] data = new String[N];
                for (int j = 0; j < N; j++) {
                    data[j] = scanner.nextLine();
                }
                System.out.println("Case #" + (i + 1) + ": " + processSchedule(N, data));
            }
        }
    }

    private static String processSchedule(int n, String[] tasks) {
        StringBuilder result = new StringBuilder();
        int[] cTime = new int[1440];
        int[] jTime = new int[1440];

        for (String task : tasks) {
            String[] times = task.split(" ");
            int startTime = Integer.parseInt(times[0]);
            int endTime = Integer.parseInt(times[1]);

            if (allocateTask(jTime, startTime, endTime)) {
                result.append('J');
            } else if (allocateTask(cTime, startTime, endTime)) {
                result.append('C');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private static boolean allocateTask(int[] timeTable, int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            if (timeTable[i] == 1) {
                // Rollback the allocation
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