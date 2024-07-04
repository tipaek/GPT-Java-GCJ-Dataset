import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] inp = new String[N];
            int[][] a = new int[N][N];
            for (int i = 0; i < N; i++) {
                inp = br.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) {
                    a[i][j] = Integer.parseInt(inp[j]);
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += a[i][i];
            }

            // Calculate for row
            Set<Integer> seen = new HashSet<>();
            int rowCount = 0;
            int columnCount = 0;

            // for row
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (seen.contains(a[i][j])) {
                        rowCount++;
                        break;
                    } else {
                        seen.add(a[i][j]);
                    }
                }
                seen.clear();
            }

            // for column
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (seen.contains(a[j][i])) {
                        columnCount++;
                        break;
                    } else {
                        seen.add(a[j][i]);
                    }
                }
                seen.clear();
            }

            System.out.println("Case #" + (t+1) + ": " + trace + " " + rowCount + " " + columnCount);
        }
    }
}