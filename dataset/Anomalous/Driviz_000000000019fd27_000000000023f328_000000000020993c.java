import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();

                for (int j = 0; j < N; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }

                if (rowSet.size() != N) {
                    rowRepeats++;
                }
                if (colSet.size() != N) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + test + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}