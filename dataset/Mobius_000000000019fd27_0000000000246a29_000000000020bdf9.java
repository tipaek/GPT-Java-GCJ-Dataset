import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    static String solve(Scanner in) {
        int numActivities = in.nextInt();

        boolean[][] matrix = new boolean[numActivities][numActivities];
        byte[] colour = new byte[numActivities];

        List<Activity> activityList = new ArrayList<>(numActivities);

        for (int j = 0; j < numActivities; j++) {
            Activity a = new Activity(in.nextInt(), in.nextInt());

            for (int k = 0; k < activityList.size(); k++) {
                matrix[j][k] = a.overlap(activityList.get(k));
                matrix[k][j] = a.overlap(activityList.get(k));
            }

            activityList.add(a);
        }

        StringBuilder sb = new StringBuilder();

        for (int a = 0; a < numActivities; a++) {
            colour[a] = getColour(matrix, a, numActivities, colour);
            switch (colour[a]) {
                case -1:
                    return "IMPOSSIBLE";

                case 1:
                    sb.append("C");
                    break;

                case 2:
                    sb.append("J");
                    break;
            }
        }

        return sb.toString();
    }

    static byte getColour(boolean[][] matrix, int a, int numActivities, byte[] colour) {
        if (isSafe(matrix, a, numActivities, (byte) 1, colour)) {
            return 1;
        } else if (isSafe(matrix, a, numActivities, (byte) 2, colour)) {
            return 2;
        } else {
            return -1;
        }
    }

    static boolean isSafe(boolean[][] matrix, int a, int numActivities, byte current, byte[] colour) {
        for (int b = 0; b < numActivities; b++) {
            if (matrix[a][b] && colour[b] == current) {
                return false;
            }
        }
        return true;
    }

    static class Activity {
        int s;
        int e;

        Activity(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public boolean overlap(Activity b) {
            return (b.s > s && b.s < e) || (b.e > s && b.e < e) || (s > b.s && s < b.e) || (e > b.s && e < b.e);
        }
    }
}
