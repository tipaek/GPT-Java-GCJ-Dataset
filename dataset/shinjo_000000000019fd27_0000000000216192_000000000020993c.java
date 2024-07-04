import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        int testCase;
        int tc;
        int tc2;
        int sizeN;
        int matrix[][][] = new int[100][100][100];
        int result[][] = new int[100][100];

        int tempMatrix[][][] = new int[100][100][100];

        Scanner sc = new Scanner(System.in);

        testCase = sc.nextInt();
        tc = 0;
        tc2 = testCase;

        while (testCase-- > 0) {
            sizeN = sc.nextInt();
            result[tc][3] = sizeN;

            for (int i = 0; i < sizeN; i++) {
                for (int j = 0; j < sizeN; j++) {
                    matrix[tc][i][j] = sc.nextInt();

                    if (i == j) {
                        result[tc][0] += matrix[tc][i][j];
                    }
                }

                boolean pause = false;

                for (int j = 0; j < sizeN && !pause; j++) {
                    for (int k = j + 1; k < sizeN; k++) {
                        if (k != j && matrix[tc][i][k] == matrix[tc][i][j]) {
                            result[tc][1]++;
                            pause = true;
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i < sizeN; i++) {
                for (int j = 0; j < sizeN; j++) {
                    tempMatrix[tc][j][i] = matrix[tc][i][j];
                }
            }

            for (int i = 0; i < sizeN; i++) {
                boolean pause = false;

                for (int j = 0; j < sizeN && !pause; j++) {
                    for (int k = j + 1; k < sizeN; k++) {
                        if (k != j && tempMatrix[tc][i][k] == tempMatrix[tc][i][j]) {
                            result[tc][2]++;
                            pause = true;
                            break;
                        }
                    }
                }
            }

            tc++;
        }

        printResult(result, tc2);

    }

    public static void printResult(int result[][], int tc2) {
        int tc3 = 0;
        while (tc2-- > 0) {
            System.out.println(result[tc3][3]);
            if (result[tc3][1] < result[tc3][3])
                System.out.println(String.format("Case #%d: %d %d %d", tc3 + 1, result[tc3][0], result[tc3][1], result[tc3][2]-result[tc3][1]));
            else
                System.out.println(String.format("Case #%d: %d %d", tc3 + 1, result[tc3][0], result[tc3][1]));

            tc3++;
        }

    }
}
