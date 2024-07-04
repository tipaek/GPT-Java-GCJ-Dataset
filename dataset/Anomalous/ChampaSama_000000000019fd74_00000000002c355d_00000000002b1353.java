import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {
            int testCases = Integer.parseInt(br.readLine());
            for (int cases = 0; cases < testCases; cases++) {
                int sum = Integer.parseInt(br.readLine());
                int n = sum;
                int[][] arr = new int[n][n];
                int index = calculateMaxIndex(sum);

                fillPascalTriangle(arr, n);

                System.out.println("Case #" + (cases + 1) + ": ");
                printPath(arr, n, index, sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculateMaxIndex(int sum) {
        int index = 0;
        int tempSum = 1;
        for (int i = 1; i <= 1000; i++) {
            if (sum >= tempSum) {
                tempSum += Math.pow(2, i);
                index++;
            } else {
                break;
            }
        }
        return index;
    }

    private static void fillPascalTriangle(int[][] arr, int n) {
        for (int line = 0; line < n; line++) {
            for (int i = 0; i <= line; i++) {
                if (line == i || i == 0) {
                    arr[line][i] = 1;
                } else {
                    arr[line][i] = arr[line - 1][i - 1] + arr[line - 1][i];
                }
            }
        }
    }

    private static void printPath(int[][] arr, int n, int index, int sum) {
        boolean flag = false;
        outerLoop: for (int i = 0; i < n; i++) {
            if (i < index) {
                if (flag) {
                    for (int j = 0; j < n; j++) {
                        if (arr[i][j] != 0) {
                            sum -= arr[i][j];
                            System.out.println((i + 1) + " " + (j + 1));
                        }
                        if (sum <= 0) {
                            break outerLoop;
                        }
                    }
                } else {
                    for (int j = n - 1; j >= 0; j--) {
                        if (arr[i][j] != 0) {
                            sum -= arr[i][j];
                            System.out.println((i + 1) + " " + (j + 1));
                        }
                        if (sum <= 0) {
                            break outerLoop;
                        }
                    }
                }
                flag = !flag;
            } else {
                if (flag) {
                    if (sum == 0) {
                        break outerLoop;
                    }
                    sum -= arr[i][0];
                    System.out.println((i + 1) + " " + 1);
                } else {
                    for (int j = n - 1; j >= 0; j--) {
                        if (sum == 0) {
                            break outerLoop;
                        }
                        if (arr[i][j] != 0) {
                            sum -= arr[i][j];
                            System.out.println((i + 1) + " " + (j + 1));
                            break;
                        }
                    }
                }
            }
        }
    }
}