import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int i = 0; i < testCases; i++) {
            int b = input.nextInt();
            int c = input.nextInt();

            String result = "POSSIBLE";
            if (c % b != 0) {
                result = "IMPOSSIBLE";
                System.out.println("Case #" + (i + 1) + ": " + result);
            } else {
                int quotient = c / b;
                int[][] matrix = new int[b][b];

                for (int col = 0; col < b; col++) {
                    if (quotient > b) {
                        quotient -= b;
                    }
                    matrix[0][col] = quotient;
                    quotient++;
                }

                for (int row = 1; row < b; row++) {
                    for (int col = 0; col < b; col++) {
                        if (matrix[row - 1][col] - 1 == 0) {
                            matrix[row][col] = b;
                        } else {
                            matrix[row][col] = matrix[row - 1][col] - 1;
                        }
                    }
                }

                System.out.println("Case #" + (i + 1) + ": " + result);

                for (int row = 0; row < b; row++) {
                    for (int col = 0; col < b; col++) {
                        System.out.print(matrix[row][col]);
                        if (col != b - 1) {
                            System.out.print(" ");
                        } else {
                            System.out.println();
                        }
                    }
                }
            }
        }
        input.close();
    }
}