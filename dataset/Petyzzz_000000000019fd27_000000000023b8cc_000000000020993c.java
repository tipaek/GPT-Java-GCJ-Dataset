import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main_google_jam {

    private static Integer caseCounter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer numberOfTests = Integer.valueOf(st.nextToken());

        for (int i = 0; i < numberOfTests; i++) {
            st = new StringTokenizer(br.readLine());
            Integer matrixSize = Integer.parseInt(st.nextToken());

            Integer[][] matrix = new Integer[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                String[] line = br.readLine().trim().split(" ");
                for (int k = 0; k < line.length; k++) {
                    matrix[j][k] = Integer.parseInt(line[k]);
                }
            }

            solve(matrix);
        }
    }

    private static void solve(Integer[][] matrix) {
        caseCounter++;

        int trace = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;

        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];

            Integer[] row = matrix[i];
            Set<Integer> rowSet = Arrays.stream(row).collect(Collectors.toSet());
            if (rowSet.size() < row.length) {
                repeatedRows++;
            }

            Integer[] column = new Integer[matrix.length];

            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }

            Set<Integer> columnSet = Arrays.stream(column).collect(Collectors.toSet());
            if (columnSet.size() < column.length) {
                repeatedColumns++;
            }
        }

        System.out.println(String.format("Case #%s: %s %s %s", caseCounter, trace, repeatedRows, repeatedColumns));
    }
}
