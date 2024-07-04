import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int T = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (T-- > 0) {
            int N = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[N][N];
            int rowRepeats = 0;
            int colRepeats = 0;
            int diagonalSum = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                Set<Integer> rowSet = new HashSet<>();
                boolean hasRowRepeat = false;

                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(tokenizer.nextToken());
                    matrix[i][j] = num;

                    if (!hasRowRepeat && !rowSet.add(num)) {
                        rowRepeats++;
                        hasRowRepeat = true;
                    }

                    if (i == j) {
                        diagonalSum += num;
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            writer.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
            caseNumber++;
        }

        reader.close();
        writer.flush();
        writer.close();
    }
}