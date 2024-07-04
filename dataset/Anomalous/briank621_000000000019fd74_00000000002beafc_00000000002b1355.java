import java.util.*;
import java.io.*;

public class Solution {

    private static int n, m;

    public static long calculateSum(int[][] matrix) {
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                totalSum += matrix[i][j];
            }
        }
        return totalSum;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String[] dimensions = reader.readLine().split(" ");
            n = Integer.parseInt(dimensions[0]);
            m = Integer.parseInt(dimensions[1]);

            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            long totalSum = calculateSum(matrix);
            while (true) {
                boolean hasChanged = false;
                int[][] matrixCopy = new int[n][m];

                for (int i = 0; i < n; i++) {
                    System.arraycopy(matrix[i], 0, matrixCopy[i], 0, m);
                }

                for (int i = 0; i < n; i++) {
                    List<List<Integer>> rowList = new ArrayList<>();
                    for (int j = 0; j < m; j++) {
                        if (matrix[i][j] != 0) {
                            rowList.add(Arrays.asList(matrix[i][j], j));
                        }
                    }

                    for (int j = 1; j < rowList.size() - 1; j++) {
                        if (rowList.get(j).get(0) < rowList.get(j - 1).get(0) && rowList.get(j).get(0) < rowList.get(j + 1).get(0)) {
                            hasChanged = true;
                            matrixCopy[i][rowList.get(j).get(1)] = 0;
                        }
                    }

                    if (rowList.size() > 1) {
                        if (rowList.get(0).get(0) < rowList.get(1).get(0)) {
                            hasChanged = true;
                            matrixCopy[i][rowList.get(0).get(1)] = 0;
                        }
                        if (rowList.get(rowList.size() - 1).get(0) < rowList.get(rowList.size() - 2).get(0)) {
                            hasChanged = true;
                            matrixCopy[i][rowList.get(rowList.size() - 1).get(1)] = 0;
                        }
                    }
                }

                for (int i = 0; i < m; i++) {
                    List<List<Integer>> colList = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        if (matrix[j][i] != 0) {
                            colList.add(Arrays.asList(matrix[j][i], j));
                        }
                    }

                    for (int j = 1; j < colList.size() - 1; j++) {
                        if (colList.get(j).get(0) < colList.get(j - 1).get(0) && colList.get(j).get(0) < colList.get(j + 1).get(0)) {
                            hasChanged = true;
                            matrixCopy[colList.get(j).get(1)][i] = 0;
                        }
                    }

                    if (colList.size() > 1) {
                        if (colList.get(0).get(0) < colList.get(1).get(0)) {
                            hasChanged = true;
                            matrixCopy[colList.get(0).get(1)][i] = 0;
                        }
                        if (colList.get(colList.size() - 1).get(0) < colList.get(colList.size() - 2).get(0)) {
                            hasChanged = true;
                            matrixCopy[colList.get(colList.size() - 1).get(1)][i] = 0;
                        }
                    }
                }

                if (!hasChanged) break;

                totalSum += calculateSum(matrixCopy);
                matrix = matrixCopy;
            }

            System.out.printf("Case #%d: %d\n", caseNum, totalSum);
        }

        reader.close();
    }
}