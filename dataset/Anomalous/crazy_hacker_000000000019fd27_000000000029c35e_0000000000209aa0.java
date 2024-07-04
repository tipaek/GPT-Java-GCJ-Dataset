import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(System.out)) {
             
            int t = Integer.parseInt(br.readLine());
            StringBuilder result = new StringBuilder();
            
            for (int h = 1; h <= t; h++) {
                result.append("Case #").append(h).append(": ");
                String[] input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0]);
                int k = Integer.parseInt(input[1]);
                
                if (k % n != 0 || k / n > n) {
                    result.append("IMPOSSIBLE\n");
                } else {
                    result.append("POSSIBLE\n");
                    int[][] matrix = new int[n][n];
                    int baseValue = k / n;
                    
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            matrix[i][(i + j) % n] = (baseValue + j - 1) % n + 1;
                        }
                    }
                    
                    for (int[] row : matrix) {
                        for (int j = 0; j < n; j++) {
                            result.append(row[j]);
                            if (j < n - 1) {
                                result.append(" ");
                            }
                        }
                        result.append("\n");
                    }
                }
            }
            
            out.print(result);
        }
    }
}