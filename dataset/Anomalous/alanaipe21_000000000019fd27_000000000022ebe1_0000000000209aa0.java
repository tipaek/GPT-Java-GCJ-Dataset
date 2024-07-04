import java.util.Scanner;

public class Solution {
    static boolean[] isRowTaken1, isRowTaken2;

    public static int[] checkIfAvailable(int[][] matrix, int val, int pos, int n) {
        int steps = (pos < val - 1) ? n - (val - 1) + pos : pos - (val - 1);
        int[] result = {0, 0};

        if (!isRowTaken1[steps]) {
            isRowTaken1[steps] = true;
            result[0] = 1;
            result[1] = steps + 1;
        } else {
            result[0] = 0;
            result[1] = -1;
        }

        return result;
    }

    public static int[] checkIfAvailableinRotated(int[][] matrix, int val, int pos, int n) {
        int steps = (pos < n - 1 - (val - 1)) ? n - (n - 1 - (val - 1)) + pos : pos - (n - 1 - (val - 1));
        int[] result = {0, 0};

        if (!isRowTaken2[steps]) {
            isRowTaken2[steps] = true;
            result[0] = 1;
            result[1] = steps + 1;
        } else {
            result[0] = 0;
            result[1] = -1;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        int[][] matrix = new int[50][50];

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int kCopy = k;
            in.nextLine();
            int curr = n;
            int lastInsertPos = -1;
            String output = "";
            int[][] rotatedMatrix1 = new int[n][n];
            int[][] rotatedMatrix2 = new int[n][n];
            isRowTaken1 = new boolean[n];
            isRowTaken2 = new boolean[n];

            for (int j = 0; j < n; j++) {
                rotatedMatrix1[0][j] = j + 1;
                rotatedMatrix2[0][j] = n - j;
                isRowTaken1[j] = false;
                isRowTaken2[j] = false;
            }

            for (int j = 1; j < n; j++) {
                for (int k1 = 0; k1 < n; k1++) {
                    rotatedMatrix1[j][(k1 + 1) % n] = rotatedMatrix1[j - 1][k1];
                    rotatedMatrix2[j][(k1 + 1) % n] = rotatedMatrix2[j - 1][k1];
                }
            }

            lastInsertPos = -1;
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
                int flag = 0;
                for (int j = 0; j < n; j++) {
                    int[] result = checkIfAvailable(rotatedMatrix1, matrix[j][j], j, n);
                    if (result[0] == 0) {
                        flag = 1;
                        break;
                    } else {
                        for (int k1 = 0; k1 < n; k1++) {
                            matrix[j][k1] = rotatedMatrix1[result[1] - 1][k1];
                        }
                    }
                }

                if (flag == 1) {
                    for (int j = 0; j < n; j++) {
                        int[] result = checkIfAvailableinRotated(rotatedMatrix2, matrix[j][j], j, n);
                        if (result[0] == 0) {
                            flag = 2;
                            break;
                        } else {
                            for (int k1 = 0; k1 < n; k1++) {
                                matrix[j][k1] = rotatedMatrix2[result[1] - 1][k1];
                            }
                        }
                    }
                }

                System.out.println("Case #" + (i + 1) + ": " + (flag != 2 ? "POSSIBLE" : "IMPOSSIBLE"));
                if (flag != 2) {
                    for (int j = 0; j < n; j++) {
                        for (int k1 = 0; k1 < n; k1++) {
                            System.out.print(matrix[j][k1] + " ");
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}