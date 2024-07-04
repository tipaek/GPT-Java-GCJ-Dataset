import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] times = new int[n][2];
            int[][] originalTimes = new int[n][2];

            for (int j = 0; j < n; j++) {
                times[j][0] = scanner.nextInt();
                times[j][1] = scanner.nextInt();
                originalTimes[j][0] = times[j][0];
                originalTimes[j][1] = times[j][1];
            }

            System.out.println("Case #" + (i + 1) + ": " + assignTasks(times, originalTimes));
        }

        scanner.close();
    }

    public static String assignTasks(int[][] times, int[][] originalTimes) {
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
        StringBuilder result = new StringBuilder();
        HashMap<String, String> taskAssignments = new HashMap<>();
        int[] currentTaskC = null;
        int[] currentTaskJ = null;

        for (int[] time : times) {
            if (currentTaskC == null || time[0] >= currentTaskC[1]) {
                currentTaskC = time;
                taskAssignments.put(time[0] + "-" + time[1], "C");
            } else if (currentTaskJ == null || time[0] >= currentTaskJ[1]) {
                currentTaskJ = time;
                taskAssignments.put(time[0] + "-" + time[1], "J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (int[] origTime : originalTimes) {
            result.append(taskAssignments.get(origTime[0] + "-" + origTime[1]));
        }

        return result.toString();
    }
}