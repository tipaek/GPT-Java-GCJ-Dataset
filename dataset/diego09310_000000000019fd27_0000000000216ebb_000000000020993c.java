import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }

            int trace = 0;
            for (int l = 0; l < N; l++) {
                trace += matrix[l][l];
            }

            int rowsRep = 0;
            for (int j = 0; j < N; j++) {
                Set<Integer> vals = new HashSet<>(N);
                for (int k = 0; k < N; k++) {
                    vals.add(matrix[j][k]);
                    if (vals.size() != k+1) {
                        rowsRep++;
                        break;
                    }
                }
            }

            int colsRep = 0;
            for (int j = 0; j < N; j++) {
                Set<Integer> vals = new HashSet<>(N);
                for (int k = 0; k < N; k++) {
                    vals.add(matrix[k][j]);
                    if (vals.size() != k+1) {
                        colsRep++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowsRep + " " + colsRep);

        }

        in.close();
    }
}