import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] tasks = new int[n][3];

            for (int i = 0; i < n; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
                tasks[i][2] = i;
            }

            String result = getSchedule(tasks, n);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static void sortTasksByStartTime(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));
    }

    private static String getSchedule(int[][] tasks, int n) {
        int cEnd = 0;
        int jEnd = 0;

        sortTasksByStartTime(tasks);

        StringBuilder schedule = new StringBuilder();
        schedule.append("C");
        cEnd = tasks[0][1];

        for (int i = 1; i < n; i++) {
            if (tasks[i][0] >= cEnd) {
                schedule.append("C");
                cEnd = tasks[i][1];
            } else if (tasks[i][0] >= jEnd) {
                schedule.append("J");
                jEnd = tasks[i][1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        char[] finalSchedule = new char[n];
        for (int i = 0; i < n; i++) {
            finalSchedule[tasks[i][2]] = schedule.charAt(i);
        }

        return new String(finalSchedule);
    }
}