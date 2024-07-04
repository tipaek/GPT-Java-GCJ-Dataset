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
            int result = 0;
            int[][] matrix = new int[rows][cols];
            int totalInterest = 0;
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = reader.nextInt();
                    totalInterest += matrix[i][j];
                }
            }
            
            while (true) {
                result += totalInterest;
                LinkedList<Point> pointsToEliminate = new LinkedList<>();
                
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (matrix[i][j] > 0) {
                            int sum = 0;
                            int count = 0;
                            
                            // Check upwards
                            for (int k = i - 1; k >= 0 && matrix[k][j] == 0; k--);
                            if (k >= 0) {
                                sum += matrix[k][j];
                                count++;
                            }
                            
                            // Check downwards
                            for (int k = i + 1; k < rows && matrix[k][j] == 0; k++);
                            if (k < rows) {
                                sum += matrix[k][j];
                                count++;
                            }
                            
                            // Check leftwards
                            for (int k = j - 1; k >= 0 && matrix[i][k] == 0; k--);
                            if (k >= 0) {
                                sum += matrix[i][k];
                                count++;
                            }
                            
                            // Check rightwards
                            for (int k = j + 1; k < cols && matrix[i][k] == 0; k++);
                            if (k < cols) {
                                sum += matrix[i][k];
                                count++;
                            }
                            
                            if (count > 0 && matrix[i][j] < (double) sum / count) {
                                pointsToEliminate.add(new Point(i, j));
                            }
                        }
                    }
                }
                
                if (!pointsToEliminate.isEmpty()) {
                    for (Point point : pointsToEliminate) {
                        totalInterest -= matrix[point.x][point.y];
                        matrix[point.x][point.y] = 0;
                    }
                } else {
                    break;
                }
            }
            
            System.out.printf("Case #%d: %d\n", caseNumber++, result);
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileReader fileReader) {
            reader = new BufferedReader(fileReader);
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