import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            int[] startTimes = new int[N];
            int[] endTimes = new int[N];

            for (int n = 0; n < N; n++) {
                startTimes[n] = sc.nextInt();
                endTimes[n] = sc.nextInt();
            }

            if (isPossibleSchedule(startTimes, endTimes, N)) {
                String result = findSchedule(startTimes, endTimes, N);
                System.out.println("Case #" + test_case + ": " + result);
            } else {
                System.out.println("Case #" + test_case + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isPossibleSchedule(int[] startTimes, int[] endTimes, int N) {
        int[] timeSlots = new int[1440];
        for (int n = 0; n < N; n++) {
            for (int i = startTimes[n]; i < endTimes[n]; i++) {
                timeSlots[i]++;
                if (timeSlots[i] > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String findSchedule(int[] startTimes, int[] endTimes, int N) {
        int[] cameron = new int[1440];
        int[] jamie = new int[1440];
        return assignTasks(cameron, jamie, startTimes, endTimes, 0, N, "");
    }

    private static String assignTasks(int[] cameron, int[] jamie, int[] startTimes, int[] endTimes, int index, int N, String result) {
        if (index == N) {
            return result;
        }

        int startTime = startTimes[index];
        int endTime = endTimes[index];

        if (isAvailable(cameron, startTime, endTime)) {
            fill(cameron, startTime, endTime);
            String res = assignTasks(cameron, jamie, startTimes, endTimes, index + 1, N, result + "C");
            if (!res.equals("IMPOSSIBLE")) {
                return res;
            }
            unfill(cameron, startTime, endTime);
        }

        if (isAvailable(jamie, startTime, endTime)) {
            fill(jamie, startTime, endTime);
            String res = assignTasks(cameron, jamie, startTimes, endTimes, index + 1, N, result + "J");
            if (!res.equals("IMPOSSIBLE")) {
                return res;
            }
            unfill(jamie, startTime, endTime);
        }

        return "IMPOSSIBLE";
    }

    private static boolean isAvailable(int[] arr, int s, int e) {
        for (int i = s; i < e; i++) {
            if (arr[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private static void fill(int[] arr, int s, int e) {
        for (int i = s; i < e; i++) {
            arr[i]++;
        }
    }

    private static void unfill(int[] arr, int s, int e) {
        for (int i = s; i < e; i++) {
            arr[i]--;
        }
    }
}