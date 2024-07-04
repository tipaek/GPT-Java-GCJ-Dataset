class TestFile {

    public static void main(String[] args) {
        int numberOfCases = Integer.parseInt(args[0]);
        int argIndex = 1;

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = Integer.parseInt(args[argIndex++]);
            int[][] matrix = new int[matrixSize][matrixSize];

            int diagonalSum = 0;
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(args[argIndex++]);
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }

            int duplicateRows = 0;
            for (int row = 0; row < matrixSize; row++) {
                if (containsDuplicates(matrix[row])) {
                    duplicateRows++;
                }
            }

            int duplicateColumns = 0;
            for (int col = 0; col < matrixSize; col++) {
                int[] columnArray = new int[matrixSize];
                for (int row = 0; row < matrixSize; row++) {
                    columnArray[row] = matrix[row][col];
                }
                if (containsDuplicates(columnArray)) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static boolean containsDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}