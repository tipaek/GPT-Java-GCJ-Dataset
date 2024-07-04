import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            int rows = reader.nextInt();
            int cols = reader.nextInt();
            long totalSum = 0;
            int[][] matrix = new int[rows][cols];
            long currentInterest = 0;
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = reader.nextInt();
                    currentInterest += matrix[i][j];
                }
            }

            while (true) {
                totalSum += currentInterest;
                LinkedList<Point> pointsToEliminate = new LinkedList<>();
                
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (matrix[i][j] > 0) {
                            int surroundingSum = 0;
                            int surroundingCount = 0;

                            // Check above
                            for (int row = i - 1; row >= 0 && matrix[row][j] == 0; row--);
                            if (row >= 0) {
                                surroundingSum += matrix[row][j];
                                surroundingCount++;
                            }

                            // Check below
                            for (int row = i + 1; row < rows && matrix[row][j] == 0; row++);
                            if (row < rows) {
                                surroundingSum += matrix[row][j];
                                surroundingCount++;
                            }

                            // Check left
                            for (int col = j - 1; col >= 0 && matrix[i][col] == 0; col--);
                            if (col >= 0) {
                                surroundingSum += matrix[i][col];
                                surroundingCount++;
                            }

                            // Check right
                            for (int col = j + 1; col < cols && matrix[i][col] == 0; col++);
                            if (col < cols) {
                                surroundingSum += matrix[i][col];
                                surroundingCount++;
                            }

                            if (surroundingCount > 0 && matrix[i][j] * surroundingCount < surroundingSum) {
                                pointsToEliminate.add(new Point(i, j));
                            }
                        }
                    }
                }

                if (!pointsToEliminate.isEmpty()) {
                    for (Point point : pointsToEliminate) {
                        currentInterest -= matrix[point.x][point.y];
                        matrix[point.x][point.y] = 0;
                    }
                } else {
                    break;
                }
            }
            
            System.out.printf("Case #%d: %d\n", caseNumber++, totalSum);
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public InputReader(FileReader fileReader) {
            reader = new BufferedReader(fileReader);
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}