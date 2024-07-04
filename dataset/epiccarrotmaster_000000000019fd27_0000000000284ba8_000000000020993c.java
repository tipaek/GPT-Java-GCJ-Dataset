import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt();
        for (int k = 1; k <= N; k++) {
            int M = in.nextInt();
            int[][] matrix = new int[M][M];

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            int rowDup = 0, colDup = 0;
            for (int i = 0; i < M; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < M; j++) {
                    int num = matrix[i][j];
                    if (rowSet.contains(num)) {
                        rowDup ++;
                        break;
                    }
                    rowSet.add(num);
                }
            }

            for (int i = 0; i < M; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < M; j++) {
                    int num = matrix[j][i];
                    if (colSet.contains(num)) {
                        colDup ++;
                        break;
                    }
                    colSet.add(num);
                }
            }

            int trace = 0;
            for (int i = 0; i < M; i++) {
                trace += matrix[i][i];
            }

            System.out.println("Case #" + k + ": " + trace + " " + rowDup + " " + colDup);
        }
    }
}