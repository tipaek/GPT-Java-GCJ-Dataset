import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] indices = new int[n];
            char[] result = new char[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                indices[i] = i;
            }

            // Sort indices based on endTimes
            Arrays.sort(indices, Comparator.comparingInt(i -> endTimes[i]));

            int cameronEnd = 0, jamieEnd = 0;
            boolean possible = true;

            for (int i : indices) {
                if (startTimes[i] >= cameronEnd) {
                    result[i] = 'C';
                    cameronEnd = endTimes[i];
                } else if (startTimes[i] >= jamieEnd) {
                    result[i] = 'J';
                    jamieEnd = endTimes[i];
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + test + ": " + new String(result));
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }
}