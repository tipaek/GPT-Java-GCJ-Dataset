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
            String result = new Solution().scheduleActivities(inputs);
            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }

    private String scheduleActivities(String[] inputs) {
        List<int[]> cSchedule = new ArrayList<>();
        List<int[]> jSchedule = new ArrayList<>();
        StringBuilder output = new StringBuilder();

        for (String input : inputs) {
            String[] parts = input.split(" ");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            int[] activity = { start, end };

            if (canSchedule(cSchedule, activity)) {
                cSchedule.add(activity);
                output.append("C");
            } else if (canSchedule(jSchedule, activity)) {
                jSchedule.add(activity);
                output.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return output.toString();
    }

    private boolean canSchedule(List<int[]> schedule, int[] activity) {
        for (int[] existing : schedule) {
            if (conflicts(existing, activity)) {
                return false;
            }
        }
        return true;
    }

    private boolean conflicts(int[] existing, int[] activity) {
        return (activity[0] < existing[1] && activity[1] > existing[0]);
    }
}