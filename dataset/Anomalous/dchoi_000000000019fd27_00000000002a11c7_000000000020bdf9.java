import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();

            int[] startTimes = new int[N];
            int[] endTimes = new int[N];

            for (int i = 0; i < N; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
            }

            if (isPossibleSchedule(startTimes, endTimes, N)) {
                String result = findSchedule(startTimes, endTimes, N);
                System.out.printf("Case #%d: %s%n", testCase, result);
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", testCase);
            }
        }
    }

    private static boolean isPossibleSchedule(int[] startTimes, int[] endTimes, int N) {
        int[] check = new int[1441];
        for (int i = 0; i < N; i++) {
            for (int t = startTimes[i]; t < endTimes[i]; t++) {
                if (++check[t] > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String findSchedule(int[] startTimes, int[] endTimes, int N) {
        int[] cameron = new int[1441];
        int[] jamie = new int[1441];
        return assignTasks(cameron, jamie, startTimes, endTimes, 0, N, new StringBuilder());
    }

    private static String assignTasks(int[] cameron, int[] jamie, int[] startTimes, int[] endTimes, int index, int N, StringBuilder result) {
        if (index == N) {
            return result.toString();
        }

        int startTime = startTimes[index];
        int endTime = endTimes[index];

        if (isAvailable(cameron, startTime, endTime)) {
            fill(cameron, startTime, endTime);
            result.append('C');
            String res = assignTasks(cameron, jamie, startTimes, endTimes, index + 1, N, result);
            if (!res.equals("IMPOSSIBLE")) return res;
            result.deleteCharAt(result.length() - 1);
            unfill(cameron, startTime, endTime);
        }
        
        if (isAvailable(jamie, startTime, endTime)) {
            fill(jamie, startTime, endTime);
            result.append('J');
            String res = assignTasks(cameron, jamie, startTimes, endTimes, index + 1, N, result);
            if (!res.equals("IMPOSSIBLE")) return res;
            result.deleteCharAt(result.length() - 1);
            unfill(jamie, startTime, endTime);
        }

        return "IMPOSSIBLE";
    }

    private static boolean isAvailable(int[] arr, int s, int e) {
        for (int i = s; i < e; i++) {
            if (arr[i] > 0) return false;
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