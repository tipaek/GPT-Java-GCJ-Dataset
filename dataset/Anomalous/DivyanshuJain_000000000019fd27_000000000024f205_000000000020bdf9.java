import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            char[] result = new char[n];
            int[][] activities = new int[n][3];

            for (int i = 0; i < n; i++) {
                activities[i][0] = i;
                activities[i][1] = scanner.nextInt();
                activities[i][2] = scanner.nextInt();
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[1]));

            int cameronEnd = 0, jamieEnd = 0;
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                int index = activities[i][0];
                int start = activities[i][1];
                int end = activities[i][2];

                if (start >= cameronEnd) {
                    cameronEnd = end;
                    result[index] = 'C';
                } else if (start >= jamieEnd) {
                    jamieEnd = end;
                    result[index] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + t + ": " + new String(result));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}