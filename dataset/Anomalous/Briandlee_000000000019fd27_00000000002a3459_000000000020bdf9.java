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

            String result = findSchedule(N, startingTimes, endingTimes);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String findSchedule(int N, int[] startingTimes, int[] endingTimes) {
        int greatestTime = Arrays.stream(endingTimes).max().orElse(0);

        int[] cameronSchedule = new int[greatestTime + 1];
        int[] jamieSchedule = new int[greatestTime + 1];
        StringBuilder parentsString = new StringBuilder();

        for (int j = 0; j < N; j++) {
            int start = startingTimes[j];
            int end = endingTimes[j];

            if (isAvailable(cameronSchedule, start, end)) {
                markSchedule(cameronSchedule, start, end);
                parentsString.append("C");
            } else if (isAvailable(jamieSchedule, start, end)) {
                markSchedule(jamieSchedule, start, end);
                parentsString.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return parentsString.toString();
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