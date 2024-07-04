import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";
    private static final int MAX_PASCAL_SIZE = 501;
    private static int[][] pascal = new int[MAX_PASCAL_SIZE][MAX_PASCAL_SIZE];

    public static void main(String[] args) {
        initializePascalTriangle();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int caseNum = 1; caseNum <= t; ++caseNum) {
            new Solution().getAnswer(caseNum, scanner);
        }
    }

    private static void initializePascalTriangle() {
        pascal[1][1] = 1;
        for (int i = 2; i < MAX_PASCAL_SIZE; i++) {
            for (int j = 1; j <= i; j++) {
                if (j - 1 > 0) {
                    pascal[i][j] += pascal[i - 1][j - 1];
                }
                if (j < i) {
                    pascal[i][j] += pascal[i - 1][j];
                }
            }
        }
    }

    public void getAnswer(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        int sum = 0;
        int cnt = 0;

        if (n <= 500) {
            for (int i = 1; i <= n; i++) {
                result.append(String.format("\n%d 1", i));
                sum += pascal[i][1];
                cnt++;
            }
        } else if (n == 501) {
            result.append("\n1 1\n2 1\n3 2\n3 1");
            sum += pascal[1][1] + pascal[2][1] + pascal[3][2] + pascal[3][1];
            cnt = 4;
            for (int i = 4; i <= 499; i++) {
                result.append(String.format("\n%d 1", i));
                sum += pascal[i][1];
                cnt++;
            }
        } else if (n <= 998) {
            result.append("\n1 1");
            sum += pascal[1][1];
            cnt++;
            int level = n / 2 + 1;
            if (n % 2 == 1) {
                result.append("\n2 1");
                sum += pascal[2][1];
                cnt++;
            }
            for (int i = 2; i < level; i++) {
                result.append(String.format("\n%d 1", i));
                sum += pascal[i][1];
                cnt++;
            }
            result.append(String.format("\n%d 2", level));
            sum += pascal[level][2];
        } else if (n == 999) {
            for (int i = 1; i < 4; i++) {
                result.append(String.format("\n%d 1", i));
                sum += pascal[i][1];
                cnt++;
            }
            result.append("\n4 2");
            sum += pascal[4][2];
            cnt++;
            for (int i = 4; i <= 498; i++) {
                result.append(String.format("\n%d 1", i));
                sum += pascal[i][1];
                cnt++;
            }
            result.append("\n499 2");
            sum += pascal[499][2];
            cnt++;
        } else if (n == 1000) {
            for (int i = 1; i < 5; i++) {
                result.append(String.format("\n%d 1", i));
                sum += pascal[i][1];
                cnt++;
            }
            result.append("\n5 2");
            sum += pascal[5][2];
            cnt++;
            for (int i = 5; i <= 498; i++) {
                result.append(String.format("\n%d 1", i));
                sum += pascal[i][1];
                cnt++;
            }
            result.append("\n499 2");
            sum += pascal[499][2];
            cnt++;
        }

        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result.toString()));
    }
}