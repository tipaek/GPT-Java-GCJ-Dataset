import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numCases; i++) {
            CaseInputs inputs = readCase(reader);
            CaseOutputs outputs = processMatrix(inputs);
            printOutput(i + 1, outputs);
        }
    }

    private static CaseOutputs processMatrix(CaseInputs inputs) {
        CaseOutputs outputs = new CaseOutputs();
        int trace = 0;

        for (int i = 0; i < inputs.size; i++) {
            trace += inputs.matrix[i][i];
        }
        outputs.trace = trace;

        int rowsWithDup = 0;
        int colsWithDup = 0;

        for (int i = 0; i < inputs.size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();

            for (int j = 0; j < inputs.size; j++) {
                rowSet.add(inputs.matrix[i][j]);
                colSet.add(inputs.matrix[j][i]);
            }

            if (rowSet.size() < inputs.size) {
                rowsWithDup++;
            }
            if (colSet.size() < inputs.size) {
                colsWithDup++;
            }
        }

        outputs.rowsWithDup = rowsWithDup;
        outputs.colsWithDup = colsWithDup;

        return outputs;
    }

    private static CaseInputs readCase(BufferedReader reader) throws IOException {
        int matrixSize = Integer.parseInt(reader.readLine());
        CaseInputs inputs = new CaseInputs();
        inputs.size = matrixSize;
        inputs.matrix = new Integer[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < matrixSize; j++) {
                inputs.matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        return inputs;
    }

    private static void printOutput(int caseNum, CaseOutputs outputs) {
        System.out.printf("Case #%d: %d %d %d%n", caseNum, outputs.trace, outputs.rowsWithDup, outputs.colsWithDup);
    }

    public static class CaseInputs {
        public int size;
        public Integer[][] matrix;
    }

    public static class CaseOutputs {
        public int trace;
        public int rowsWithDup;
        public int colsWithDup;
    }
}