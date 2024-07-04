import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = 1;

        while (caseNumber <= t) {
            String[] dimensions = br.readLine().trim().split("\\s+");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);
            int[][] arr = new int[rows][cols];
            int[][] check = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                String[] rowValues = br.readLine().trim().split("\\s+");
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = Integer.parseInt(rowValues[j]);
                    check[i][j] = 0;
                }
            }

            int result = 0;
            boolean continueFlag = true;

            while (continueFlag) {
                int sum = 0;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (arr[i][j] != -1) {
                            sum += arr[i][j];
                        }
                    }
                }
                result += sum;

                int removeCount = 0;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (arr[i][j] != -1) {
                            int skill = arr[i][j];
                            int neighborSum = 0;
                            int neighborCount = 0;

                            // Check top
                            for (int k = i - 1; k >= 0; k--) {
                                if (arr[k][j] != -1) {
                                    neighborSum += arr[k][j];
                                    neighborCount++;
                                    break;
                                }
                            }

                            // Check bottom
                            for (int k = i + 1; k < rows; k++) {
                                if (arr[k][j] != -1) {
                                    neighborSum += arr[k][j];
                                    neighborCount++;
                                    break;
                                }
                            }

                            // Check left
                            for (int k = j - 1; k >= 0; k--) {
                                if (arr[i][k] != -1) {
                                    neighborSum += arr[i][k];
                                    neighborCount++;
                                    break;
                                }
                            }

                            // Check right
                            for (int k = j + 1; k < cols; k++) {
                                if (arr[i][k] != -1) {
                                    neighborSum += arr[i][k];
                                    neighborCount++;
                                    break;
                                }
                            }

                            if (neighborSum > skill * neighborCount) {
                                check[i][j] = 1;
                                removeCount++;
                            }
                        }
                    }
                }

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (check[i][j] == 1) {
                            arr[i][j] = -1;
                        }
                    }
                }

                if (removeCount == 0) {
                    continueFlag = false;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}