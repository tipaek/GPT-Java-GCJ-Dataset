import java.util.ArrayList;
import java.util.Scanner;

class Matrix {
    private int[][] matrix;
    private int[] count = new int[2];

    public Matrix(int size) {
        matrix = new int[size][size];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[] getCount() {
        return count;
    }

    public void setCount(int[] count) {
        this.count = count;
    }
}

public class MatrixChecker {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int testCases = in.nextInt();
            Matrix[] matrices = new Matrix[testCases];
            int[] sums = new int[testCases];

            for (int i = 0; i < testCases; i++) {
                int size = in.nextInt();
                matrices[i] = new Matrix(size);
                int diagonalSum = 0;

                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        matrices[i].getMatrix()[row][col] = in.nextInt();
                        if (row == col) {
                            diagonalSum += matrices[i].getMatrix()[row][col];
                        }
                    }
                }
                sums[i] = diagonalSum;
            }

            MatrixChecker checker = new MatrixChecker();
            for (int i = 0; i < testCases; i++) {
                matrices[i].setCount(checker.checkRepeats(matrices[i].getMatrix()));
            }

            for (int i = 0; i < testCases; i++) {
                System.out.printf("Case #%d: %d %d %d%n", i + 1, sums[i], matrices[i].getCount()[0], matrices[i].getCount()[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[] checkRepeats(int[][] matrix) {
        int[] count = new int[2];
        ArrayList<Integer> tempList = new ArrayList<>();

        // Check rows for repeats
        for (int[] row : matrix) {
            tempList.clear();
            for (int value : row) {
                if (tempList.contains(value)) {
                    count[0]++;
                    break;
                }
                tempList.add(value);
            }
        }

        // Check columns for repeats
        for (int col = 0; col < matrix.length; col++) {
            tempList.clear();
            for (int row = 0; row < matrix.length; row++) {
                if (tempList.contains(matrix[row][col])) {
                    count[1]++;
                    break;
                }
                tempList.add(matrix[row][col]);
            }
        }

        return count;
    }
}