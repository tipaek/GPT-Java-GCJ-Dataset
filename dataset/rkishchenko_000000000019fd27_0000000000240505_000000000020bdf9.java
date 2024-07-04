import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] activities = new int[n][];
            for (int j = 0; j < n; j++) {
                String activityDefinition = scanner.nextLine();
                int[] activity = IntStream.concat(Arrays.stream(activityDefinition.split(" ")).mapToInt(Integer::parseInt), IntStream.of(j))
                        .toArray();
                activities[j] = activity;
            }
            String solution = solve(activities);
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    private static String solve(final int[][] activities) {
        Arrays.sort(activities, Comparator.comparingInt(activity -> activity[0]));
        int jamie = 0;
        int cameron = 0;

        char[] result = new char[activities.length];
        for (int[] activity : activities) {
            char parent;
            if (cameron <= activity[0]) {
                cameron = activity[1];
                parent = 'C';
            } else if (jamie <= activity[0]) {
                jamie = activity[1];
                parent = 'J';
            } else {
                return "IMPOSSIBLE";
            }
            result[activity[2]] = parent;
        }

        return new String(result);
    }
}
