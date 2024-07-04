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

            if (assignTasks(N, startingTimes, endingTimes)) {
                System.out.println("Case #" + (i + 1) + ": " + assignTasks(N, startingTimes, endingTimes));
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static String assignTasks(int N, int[] startingTimes, int[] endingTimes) {
        int[] cameronSchedule = new int[1440];
        int[] jamieSchedule = new int[1440];
        char[] result = new char[N];

        for (int i = 0; i < N; i++) {
            if (isSchedulable(cameronSchedule, startingTimes[i], endingTimes[i])) {
                Arrays.fill(cameronSchedule, startingTimes[i], endingTimes[i], 1);
                result[i] = 'C';
            } else if (isSchedulable(jamieSchedule, startingTimes[i], endingTimes[i])) {
                Arrays.fill(jamieSchedule, startingTimes[i], endingTimes[i], 1);
                result[i] = 'J';
            } else {
                return null;
            }
        }
        return new String(result);
    }

    private static boolean isSchedulable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] != 0) {
                return false;
            }
        }
        return true;
    }
}