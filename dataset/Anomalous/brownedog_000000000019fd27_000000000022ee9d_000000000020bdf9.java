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

            String result = assignActivities(mat);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignActivities(int[][] mat) {
        int n = mat.length;
        StringBuilder schedule = new StringBuilder("C");
        List<Integer> camActivities = new ArrayList<>();
        List<Integer> jamActivities = new ArrayList<>();
        camActivities.add(0);

        for (int x = 1; x < n; x++) {
            boolean assigned = false;
            for (int k : camActivities) {
                if (overlaps(mat[x], mat[k])) {
                    if (tryAssignToJam(mat, jamActivities, x)) {
                        schedule.append("J");
                        jamActivities.add(x);
                        assigned = true;
                        break;
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
            if (!assigned) {
                schedule.append("C");
                camActivities.add(x);
            }
        }
        return schedule.toString();
    }

    private static boolean overlaps(int[] activity1, int[] activity2) {
        return (activity1[0] < activity2[1] && activity1[1] > activity2[0]);
    }

    private static boolean tryAssignToJam(int[][] mat, List<Integer> jamActivities, int x) {
        for (int m : jamActivities) {
            if (overlaps(mat[x], mat[m])) {
                return false;
            }
        }
        return true;
    }
}