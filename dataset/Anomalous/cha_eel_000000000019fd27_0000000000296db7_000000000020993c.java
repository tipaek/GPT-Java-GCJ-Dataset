import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int T = sc.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            int n = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] row = sc.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(row[j]);
                }
            }

            int rNum = 0, cNum = 0, tsum = 0;

            // Check each row for duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!set.add(arr[i][j])) {
                        rNum++;
                        break;
                    }
                }
            }

            // Check each column for duplicates
            for (int j = 0; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!set.add(arr[i][j])) {
                        cNum++;
                        break;
                    }
                }
                tsum += arr[j][j];
            }

            out.println("Case #" + tt + ": " + tsum + " " + rNum + " " + cNum);
        }

        out.flush();
        sc.close();
    }
}