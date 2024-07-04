import java.util.*;
import java.io.*;

class Solution {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        for (int t = 1; t < testCases + 1; t++) {
            int n = sc.nextInt();
            int trace = 0;
            int r = 0;
            int c = 0;
            int[][] matrix = new int[n][n];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                int flag = 0;
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (matrix[i][j] == matrix[i][k]) {
                            r++;
                            flag = 1;
                            break;
                        }
                    }

                    if (flag == 1)
                        break;
                }
            }

            for (int j = 0; j < n; j++) {
                int flag = 0;
                for (int i = 0; i < n; i++) {
                    for (int k = i + 1; k < n; k++) {
                        if (matrix[i][j] == matrix[k][j]) {
                            c++;
                            flag = 1;
                            break;
                        }
                    }

                    if (flag == 1)
                        break;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + r + " " + c);
        }
    }
}