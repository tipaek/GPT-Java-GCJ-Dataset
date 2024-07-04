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

            int[] cameronSchedule = new int[greatestTime + 1];
            int[] jamieSchedule = new int[greatestTime + 1];
            StringBuilder parentsString = new StringBuilder();

            boolean impossible = false;
            for (int j = 0; j < N; j++) {
                if (isFree(cameronSchedule, startingTimes[j], endingTimes[j])) {
                    markSchedule(cameronSchedule, startingTimes[j], endingTimes[j]);
                    parentsString.append("C");
                } else if (isFree(jamieSchedule, startingTimes[j], endingTimes[j])) {
                    markSchedule(jamieSchedule, startingTimes[j], endingTimes[j]);
                    parentsString.append("J");
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + parentsString.toString());
            }
        }
    }

    private static boolean isFree(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] != 0) {
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