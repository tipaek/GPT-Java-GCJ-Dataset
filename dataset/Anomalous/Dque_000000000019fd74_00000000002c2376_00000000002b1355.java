import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int rows = Integer.parseInt(tokenizer.nextToken());
            int cols = Integer.parseInt(tokenizer.nextToken());

            long[][] matrix = new long[rows][cols];

            for (int i = 0; i < rows; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = Long.parseLong(tokenizer.nextToken());
                }
            }

            long[][] left = new long[rows][cols];
            long[][] right = new long[rows][cols];
            long[][] up = new long[rows][cols];
            long[][] down = new long[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    left[i][j] = (i > 0) ? matrix[i - 1][j] : -1;
                    right[i][j] = (i < rows - 1) ? matrix[i + 1][j] : -1;
                    up[i][j] = (j > 0) ? matrix[i][j - 1] : -1;
                    down[i][j] = (j < cols - 1) ? matrix[i][j + 1] : -1;
                }
            }

            boolean stop = false;
            long totalSum = 0L;

            while (!stop) {
                stop = true;
                boolean[][] toRemove = new boolean[rows][cols];

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (matrix[i][j] == 0) continue;
                        totalSum += matrix[i][j];

                        long neighborSum = 0L;
                        long count = 0L;

                        if (left[i][j] != -1) {
                            neighborSum += left[i][j];
                            count++;
                        }
                        if (right[i][j] != -1) {
                            neighborSum += right[i][j];
                            count++;
                        }
                        if (up[i][j] != -1) {
                            neighborSum += up[i][j];
                            count++;
                        }
                        if (down[i][j] != -1) {
                            neighborSum += down[i][j];
                            count++;
                        }

                        if (count > 0 && matrix[i][j] * count < neighborSum) {
                            toRemove[i][j] = true;
                            matrix[i][j] = 0;
                            stop = false;
                        }
                    }
                }

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (toRemove[i][j]) {
                            if (i < rows - 1) {
                                left[i + 1][j] = left[i][j];
                            }
                            if (j < cols - 1) {
                                up[i][j + 1] = up[i][j];
                            }
                        }
                    }
                }

                for (int i = rows - 1; i >= 0; i--) {
                    for (int j = cols - 1; j >= 0; j--) {
                        if (toRemove[i][j]) {
                            if (i > 0) {
                                right[i - 1][j] = right[i][j];
                            }
                            if (j > 0) {
                                down[i][j - 1] = down[i][j];
                            }
                        }
                    }
                }
            }

            writer.println("Case #" + caseNumber + ": " + totalSum);
        }

        writer.close();
    }
}