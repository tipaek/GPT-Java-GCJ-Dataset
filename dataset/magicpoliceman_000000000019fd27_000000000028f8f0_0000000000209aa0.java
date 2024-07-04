import java.io.*;

public class Solution {

    static public void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().replaceAll("\\s+$", ""));

        for (int i = 0; i < testCases; i++) {
            String[] line = readInput(bufferedReader);
            String[][] solution = solve(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            if (solution[0][0] == null) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                continue;
            }
            System.out.println("Case #" + (i + 1) + ": POSSIBLE");
            for (String[] row : solution) {
                System.out.println(String.join(" ", row));
            }
        }
    }

    static private String[] readInput(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    }

    private static String[][] solve(int matrixSize, int diagonal) {
        if (diagonal % matrixSize == 0) {
            return generateMatrixForConstantDiagonal(matrixSize, diagonal / matrixSize);
        }
        
        int sum = sumDiagonal(matrixSize);
        if (diagonal == sum) {
            return generateMatrixForIncrementalDiagonal(matrixSize);
        }

        return new String[1][1];
    }

    private static String[][] generateMatrixForIncrementalDiagonal(int matrixSize) {
        switch (matrixSize) {
            case 3 : return new String[][]{
                    {"1", "3", "2"},
                    {"3", "2", "1"},
                    {"2", "1", "3"}
            };
            case 4 : return new String[][]{
                    {"1", "3", "4", "2"},
                    {"4", "2", "1", "3"},
                    {"2", "4", "3", "1"},
                    {"3", "1", "2", "4"}
            };
            case 5 : return new String[][]{
                    {"1", "3", "4", "5", "2"},
                    {"5", "2", "1", "3", "4"},
                    {"4", "5", "3", "2", "1"},
                    {"2", "1", "5", "4", "3"},
                    {"3", "4", "2", "1", "5"}
            };
        }
        return new String[1][1];
    }

    private static String[][] generateMatrixForConstantDiagonal(int size, int diagonal) {
        String[][] matrix = new String[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = getValue(row, col, diagonal, size);
            }
        }
        return matrix;
    }

    private static String getValue(int row, int col, int diagonal, int size) {
        int diff = row - col;
        if (diff == 0) {
            return String.valueOf(diagonal);
        }
        if (diff > 0) {
            if (diagonal + diff <= size) {
                return String.valueOf(diagonal + diff);
            }
            int remainder = diff - (size - diagonal);
            return String.valueOf(remainder);
        }
        if (diagonal + diff > 0) {
            return String.valueOf(diagonal + diff);
        }
        return String.valueOf(size + (diagonal + diff));
    }

    private static int sumDiagonal(int matrixSize) {
        int sum = 0;
        for (int i = 1; i <= matrixSize; i++) {
            sum += i;
        }
        return sum;
    }
}