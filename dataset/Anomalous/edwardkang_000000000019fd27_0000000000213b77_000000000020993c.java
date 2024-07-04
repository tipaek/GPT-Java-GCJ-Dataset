import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int n = scanner.nextInt();
            int[] frequency = new int[n + 1];
            boolean[] hasDuplicateInRow = new boolean[n];
            boolean[] hasDuplicateInColumn = new boolean[n];
            int trace = 0;

            for (int row = 0; row < n; row++) {
                Arrays.fill(frequency, 0); // Reset frequency array for each row
                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();
                    
                    if (row == col) {
                        trace += value;
                    }
                    
                    if (frequency[value] == 1) {
                        hasDuplicateInRow[row] = true;
                    } else {
                        frequency[value] = 1;
                    }
                }
            }

            // Reset frequency array for column check
            for (int col = 0; col < n; col++) {
                Arrays.fill(frequency, 0);
                for (int row = 0; row < n; row++) {
                    int value = scanner.nextInt();
                    
                    if (frequency[value] == 1) {
                        hasDuplicateInColumn[col] = true;
                    } else {
                        frequency[value] = 1;
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int row = 0; row < n; row++) {
                if (hasDuplicateInRow[row]) {
                    duplicateRows++;
                }
            }

            for (int col = 0; col < n; col++) {
                if (hasDuplicateInColumn[col]) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}