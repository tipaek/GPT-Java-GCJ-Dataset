import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            boolean[][] columnCheck = new boolean[matrixSize][matrixSize + 1];
            boolean[][] rowCheck = new boolean[matrixSize][matrixSize + 1];
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    if (i == j) {
                        trace += value;
                    }
                    if (rowCheck[i][value]) {
                        rowCheck[i][0] = true;
                    } else {
                        rowCheck[i][value] = true;
                    }
                    if (columnCheck[j][value]) {
                        columnCheck[j][0] = true;
                    } else {
                        columnCheck[j][value] = true;
                    }
                    if (i == matrixSize - 1 && columnCheck[j][0]) {
                        duplicateColumns++;
                    }
                }
                if (rowCheck[i][0]) {
                    duplicateRows++;
                }
            }
            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
        scanner.close();
    }
}