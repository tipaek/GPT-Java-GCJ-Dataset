import java.util.*;

public class Solution {

    public static void main(String[] args) {
        calculations();
    }

    public static void calculations() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[] startingTimes = new int[N];
            int[] endingTimes = new int[N];
            for (int j = 0; j < N; j++) {
                startingTimes[j] = scanner.nextInt();
                endingTimes[j] = scanner.nextInt();
            }

            int greatestTime = Arrays.stream(startingTimes).max().orElse(0);
            greatestTime = Math.max(greatestTime, Arrays.stream(endingTimes).max().orElse(0));

            int[] cameronSchedule = new int[greatestTime];
            int[] jamieSchedule = new int[greatestTime];
            StringBuilder parentsString = new StringBuilder();

            boolean impossible = false;

            for (int j = 0; j < N; j++) {
                boolean assigned = false;
                if (isAvailable(cameronSchedule, startingTimes[j], endingTimes[j])) {
                    assignTime(cameronSchedule, startingTimes[j], endingTimes[j]);
                    parentsString.append("C");
                    assigned = true;
                } else if (isAvailable(jamieSchedule, startingTimes[j], endingTimes[j])) {
                    assignTime(jamieSchedule, startingTimes[j], endingTimes[j]);
                    parentsString.append("J");
                    assigned = true;
                }

                if (!assigned) {
                    impossible = true;
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + (impossible ? "IMPOSSIBLE" : parentsString.toString()));
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            if (schedule[k] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void assignTime(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            schedule[k] = 1;
        }
    }
}