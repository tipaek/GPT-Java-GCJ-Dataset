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
            solve(time, n, i + 1);
        }
    }

    private static void sortByColumn(int[][] arr, int col) {
        Arrays.sort(arr, (entry1, entry2) -> {
            if (entry1[col] > entry2[col]) {
                return 1;
            } else {
                return -1;
            }
        });
    }

    private static void solve(int[][] time, int n, int t) {
        int cEnd = 0;
        int jEnd = 0;

        sortByColumn(time, 0);

        cEnd = time[0][1];
        StringBuilder s = new StringBuilder("C");

        for (int i = 1; i < n; i++) {
            if (time[i][0] >= cEnd) {
                s.append("C");
                cEnd = time[i][1];
            } else if (time[i][0] >= jEnd) {
                s.append("J");
                jEnd = time[i][1];
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                return;
            }
        }

        System.out.print("Case #" + t + ": ");
        for (int i = 0; i < n; i++) {
            System.out.print(s.charAt(time[i][2]));
        }
        System.out.println();
    }
}