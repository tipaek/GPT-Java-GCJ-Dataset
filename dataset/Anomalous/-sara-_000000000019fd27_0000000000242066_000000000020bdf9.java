import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int[] jamieSchedule = new int[1440];
            int[] cameronSchedule = new int[1440];
            int n = scanner.nextInt();
            StringBuilder solution = new StringBuilder();

            boolean isPossible = true;
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isPossible && isAvailable(jamieSchedule, start, end)) {
                    markSchedule(jamieSchedule, start, end);
                    solution.append("J");
                } else if (isPossible && isAvailable(cameronSchedule, start, end)) {
                    markSchedule(cameronSchedule, start, end);
                    solution.append("C");
                } else {
                    isPossible = false;
                    solution = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + t + ": " + solution);
        }

        scanner.close();
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}