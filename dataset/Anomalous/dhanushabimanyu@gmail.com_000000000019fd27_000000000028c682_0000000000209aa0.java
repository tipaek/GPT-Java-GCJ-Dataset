import java.util.Scanner;

public class Solution {

    public static boolean isLatinSquare(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                return false;
            }

            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasDuplicates(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j && array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int quotient = k / n;
            int remainder = k % n;
            int[] trace = new int[n];
            int[][] latinSquare = new int[n][n];

            for (int i = 0; i < n; i++) {
                trace[i] = quotient;
            }
            for (int i = 0; i < remainder; i++) {
                trace[i]++;
            }
            for (int i = 0; i < n; i++) {
                latinSquare[i][i] = trace[i];
            }

            for (int i = 0; i < n; i++) {
                int currentNum = latinSquare[i][i];
                if (i % 2 == 0) {
                    int counter = 1;
                    for (int j = 0; j < n; j++) {
                        if (j != i) {
                            if (counter == currentNum) {
                                counter++;
                            }
                            latinSquare[i][j] = counter++;
                        }
                    }
                } else {
                    int counter = n;
                    for (int j = 0; j < n; j++) {
                        if (j != i) {
                            if (counter == currentNum) {
                                counter--;
                            }
                            latinSquare[i][j] = counter--;
                        }
                    }
                }
            }

            if (isLatinSquare(latinSquare)) {
                System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(latinSquare[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}