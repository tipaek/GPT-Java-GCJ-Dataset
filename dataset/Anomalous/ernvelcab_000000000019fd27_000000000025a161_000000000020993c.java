import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(bufferedReader.readLine());

            for (int c = 1; c <= numberOfCases; c++) {
                int size = Integer.parseInt(bufferedReader.readLine());
                int[][] matrix = new int[size][size];

                for (int i = 0; i < size; i++) {
                    String[] lineParts = bufferedReader.readLine().split(" ");
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = Integer.parseInt(lineParts[j]);
                    }
                }

                int rows = 0, columns = 0, trace = 0;

                for (int i = 0; i < size; i++) {
                    boolean[] rowCheck = new boolean[size + 1];
                    boolean[] colCheck = new boolean[size + 1];

                    for (int j = 0; j < size; j++) {
                        if (rowCheck[matrix[i][j]]) {
                            rows++;
                            break;
                        }
                        rowCheck[matrix[i][j]] = true;
                    }

                    for (int j = 0; j < size; j++) {
                        if (colCheck[matrix[j][i]]) {
                            columns++;
                            break;
                        }
                        colCheck[matrix[j][i]] = true;
                    }

                    trace += matrix[i][i];
                }

                System.out.println("Case #" + c + ": " + trace + " " + rows + " " + columns);
            }
        }
    }
}