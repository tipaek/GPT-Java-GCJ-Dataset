import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCasesNum = scanner.nextInt();

        for (int i = 1; i <= testCasesNum; i++) {
            int matrixSize = scanner.nextInt();
            List<Integer> matrix = new ArrayList<>();

            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    matrix.add(scanner.nextInt());
                }
            }

            System.out.println("Case #" + i + ": " + calculateTrace(matrix, matrixSize) + " " + rowMaxCount(matrix, matrixSize) + " " + colMaxCount(matrix, matrixSize));
        }
    }

    public static int calculateTrace(List<Integer> matrix, int matrixSize) {
        int trace = 0;
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix.get(i * matrixSize + i);
        }
        return trace;
    }

    public static int rowMaxCount(List<Integer> matrix, int matrixSize) {
        int maxCount = 0;

        for (int i = 0; i < matrixSize; i++) {
            Map<Integer, Integer> rowCount = new HashMap<>();
            for (int j = 0; j < matrixSize; j++) {
                int value = matrix.get(i * matrixSize + j);
                rowCount.put(value, rowCount.getOrDefault(value, 0) + 1);
            }
            maxCount = Math.max(maxCount, Collections.max(rowCount.values()));
        }

        return maxCount == 1 ? 0 : maxCount;
    }

    public static int colMaxCount(List<Integer> matrix, int matrixSize) {
        int maxCount = 0;

        for (int i = 0; i < matrixSize; i++) {
            Map<Integer, Integer> colCount = new HashMap<>();
            for (int j = 0; j < matrixSize; j++) {
                int value = matrix.get(j * matrixSize + i);
                colCount.put(value, colCount.getOrDefault(value, 0) + 1);
            }
            maxCount = Math.max(maxCount, Collections.max(colCount.values()));
        }

        return maxCount == 1 ? 0 : maxCount;
    }
}