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

            calculateChores(chores, i + 1);
        }

        scanner.close();
    }

    public static void calculateChores(int[][] chores, int caseNumber) {
        List<int[]> cameron = new ArrayList<>();
        List<int[]> jamie = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (int[] chore : chores) {
            int start = chore[0];
            int end = chore[1];

            if (isAvailable(cameron, start, end)) {
                cameron.add(new int[]{start, end});
                result.append("C");
            } else if (isAvailable(jamie, start, end)) {
                jamie.add(new int[]{start, end});
                result.append("J");
            } else {
                result = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    public static boolean isAvailable(List<int[]> person, int start, int end) {
        for (int[] interval : person) {
            if (Math.min(end, interval[1]) > Math.max(start, interval[0])) {
                return false;
            }
        }
        return true;
    }
}