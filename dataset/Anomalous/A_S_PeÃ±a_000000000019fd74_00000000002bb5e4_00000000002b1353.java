import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static int[][] generateMatrix(int N) {
        int[][] result;

        switch (N) {
            case 1:
                result = new int[1][2];
                result[0][0] = 1;
                result[0][1] = 1;
                return result;

            case 2:
                result = new int[2][2];
                result[0][0] = 1;
                result[0][1] = 1;
                result[1][0] = 2;
                result[1][1] = 1;
                return result;

            case 999:
                result = new int[500][2];
                result[0][0] = 1;
                result[0][1] = 1;
                result[1][0] = 2;
                result[1][1] = 1;
                result[2][0] = 3;
                result[2][1] = 1;
                result[3][0] = 4;
                result[3][1] = 2;

                for (int r = 4; r < 499; ++r) {
                    result[r][0] = r;
                    result[r][1] = 1;
                }
                result[499][0] = 499;
                result[499][1] = 2;
                return result;

            case 1000:
                result = new int[500][2];
                result[0][0] = 1;
                result[0][1] = 1;
                result[1][0] = 2;
                result[1][1] = 1;
                result[2][0] = 3;
                result[2][1] = 1;
                result[3][0] = 4;
                result[3][1] = 1;
                result[4][0] = 5;
                result[4][1] = 2;

                for (int r = 5; r < 499; ++r) {
                    result[r][0] = r;
                    result[r][1] = 1;
                }
                result[499][0] = 499;
                result[499][1] = 2;
                return result;

            default:
                int total = (N + 1) / 2 + 1;
                result = new int[total][2];
                int r = 1;

                while (N > 0) {
                    result[r - 1][0] = r;
                    result[r - 1][1] = 1;
                    --N;

                    if (N == r - 1) {
                        result[total - 1][0] = r;
                        result[total - 1][1] = 2;
                        return result;
                    }

                    if (N == r) {
                        result[total - 1][0] = r + 1;
                        result[total - 1][1] = 2;
                        return result;
                    }

                    ++r;
                }
                return result;
        }
    }

    public static void main(String[] args) {
        int T = scanner.nextInt();

        for (int i = 1; i <= T; ++i) {
            int N = scanner.nextInt();
            int[][] result = generateMatrix(N);

            System.out.printf("Case #%d:\n", i);
            for (int[] row : result) {
                System.out.printf("%d %d\n", row[0], row[1]);
            }
        }

        scanner.close();
    }
}