import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int[][] time = new int[n][3];

            for (int j = 0; j < n; j++) {
                time[j][0] = scan.nextInt();
                time[j][1] = scan.nextInt();
                time[j][2] = j;
            }

            String result = solve(time, n);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static void sortbyColumn(int[][] arr, int col) {
        Arrays.sort(arr, (entry1, entry2) -> Integer.compare(entry1[col], entry2[col]));
    }

    private static String solve(int[][] time, int n) {
        int cEnd = 0;
        int jEnd = 0;
        sortbyColumn(time, 0);

        StringBuilder assignments = new StringBuilder("C");
        cEnd = time[0][1];

        for (int i = 1; i < n; i++) {
            if (time[i][0] >= cEnd) {
                assignments.append("C");
                cEnd = time[i][1];
            } else if (time[i][0] >= jEnd) {
                assignments.append("J");
                jEnd = time[i][1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[time[i][2]] = assignments.charAt(i);
        }

        return new String(result);
    }
}