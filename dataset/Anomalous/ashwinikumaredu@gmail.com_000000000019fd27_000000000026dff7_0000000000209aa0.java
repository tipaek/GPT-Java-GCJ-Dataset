import java.util.Scanner;

public class Solution {

    static void generateLatinSquare(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            int k = i + 1;
            int temp = 1;
            for (int j = 0; j < size; j++) {
                if (k <= size) {
                    matrix[i][j] = k;
                    k++;
                } else {
                    matrix[i][j] = temp;
                    temp++;
                }
            }
        }
    }

    static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int desiredTrace = scanner.nextInt();
            int[][] matrix = new int[size][size];

            generateLatinSquare(matrix, size);
            int actualTrace = calculateTrace(matrix, size);

            if (desiredTrace == actualTrace) {
                System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        System.out.print(matrix[i][j] + " ");
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