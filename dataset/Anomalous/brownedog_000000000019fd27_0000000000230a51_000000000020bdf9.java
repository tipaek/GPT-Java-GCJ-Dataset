import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // number of test cases

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] mat = new int[n][2];

            for (int j = 0; j < n; j++) {
                mat[j][0] = in.nextInt();
                mat[j][1] = in.nextInt();
            }

            String result = scheduleActivities(mat, n);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String scheduleActivities(int[][] mat, int n) {
        StringBuilder answer = new StringBuilder("C"); // C first
        List<Integer> cameron = new ArrayList<>();
        List<Integer> jamie = new ArrayList<>();
        cameron.add(0);

        for (int x = 1; x < n; x++) {
            if (!assignActivity(mat, cameron, jamie, x, answer, 'C')) {
                if (!assignActivity(mat, jamie, cameron, x, answer, 'J')) {
                    return "IMPOSSIBLE";
                }
            }
        }

        return answer.toString();
    }

    private static boolean assignActivity(int[][] mat, List<Integer> primary, List<Integer> secondary, int x, StringBuilder answer, char person) {
        for (int k : primary) {
            if (isOverlapping(mat, mat[x], mat[k])) {
                if (secondary.isEmpty() || canAssignToSecondary(mat, secondary, mat[x])) {
                    answer.append(person == 'C' ? 'J' : 'C');
                    secondary.add(x);
                    return true;
                } else {
                    return false;
                }
            }
        }

        answer.append(person);
        primary.add(x);
        return true;
    }

    private static boolean isOverlapping(int[][] mat, int[] a, int[] b) {
        return (a[0] < b[1] && a[1] > b[0]) || (a[0] <= b[0] && a[1] >= b[1]) || (a[0] >= b[0] && a[1] <= b[1]);
    }

    private static boolean canAssignToSecondary(int[][] mat, List<Integer> secondary, int[] interval) {
        for (int m : secondary) {
            if (isOverlapping(mat, interval, mat[m])) {
                return false;
            }
        }
        return true;
    }
}