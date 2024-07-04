import java.util.Scanner;

class Ques {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        int caseNumber = 1;

        while (testCaseCount > 0) {
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;

            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }

            System.out.print("Case #" + caseNumber + ": " + diagonalSum + " ");

            StringBuilder rowOccurrences = new StringBuilder();
            StringBuilder colOccurrences = new StringBuilder();

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    int value = matrix[i][j];
                    int rowCount = 0;
                    int colCount = 0;

                    for (int k = 0; k < matrixSize; k++) {
                        if (value == matrix[i][k]) rowCount++;
                        if (value == matrix[k][j]) colCount++;
                    }

                    rowOccurrences.append(rowCount);
                    colOccurrences.append(colCount);
                }
            }

            max1 = getMaxOccurrence(rowOccurrences);
            max2 = getMaxOccurrence(colOccurrences);

            System.out.print(max1 + " ");
            System.out.print(max2 + " ");
            System.out.println();

            testCaseCount--;
            caseNumber++;
        }
    }

    private static int getMaxOccurrence(StringBuilder occurrences) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < occurrences.length(); i++) {
            int current = Character.getNumericValue(occurrences.charAt(i)) - 1;
            if (current > max) {
                max = current;
            }
        }
        return max;
    }
}