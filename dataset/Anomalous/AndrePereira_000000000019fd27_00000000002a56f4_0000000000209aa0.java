import java.util.*;

public class Solution {

    private static void indicium(int caseNumber, int size, int trace) {
        boolean isPossible = (trace % size == 0);
        System.out.printf("Case #%d: %s%n", caseNumber, isPossible ? "POSSIBLE" : "IMPOSSIBLE");

        if (isPossible) {
            int diagonalValue = trace / size;
            int[] rowValues = new int[size];
            int index = 1;
            rowValues[0] = diagonalValue;

            // Fill rowValues array excluding the diagonal value
            for (int i = 1; i <= size; i++) {
                if (i != diagonalValue) {
                    rowValues[index++] = i;
                }
            }

            // Print the matrix
            for (int i = 1; i <= size; i++) {
                index = 0;  // Reset index for each row
                for (int j = 1; j <= size; j++) {
                    if (i == j) {
                        System.out.print(diagonalValue + " ");
                    } else {
                        System.out.print(rowValues[index] + " ");
                        index = (index + 1) % size;
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int trace = Integer.parseInt(input[1]);
            indicium(caseIndex + 1, n, trace);
        }
    }
}