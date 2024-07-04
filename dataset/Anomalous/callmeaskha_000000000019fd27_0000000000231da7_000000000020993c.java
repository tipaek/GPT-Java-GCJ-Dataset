import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < N; i++) {
                String[] rowArray = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    int value = Integer.parseInt(rowArray[j]);
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                if (rowSet.size() != N) {
                    rowRepeats++;
                }
                if (colSet.size() != N) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}