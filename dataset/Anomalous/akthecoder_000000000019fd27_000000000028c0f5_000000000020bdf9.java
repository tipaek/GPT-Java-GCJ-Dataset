import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int i = 0; i < testCases; i++) {
                int N = scanner.nextInt();
                int[][] timeSlots = new int[N][2];

                for (int j = 0; j < N; j++) {
                    timeSlots[j][0] = scanner.nextInt();
                    timeSlots[j][1] = scanner.nextInt();
                }

                sortTimeSlots(timeSlots, N);
                String result = determineSchedule(timeSlots, N);
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }

    private static void sortTimeSlots(int[][] timeSlots, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (timeSlots[j][0] > timeSlots[j + 1][0]) {
                    int[] temp = timeSlots[j];
                    timeSlots[j] = timeSlots[j + 1];
                    timeSlots[j + 1] = temp;
                }
            }
        }
    }

    private static String determineSchedule(int[][] timeSlots, int n) {
        StringBuilder schedule = new StringBuilder();
        int endJ = 0, endC = 0;

        for (int i = 0; i < n; i++) {
            int start = timeSlots[i][0], end = timeSlots[i][1];
            if (start >= endJ) {
                endJ = end;
                schedule.append('J');
            } else if (start >= endC) {
                endC = end;
                schedule.append('C');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}