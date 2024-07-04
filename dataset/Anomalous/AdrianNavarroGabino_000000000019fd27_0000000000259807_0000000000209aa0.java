import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int index = 1; index <= cases; index++) {
            int size = sc.nextInt();
            int trace = sc.nextInt();

            if (trace < size) {
                System.out.println("Case #" + index + ": IMPOSSIBLE");
                continue;
            }

            int[][] matrix = new int[size][size];
            boolean diagonalFound = false;

            for (int i = 0; i < size; i++) {
                int currentTrace = 0;

                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        matrix[j][k] = (i + k + j) % size + 1;
                    }
                    currentTrace += matrix[j][j];
                }

                if (currentTrace == trace) {
                    diagonalFound = true;
                    break;
                }
            }

            if (diagonalFound) {
                System.out.println("Case #" + index + ": POSSIBLE");
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        System.out.print(matrix[i][j]);
                        if (j < size - 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + index + ": IMPOSSIBLE");
            }
        }
    }
}