import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            String result = solveCase(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String solveCase(Scanner input) {
        boolean[] cOccupied = new boolean[1441];
        boolean[] jOccupied = new boolean[1441];
        StringBuilder result = new StringBuilder();

        int n = input.nextInt();
        int[][] activities = new int[n][2];

        for (int i = 0; i < n; i++) {
            activities[i][0] = input.nextInt();
            activities[i][1] = input.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int start = activities[i][0];
            int end = activities[i][1];

            if (canAssign(cOccupied, start, end)) {
                result.append("C");
            } else if (canAssign(jOccupied, start, end)) {
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    public static boolean canAssign(boolean[] occupied, int start, int end) {
        for (int i = start; i < end; i++) {
            if (occupied[i]) {
                return false;
            }
        }
        for (int i = start; i < end; i++) {
            occupied[i] = true;
        }
        return true;
    }
}