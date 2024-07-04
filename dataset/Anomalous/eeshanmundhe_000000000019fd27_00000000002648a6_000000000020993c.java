import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= t1; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] arr = new int[n][n];

            for (int j = 0; j < n; j++) {
                String[] input = reader.readLine().split(" ");
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(input[k]);
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Calculate trace
            for (int j = 0; j < n; j++) {
                trace += arr[j][j];
            }

            // Check for row duplicates
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(arr[j][k])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Check for column duplicates
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!colSet.add(arr[k][j])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}