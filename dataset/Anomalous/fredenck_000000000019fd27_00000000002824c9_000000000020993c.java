import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read matrix and calculate trace and row repeats
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;

                for (int k = 0; k < N; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    matrix[j][k] = num;

                    if (j == k) {
                        trace += num;
                    }

                    if (!rowFlag && !rowSet.add(num)) {
                        rowRepeats++;
                        rowFlag = true;
                    }
                }
            }

            // Calculate column repeats
            for (int a = 0; a < N; a++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int b = 0; b < N; b++) {
                    int num = matrix[b][a];
                    if (!colSet.add(num)) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        br.close();
    }
}