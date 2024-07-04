import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static long[][] choose;

    public static void main(String[] args) {
        initializeChooseArray();
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int n = scanner.nextInt();
            System.out.printf("Case #%d:\n", testCase);
            sum = 0;
            solve(n);
        }
    }

    static void initializeChooseArray() {
        choose = new long[502][];
        for (int i = 0; i < choose.length; i++) {
            choose[i] = new long[i + 1];
            choose[i][0] = choose[i][i] = 1;
            for (int j = 1; j < i; j++) {
                choose[i][j] = choose[i - 1][j - 1] + choose[i - 1][j];
            }
        }
    }

    static void solve(long n) {
        for (int rows = 1; rows <= 501; rows++) {
            for (int bits = 1; bits <= Math.min(32, rows); bits++) {
                long adjustedN = n - (rows - bits);
                if (adjustedN < 0) {
                    continue;
                }
                String binaryString = Long.toBinaryString(adjustedN);
                if (adjustedN == 0 || (binaryString.length() <= rows && Long.bitCount(adjustedN) == bits)) {
                    boolean atStart = true;
                    for (int row = 0; row < rows; row++) {
                        if (atStart) {
                            print(row, 0);
                        } else {
                            print(row, row);
                        }

                        char currentChar = row < binaryString.length() ? binaryString.charAt(binaryString.length() - 1 - row) : '0';
                        if (currentChar == '1') {
                            if (atStart) {
                                for (int col = 1; col <= row; col++) {
                                    print(row, col);
                                }
                            } else {
                                for (int col = row - 1; col >= 0; col--) {
                                    print(row, col);
                                }
                            }
                            atStart = !atStart;
                        }
                    }
                    return;
                }
            }
        }
    }

    static long sum = 0;

    static void print(int row, int col) {
        System.out.println((row + 1) + " " + (col + 1));
        sum += choose[row][col];
    }
}