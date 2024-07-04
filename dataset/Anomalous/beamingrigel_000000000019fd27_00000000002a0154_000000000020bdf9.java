import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            int[][] chores = new int[n][2];

            for (int j = 0; j < n; j++) {
                String[] line = scanner.nextLine().trim().split("\\s+");
                chores[j][0] = Integer.parseInt(line[0]);
                chores[j][1] = Integer.parseInt(line[1]);
            }

            calcChores(chores, i + 1);
        }

        scanner.close();
    }

    public static void calcChores(int[][] chores, int t) {
        boolean[] ca = new boolean[24 * 60 + 1];
        boolean[] ja = new boolean[24 * 60 + 1];
        StringBuilder res = new StringBuilder();

        for (int[] chore : chores) {
            int start = chore[0];
            int end = chore[1];

            if (isAvailable(ca, start, end)) {
                assignTime(ca, start, end);
                res.append("C");
            } else if (isAvailable(ja, start, end)) {
                assignTime(ja, start, end);
                res.append("J");
            } else {
                res = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + t + ": " + res.toString());
    }

    public static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    public static void assignTime(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}