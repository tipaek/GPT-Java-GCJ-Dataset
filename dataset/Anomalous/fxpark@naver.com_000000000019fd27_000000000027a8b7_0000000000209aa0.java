import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer tokenizer;

    private String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private void solve() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(nextToken());
        for (int i = 0; i < testCases; ++i) {
            String result = processTestCase();
            if (result != null) {
                writer.printf("Case #%d: POSSIBLE%n", i + 1);
                writer.println(result);
            } else {
                writer.printf("Case #%d: IMPOSSIBLE%n", i + 1);
            }
        }
        reader.close();
        writer.close();
    }

    private String processTestCase() throws IOException {
        int n = Integer.parseInt(nextToken());
        int k = Integer.parseInt(nextToken());
        int[] solution = new int[n];
        for (int i = 0; i < n; i++) {
            if ((i + 1) * n == k) {
                Arrays.fill(solution, i + 1);
                break;
            }
        }

        if (solution[0] == 0) {
            int quotient = k / n;
            int remainder = k % n;

            if (quotient > 1) {
                quotient--;
                remainder += n;
            }

            int counter = 0;
            for (int j = 0; j < n; j++) {
                int add;
                if (counter <= remainder) {
                    add = counter;
                    remainder -= counter;
                    if (quotient + counter < n) counter++;
                } else {
                    add = remainder;
                    remainder = 0;
                }
                solution[j] = quotient + add;
            }
        }

        if (isImpossible(solution)) return null;
        return generateMatrix(solution);
    }

    private String generateMatrix(int[] solution) {
        int size = solution.length;
        int[][] matrix = initializeMatrix(solution);
        int[] completedRows = new int[size];
        int startRow = 0, currentRow = 0;

        while (!allRowsCompleted(completedRows) && startRow < size) {
            if (currentRow == size) currentRow = 0;

            int[] tempRow = new int[size];
            tempRow[solution[currentRow] - 1] = 1;
            boolean rowFound = findRow(matrix, tempRow, currentRow, 0, solution);

            if (rowFound) {
                completedRows[currentRow] = 1;
                currentRow++;
            } else {
                startRow++;
                currentRow = startRow;
                matrix = initializeMatrix(solution);
                completedRows = new int[size];
            }
        }

        StringBuilder result = new StringBuilder();
        for (int[] row : matrix) {
            for (int value : row) {
                result.append(value).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    private boolean allRowsCompleted(int[] completedRows) {
        for (int row : completedRows) {
            if (row == 0) return false;
        }
        return true;
    }

    private int[][] initializeMatrix(int[] solution) {
        int size = solution.length;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = solution[i];
        }
        return matrix;
    }

    private boolean findRow(int[][] matrix, int[] tempRow, int rowNum, int colNum, int[] solution) {
        if (colNum == solution.length) return true;
        if (rowNum == colNum) {
            tempRow[solution[colNum] - 1] = 1;
            return findRow(matrix, tempRow, rowNum, colNum + 1, solution);
        } else {
            int[] columnPresence = new int[tempRow.length];
            for (int i = 0; i < tempRow.length; i++) {
                if (matrix[i][colNum] != 0) {
                    columnPresence[matrix[i][colNum] - 1] = 1;
                }
            }

            for (int i = 0; i < tempRow.length; i++) {
                if (tempRow[i] == 0 && columnPresence[i] == 0) {
                    matrix[rowNum][colNum] = i + 1;
                    tempRow[i] = 1;
                    if (findRow(matrix, tempRow, rowNum, colNum + 1, solution)) return true;
                    matrix[rowNum][colNum] = 0;
                    tempRow[i] = 0;
                }
            }
            return false;
        }
    }

    private boolean isImpossible(int[] solution) {
        int[] frequency = new int[solution.length];
        for (int value : solution) {
            if (value == 0) return true;
            frequency[value - 1]++;
        }
        int maxFrequency = 0, maxFreqIndex = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > maxFrequency) {
                maxFrequency = frequency[i];
                maxFreqIndex = i;
            }
        }
        int nonMaxFreqCount = 0;
        for (int value : solution) {
            if (value != maxFreqIndex + 1) nonMaxFreqCount++;
        }
        return nonMaxFreqCount == 1;
    }
}