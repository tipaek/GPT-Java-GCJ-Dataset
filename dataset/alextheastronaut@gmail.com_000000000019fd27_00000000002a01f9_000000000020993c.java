import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int numCases = Integer.parseInt(br.readLine());
        ArrayList<int[][]> matrices = new ArrayList<>();
        for (int i = 0; i < numCases; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                StringTokenizer stRow = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = Integer.parseInt(stRow.nextToken());
                }
            }

            matrices.add(matrix);
        }

        for (int i = 0; i < numCases; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Case #");
            sb.append(i + 1);
            sb.append(": ");
            sb.append(calcTrace(matrices.get(i)));
            sb.append(" ");
            sb.append(calcNumDupRows(matrices.get(i)));
            sb.append(" ");
            sb.append(calcNumDupCols(matrices.get(i)));
            sb.append(" ");
            pw.println(sb.toString());
        }

        pw.flush();
        pw.close();
        br.close();
    }

    public static int calcTrace(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }

    public static int calcNumDupRows(int[][] matrix) {
        int instances = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean[] seen = new boolean[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                if (seen[matrix[i][j] - 1]) {
                    instances++;
                    break;
                }
                seen[matrix[i][j] - 1] = true;
            }
        }

        return instances;
    }

    public static int calcNumDupCols(int[][] matrix) {
        int instances = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean[] seen = new boolean[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                if (seen[matrix[j][i] - 1]) {
                    instances++;
                    break;
                }
                seen[matrix[j][i] - 1] = true;
            }
        }

        return instances;
        // hi
        // hi
        // hi   
    }
}
