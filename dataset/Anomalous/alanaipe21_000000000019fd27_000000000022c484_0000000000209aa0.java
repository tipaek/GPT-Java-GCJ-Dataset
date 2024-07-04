import java.util.Scanner;

public class Solution {
    static boolean[] isRowTaken;

    public static int[] checkIfAvailable(int[][] matrix, int val, int pos, int n) {
        int steps = (pos < val - 1) ? n - (val - 1) + pos : pos - (val - 1);
        int mirrorPos = n - 1 - pos;
        int mirrorSteps = (mirrorPos < val - 1) ? n - (val - 1) + mirrorPos : mirrorPos - (val - 1);

        int[] result = {0, 0};
        if (!isRowTaken[steps]) {
            isRowTaken[steps] = true;
            result[0] = 1;
            result[1] = steps + 1;
        } else if (!isRowTaken[mirrorSteps] && n > 2) {
            isRowTaken[mirrorSteps] = true;
            result[0] = 1;
            result[1] = -1 * (mirrorSteps + 1);
        } else {
            result[0] = 0;
            result[1] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[][] matrix = new int[50][50];

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int kCopy = k;
            int curr = n;
            int lastInsertPos = -1;
            String output = "";
            int[][] rotatedMatrix = new int[n][n];
            isRowTaken = new boolean[n];

            for (int j = 0; j < n; j++) {
                rotatedMatrix[0][j] = j + 1;
                isRowTaken[j] = false;
            }

            for (int j = 1; j < n; j++) {
                for (int k1 = 0; k1 < n; k1++) {
                    rotatedMatrix[j][(k1 + 1) % n] = rotatedMatrix[j - 1][k1];
                }
            }

            while (true) {
                if (kCopy > curr) {
                    matrix[++lastInsertPos][lastInsertPos] = curr;
                    kCopy -= curr;
                } else if (kCopy < curr) {
                    curr--;
                } else {
                    matrix[++lastInsertPos][lastInsertPos] = curr;
                    kCopy -= curr;
                    break;
                }
            }

            if (lastInsertPos >= 0 && lastInsertPos < n - 1) {
                int amountToReduce = 0;
                for (int j = lastInsertPos + 1; j < n; j++) {
                    matrix[j][j] = 1;
                    amountToReduce++;
                }

                while (amountToReduce > 0 && lastInsertPos >= 0) {
                    int f = Math.min(amountToReduce, matrix[lastInsertPos][lastInsertPos] - 1);
                    matrix[lastInsertPos][lastInsertPos] -= f;
                    amountToReduce -= f;
                    lastInsertPos--;
                }

                output = (amountToReduce > 0 && lastInsertPos < 0) ? "IMPOSSIBLE" : "POSSIBLE";
            } else {
                output = "POSSIBLE";
            }

            if (output.equals("POSSIBLE")) {
                for (int j = 0; j < n; j++) {
                    int[] result = checkIfAvailable(rotatedMatrix, matrix[j][j], j, n);
                    if (result[0] == 0) {
                        output = "IMPOSSIBLE";
                        break;
                    } else {
                        for (int k1 = 0; k1 < n; k1++) {
                            matrix[j][k1] = (result[1] > 0) ? rotatedMatrix[result[1] - 1][k1] : rotatedMatrix[-result[1] - 1][n - k1 - 1];
                        }
                    }
                }

                if (output.equals("POSSIBLE")) {
                    System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                    for (int j = 0; j < n; j++) {
                        for (int k1 = 0; k1 < n; k1++) {
                            System.out.print(matrix[j][k1] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}