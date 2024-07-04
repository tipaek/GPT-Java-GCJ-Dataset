import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine().trim());
            StringBuilder result = new StringBuilder();

            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int row = 0;
            int column = 0;
            int trace = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSeen = new HashSet<>();
                Set<Integer> columnSeen = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    if (i == j) trace += matrix[i][j];
                    rowSeen.add(matrix[i][j]);
                    columnSeen.add(matrix[j][i]);
                }

                if(rowSeen.size() < n) row++;
                if(columnSeen.size() < n) column++;
            }

            result.append("#").append(t).append(": ").append(trace).append(" ").append(row).append(" ").append(column);
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}
