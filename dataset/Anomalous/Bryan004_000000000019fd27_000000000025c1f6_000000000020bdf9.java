import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] times = new int[n][3];
            int[][] originalTimes = new int[n][3];

            for (int j = 0; j < n; j++) {
                times[j][0] = scanner.nextInt();
                times[j][1] = scanner.nextInt();
                times[j][2] = j;
                originalTimes[j][0] = times[j][0];
                originalTimes[j][1] = times[j][1];
                originalTimes[j][2] = j;
            }

            System.out.println("Case #" + t + ": " + solve(times, originalTimes));
        }
    }

    public static String solve(int[][] times, int[][] originalTimes) {
        Arrays.sort(times, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        StringBuilder result = new StringBuilder();
        int[] taskC = null;
        int[] taskJ = null;
        HashMap<Integer, String> assignmentMap = new HashMap<>();

        for (int[] time : times) {
            if (taskC == null) {
                taskC = time;
                assignmentMap.put(time[2], "C");
            } else if (time[0] >= taskC[1]) {
                taskC = time;
                assignmentMap.put(time[2], "C");
            } else if (taskJ == null) {
                taskJ = time;
                assignmentMap.put(time[2], "J");
            } else if (time[0] >= taskJ[1]) {
                taskJ = time;
                assignmentMap.put(time[2], "J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < originalTimes.length; i++) {
            result.append(assignmentMap.get(i));
        }

        return result.toString();
    }
}