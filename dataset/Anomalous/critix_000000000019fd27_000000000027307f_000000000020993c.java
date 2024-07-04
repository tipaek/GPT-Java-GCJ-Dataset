import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTests = scanner.nextInt();

        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int matrixSize = scanner.nextInt();
            int rowCount = 0;
            int columnCount = 0;
            int traceSum = 0;

            boolean[][] rowCheck = new boolean[matrixSize][matrixSize];
            boolean[][] columnCheck = new boolean[matrixSize][matrixSize];
            boolean[] rowDuplicates = new boolean[matrixSize];
            boolean[] columnDuplicates = new boolean[matrixSize];

            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                for (int columnIndex = 0; columnIndex < matrixSize; columnIndex++) {
                    int currentElement = scanner.nextInt();

                    if (rowIndex == columnIndex) {
                        traceSum += currentElement;
                    }

                    if (rowCheck[rowIndex][currentElement - 1] && !rowDuplicates[rowIndex]) {
                        rowCount++;
                        rowDuplicates[rowIndex] = true;
                    }

                    if (columnCheck[columnIndex][currentElement - 1] && !columnDuplicates[columnIndex]) {
                        columnCount++;
                        columnDuplicates[columnIndex] = true;
                    }

                    rowCheck[rowIndex][currentElement - 1] = true;
                    columnCheck[columnIndex][currentElement - 1] = true;
                }
            }

            System.out.println("Case #" + (testIndex + 1) + ": " + traceSum + " " + rowCount + " " + columnCount);
        }

        scanner.close();
    }
}