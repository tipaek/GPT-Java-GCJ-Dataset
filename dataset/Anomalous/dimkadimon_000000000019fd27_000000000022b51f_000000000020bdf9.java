import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];

            for (int j = 0; j < N; j++) {
                String[] times = scanner.nextLine().split(" ");
                startTimes[j] = Integer.parseInt(times[0]);
                endTimes[j] = Integer.parseInt(times[1]);
            }

            String result = findSchedule(startTimes, endTimes);
            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }

    public static String findSchedule(int[] startTimes, int[] endTimes) {
        int N = startTimes.length;
        char[] schedule = new char[N];
        boolean isJFree = true;
        boolean isCFree = true;

        for (int time = 0; time <= 24 * 60; time++) {
            for (int i = 0; i < N; i++) {
                if (time == startTimes[i]) {
                    if (isJFree) {
                        schedule[i] = 'J';
                        isJFree = false;
                    } else if (isCFree) {
                        schedule[i] = 'C';
                        isCFree = false;
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
                if (time == endTimes[i]) {
                    if (schedule[i] == 'J') {
                        isJFree = true;
                    } else if (schedule[i] == 'C') {
                        isCFree = true;
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }

        return new String(schedule);
    }
}