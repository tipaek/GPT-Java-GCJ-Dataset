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
        List<int[]> ca = new ArrayList<>();
        List<int[]> ja = new ArrayList<>();
        StringBuilder res = new StringBuilder();

        for (int[] chore : chores) {
            int start = chore[0];
            int end = chore[1];

            if (checkBusy(ca, start, end) == -1) {
                assignPer(ca, start, end);
                res.append("C");
            } else if (checkBusy(ja, start, end) == -1) {
                assignPer(ja, start, end);
                res.append("J");
            } else {
                res = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + t + ": " + res.toString());
    }

    public static int checkBusy(List<int[]> per, int start, int end) {
        for (int[] entry : per) {
            if (Math.min(end, entry[1]) > Math.max(start, entry[0]) || (start <= entry[0] && end >= entry[1])) {
                return 1;
            }
        }
        return -1;
    }

    public static void assignPer(List<int[]> per, int start, int end) {
        per.add(new int[]{start, end});
    }
}