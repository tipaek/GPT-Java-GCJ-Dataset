import java.util.*;
import java.io.*;

class Solution {
    public static int calculateSum(int n) {
        return n * (n + 1) / 2;
    }

    public static int countNonMatchingSums(int[] arr, int expectedSum) {
        int count = 0;
        for (int value : arr) {
            if (value != expectedSum) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline

            int[] rowSums = new int[n];
            int[] colSums = new int[n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    int number = Integer.parseInt(input[j]);
                    rowSums[i] += number;
                    colSums[j] += number;
                    if (i == j) {
                        trace += number;
                    }
                }
            }

            int expectedSum = calculateSum(n);
            int rowDuplicates = countNonMatchingSums(rowSums, expectedSum);
            int colDuplicates = countNonMatchingSums(colSums, expectedSum);

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowDuplicates, colDuplicates);
        }
    }
}