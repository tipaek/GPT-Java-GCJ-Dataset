import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; ++i) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] inputs = new String[n];
            for (int j = 0; j < n; j++) {
                inputs[j] = scanner.nextLine();
            }

            Solution solution = new Solution();
            String result = solution.findSchedule(inputs, false);
            if (result.contains("IMPOSSIBLE")) {
                result = solution.findSchedule(inputs, true);
            }
            if (result.contains("IMPOSSIBLE")) {
                result = "IMPOSSIBLE";
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private String findSchedule(String[] inputs, boolean optimize) {
        List<int[]> cList = new ArrayList<>();
        List<int[]> jList = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        for (String input : inputs) {
            String[] parts = input.split(" ");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            int[] interval = {start, end};

            if (canAddInterval(cList, interval)) {
                cList.add(interval);
                schedule.append("C");
            } else if (optimize && canAddInterval(jList, interval)) {
                jList.add(interval);
                schedule.append("J");
            } else if (canAddInterval(jList, interval)) {
                jList.add(interval);
                schedule.append("J");
            } else {
                schedule.append("IMPOSSIBLE");
                break;
            }
        }

        return schedule.toString();
    }

    private boolean canAddInterval(List<int[]> list, int[] interval) {
        for (int[] existingInterval : list) {
            if (intervalsOverlap(existingInterval, interval)) {
                return false;
            }
        }
        return true;
    }

    private boolean intervalsOverlap(int[] interval1, int[] interval2) {
        return interval1[0] < interval2[1] && interval2[0] < interval1[1];
    }
}