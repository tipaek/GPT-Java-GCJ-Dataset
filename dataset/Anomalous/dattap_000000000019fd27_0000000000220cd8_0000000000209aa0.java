import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] dimensions = scanner.nextLine().split(" ");
            int N = Integer.parseInt(dimensions[0]);
            int K = Integer.parseInt(dimensions[1]);

            int[][] matrix = new int[N][N];
            boolean[][] filled = new boolean[N][N];
            boolean possible = false;

            for (int value = 1; value <= N; value++) {
                int diagonalSum = 0;

                for (int idx = 0; idx < N; idx++) {
                    matrix[idx][idx] = value;
                    diagonalSum += matrix[idx][idx];
                    filled[idx][idx] = true;
                }

                if (diagonalSum == K) {
                    possible = true;
                    int[] remainingValues = new int[N - 1];
                    int index = 0;

                    for (int num = 1; num <= N; num++) {
                        if (num != value) {
                            remainingValues[index++] = num;
                        }
                    }

                    for (int row = 0; row < N; row++) {
                        index = 0;
                        for (int col = 0; col < N; col++) {
                            if (!filled[row][col]) {
                                matrix[row][col] = remainingValues[index++];
                                filled[row][col] = true;
                            }
                        }
                        rotateArray(remainingValues);
                    }
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    private static void rotateArray(int[] array) {
        int firstElement = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[array.length - 1] = firstElement;
    }
}