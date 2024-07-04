import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {
            int testCases = Integer.parseInt(br.readLine());
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                int sum = Integer.parseInt(br.readLine());
                int n = sum;
                int[][] pascalTriangle = new int[n][n];

                int index = 0, tempSum = 1;
                for (int i = 1; i <= 1000; i++) {
                    if (sum > tempSum) {
                        tempSum += 2 * i;
                    } else {
                        index = i;
                        break;
                    }
                }

                for (int line = 0; line < n; line++) {
                    for (int i = 0; i <= line; i++) {
                        if (line == i || i == 0) {
                            pascalTriangle[line][i] = 1;
                        } else {
                            pascalTriangle[line][i] = pascalTriangle[line - 1][i - 1] + pascalTriangle[line - 1][i];
                        }
                    }
                }

                System.out.println("Case #" + caseNum + ":");
                boolean flag = false;

                outerLoop:
                for (int i = 0; i < n; i++) {
                    if (i < index - 1) {
                        if (flag) {
                            for (int j = 0; j < n; j++) {
                                if (pascalTriangle[i][j] != 0) {
                                    sum -= pascalTriangle[i][j];
                                    System.out.println((i + 1) + " " + (j + 1));
                                    if (sum <= 0) {
                                        break outerLoop;
                                    }
                                }
                            }
                        } else {
                            for (int j = n - 1; j >= 0; j--) {
                                if (pascalTriangle[i][j] != 0) {
                                    sum -= pascalTriangle[i][j];
                                    System.out.println((i + 1) + " " + (j + 1));
                                    if (sum <= 0) {
                                        break outerLoop;
                                    }
                                }
                            }
                        }
                        flag = !flag;
                    } else {
                        if (flag) {
                            if (sum == 0) {
                                break outerLoop;
                            }
                            sum -= pascalTriangle[i][0];
                            System.out.println((i + 1) + " " + 1);
                        } else {
                            for (int j = n - 1; j >= 0; j--) {
                                if (sum == 0) {
                                    break outerLoop;
                                }
                                if (pascalTriangle[i][j] != 0) {
                                    sum -= pascalTriangle[i][j];
                                    System.out.println((i + 1) + " " + (j + 1));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}