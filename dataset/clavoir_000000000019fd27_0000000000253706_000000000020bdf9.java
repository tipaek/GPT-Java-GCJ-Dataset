
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static String compute(int[][] activities) {
        List<int[]> jSchedules = new ArrayList<>();
        List<int[]> cSchedules = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i < activities.length; i++ ){

            if (!isBusySchedule(jSchedules, activities[i])) {
                sb.append("J");
                jSchedules.add(activities[i]);
            } else {
                if (!isBusySchedule(cSchedules, activities[i])) {
                    sb.append("C");
                    cSchedules.add(activities[i]);
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return sb.toString();
    }

    private static boolean isBusySchedule(List<int[]> jSchedules, int[] activity) {
        for (int[] schedule : jSchedules) {
            if ((schedule[0] < activity[0] && activity[0] < schedule[1]) || (schedule[0] < activity[1] && activity[1] < schedule[1])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[][] schedules = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] schedule = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                schedules[i][0] = Integer.parseInt(schedule[0]);
                schedules[i][1] =  Integer.parseInt(schedule[1]);
            }
            String result = compute(schedules);
            System.out.printf("Case #%s: %s", testCase+1, result);
            System.out.println("");
        }

        scanner.close();
    }
}
