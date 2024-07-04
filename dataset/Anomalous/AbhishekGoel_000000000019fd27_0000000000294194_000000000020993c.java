import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Simple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcaseCount = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testcaseCount; i++) {
            int matrixSize = Integer.parseInt(br.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                String[] elements = br.readLine().split(" ");
                for (int k = 0; k < elements.length; k++) {
                    matrix[j][k] = Integer.parseInt(elements[k]);
                }
            }

            int r = 0, c = 0, k = 0;

            for (int j = 0; j < matrixSize; j++) {
                boolean rowTest = true;
                boolean colTest = true;

                // Check for duplicate values in the row
                for (int jj = 0; jj < matrixSize; jj++) {
                    for (int jjj = jj + 1; jjj < matrixSize; jjj++) {
                        if (matrix[j][jj] == matrix[j][jjj]) {
                            rowTest = false;
                            break;
                        }
                    }
                    if (!rowTest) break;
                }

                // Check for duplicate values in the column
                for (int jj = 0; jj < matrixSize; jj++) {
                    for (int jjj = jj + 1; jjj < matrixSize; jjj++) {
                        if (matrix[jj][j] == matrix[jjj][j]) {
                            colTest = false;
                            break;
                        }
                    }
                    if (!colTest) break;
                }

                if (!rowTest) r++;
                if (!colTest) c++;
                k += matrix[j][j];
            }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}