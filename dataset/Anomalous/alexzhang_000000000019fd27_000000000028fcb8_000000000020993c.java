import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class GCJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.print("Case #" + caseNum + ": ");

            int diagonalSum = 0;
            for (int i = 0; i < N; i++) {
                diagonalSum += matrix[i][i];
            }
            System.out.print(diagonalSum + " ");

            int duplicateColumns = 0;
            for (int i = 0; i < N; i++) {
                HashSet<Integer> columnSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (!columnSet.add(matrix[j][i])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            int duplicateRows = 0;
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            System.out.println(duplicateRows + " " + duplicateColumns);
        }
    }
}