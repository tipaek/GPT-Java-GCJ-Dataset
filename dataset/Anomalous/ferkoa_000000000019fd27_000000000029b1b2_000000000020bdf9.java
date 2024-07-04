import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static String solve(int[][] activities) {
        Arrays.sort(activities, (a1, a2) -> {
            if (a1[0] != a2[0]) return Integer.compare(a1[0], a2[0]);
            return Integer.compare(a1[1], a2[1]);
        });

        int cEnd = -1;
        int jEnd = -1;
        char[] result = new char[activities.length];

        for (int[] activity : activities) {
            if (activity[0] >= cEnd) {
                result[activity[2]] = 'C';
                cEnd = activity[1];
            } else if (activity[0] >= jEnd) {
                result[activity[2]] = 'J';
                jEnd = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(result);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][3];
            for (int j = 0; j < n; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                activities[j][2] = j;
            }
            out.println("Case #" + i + ": " + solve(activities));
        }
        scanner.close();
    }
}