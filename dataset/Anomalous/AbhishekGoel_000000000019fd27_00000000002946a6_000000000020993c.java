import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

class Simple {  
    public static void main(String[] args) {  
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testcaseCount = Integer.parseInt(br.readLine());
            for (int i = 1; i <= testcaseCount; i++) {
                int matrixSize = Integer.parseInt(br.readLine());
                int[][] matrix = new int[matrixSize][matrixSize];
                int trace = 0, rowRepeats = 0, colRepeats = 0;

                for (int j = 0; j < matrixSize; j++) {
                    String[] elements = br.readLine().split(" ");
                    for (int k = 0; k < elements.length; k++) {
                        matrix[j][k] = Integer.parseInt(elements[k]);
                    }
                }

                for (int j = 0; j < matrixSize; j++) {
                    boolean[] rowCheck = new boolean[matrixSize + 1];
                    boolean[] colCheck = new boolean[matrixSize + 1];
                    boolean rowHasDuplicate = false, colHasDuplicate = false;

                    for (int k = 0; k < matrixSize; k++) {
                        if (rowCheck[matrix[j][k]]) {
                            rowHasDuplicate = true;
                        } else {
                            rowCheck[matrix[j][k]] = true;
                        }

                        if (colCheck[matrix[k][j]]) {
                            colHasDuplicate = true;
                        } else {
                            colCheck[matrix[k][j]] = true;
                        }
                    }

                    if (rowHasDuplicate) rowRepeats++;
                    if (colHasDuplicate) colRepeats++;
                    trace += matrix[j][j];
                }

                System.out.printf("Case #%d: %d %d %d%n", i, trace, rowRepeats, colRepeats);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  
}