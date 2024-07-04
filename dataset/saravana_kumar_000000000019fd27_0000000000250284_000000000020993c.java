import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCasesCount = scanner.nextInt();
        scanner.nextLine();

        for (int x = 1; x <= testCasesCount; x++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine();

            int a[][] = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                int num = scanner.nextInt();
                for (int j = matrixSize - 1; j >= 0; j--) {
                    int n = num;
                    n %= 10;
                    a[i][j] = n;
                    num /= 10;
                }
                scanner.nextLine();
            }

            int repeatingRowsCount = 0;
            int repeatingColumnsCount = 0;
            int trace = 0;

            for (int i = 0; i < matrixSize; i++) {
                int uniqueRowItems = 0;
                int uniqueColumnItems = 0;
                for (int num = matrixSize; num > 0; num--) {
                    for (int k = 0; k < matrixSize; k++) {
                        if (a[i][k] == num) {
                            uniqueRowItems++;
                            break;
                        }
                    }
                }
                for (int num = matrixSize; num > 0; num--) {
                    for (int k = 0; k < matrixSize; k++) {
                        if (a[k][i] == num) {
                            uniqueColumnItems++;
                            break;
                        }
                    }
                }
                if (uniqueRowItems != matrixSize) {
                    repeatingRowsCount++;
                }
                if (uniqueColumnItems != matrixSize) {
                    repeatingColumnsCount++;
                }
                for (int j = 0; j < matrixSize; j++) {
                    if (i == j) {
                        trace += a[i][j];
                    }
                }
            }
            System.out.println("Case #" + x + ": " + trace + " " + repeatingRowsCount + " " + repeatingColumnsCount);
        }
        testCasesCount--;
    }
}