import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int z = 1; z <= t; z++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            int sum = 0;
            int dr = 0, dc = 0;
            for (int i = 0; i < n; i++) {
                String[] nums = br.readLine().split(" ");
                Set<Integer> duplicates = new HashSet<>(n);
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(nums[j]);
                    if (i == j) {
                        sum += matrix[i][j];
                    }
                    if (duplicates != null) {
                        if (duplicates.contains(matrix[i][j])) {
                            dr++;
                            duplicates = null;
                        } else {
                            duplicates.add(matrix[i][j]);
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                Set<Integer> duplicates = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (duplicates != null) {
                        if (duplicates.contains(matrix[j][i])) {
                            dc++;
                            duplicates = null;
                        } else {
                            duplicates.add(matrix[j][i]);
                        }
                    }
                }
            }
            System.out.println("Case #" + z + ": " + sum + " " + dr + " " + dc);
        }
    }
}
