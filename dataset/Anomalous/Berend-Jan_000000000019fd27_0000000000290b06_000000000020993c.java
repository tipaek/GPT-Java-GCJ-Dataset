import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            boolean[][] rowTracker = new boolean[matrixSize][matrixSize + 1];
            boolean[][] colTracker = new boolean[matrixSize][matrixSize + 1];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    int num = scanner.nextInt();

                    if (i == j) {
                        trace += num;
                    }

                    if (rowTracker[i][num]) {
                        rowDuplicates++;
                    } else {
                        rowTracker[i][num] = true;
                    }

                    if (colTracker[j][num]) {
                        colDuplicates++;
                    } else {
                        colTracker[j][num] = true;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}