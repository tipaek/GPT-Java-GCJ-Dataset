import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int T = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                scanner.nextLine(); // consume the remaining newline
                String[] data = new String[N];
                for (int j = 0; j < N; j++) {
                    data[j] = scanner.nextLine();
                }
                System.out.println("Case #" + (i + 1) + ": " + processSchedule(N, data));
            }
        }
    }

    private static String processSchedule(int n, String[] tasks) {
        StringBuilder sb = new StringBuilder();
        int[] cTime = new int[1440];
        int[] jTime = new int[1440];
        for (String task : tasks) {
            String[] data = task.split(" ");
            int startTime = Integer.parseInt(data[0]);
            int endTime = Integer.parseInt(data[1]);
            if (allocateTask(cTime, startTime, endTime)) {
                sb.append("C");
            } else if (allocateTask(jTime, startTime, endTime)) {
                sb.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return sb.toString();
    }

    private static boolean allocateTask(int[] timeTable, int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            if (timeTable[i] == 1) {
                for (int j = i - 1; j >= startTime; j--) {
                    timeTable[j] = 0;
                }
                return false;
            }
            timeTable[i] = 1;
        }
        return true;
    }
}