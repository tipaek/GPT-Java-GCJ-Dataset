

import java.util.BitSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            int n = Integer.parseInt(scanner.nextLine());

            int[][] arr = new int[n][n];

            for (int j = 0; j < n; j++) {
                String[] lineSplit = scanner.nextLine().split(" ");
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(lineSplit[k]);
                }
            }

            process(arr, n, i + 1);
        }

    }

    private static void process(int[][] arr, int n, int caseNumber) {
        BitSet[] rows = new BitSet[n];
        BitSet[] cols = new BitSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new BitSet(n);
            cols[i] = new BitSet(n);
        }

        int trace = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                rows[row].set(arr[row][col] - 1);
                cols[col].set(arr[row][col] - 1);

                if (row == col) {
                    trace += arr[row][col];
                }
            }
        }

        int numberRows = 0;
        int numberCols = 0;

        for (int i = 0; i < n; i++) {
            if (rows[i].nextClearBit(0) != n) {
                numberRows++;
            }

            if (cols[i].nextClearBit(0) != n) {
                numberCols++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + numberRows + " " + numberCols);
    }
}
