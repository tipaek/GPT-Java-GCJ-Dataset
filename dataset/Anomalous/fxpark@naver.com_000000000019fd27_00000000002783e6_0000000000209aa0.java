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
    private StringTokenizer tokenizer = null;

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
                writer.print(result);
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
            int counter = 0;

            for (int j = 0; j < n; j++) {
                int add = counter <= remainder ? counter : remainder;
                remainder -= add;
                solution[j] = quotient + add;
                if (counter <= remainder && quotient + counter < n) {
                    counter++;
                }
            }
        }

        if (isImpossible(solution)) {
            return null;
        }

        return constructMatrix(solution);
    }

    private String constructMatrix(int[] solution) {
        int size = solution.length;
        int[][] matrix = initializeMatrix(solution);
        int[] completedRows = new int[size];
        int startRow = 0;
        int currentRow = 0;

        while (!areAllRowsCompleted(completedRows) && startRow < size) {
            if (currentRow == size) {
                currentRow = 0;
            }
            int[] temp = new int[size];
            temp[solution[currentRow] - 1] = 1;
            boolean rowFound = fillRow(matrix, temp, currentRow, 0, solution);

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
            for (int val : row) {
                result.append(val).append(" ");
            }
            result.append("\n");
        }

        return result.toString();
    }

    private boolean areAllRowsCompleted(int[] completedRows) {
        for (int row : completedRows) {
            if (row == 0) {
                return false;
            }
        }
        return true;
    }

    private int[][] initializeMatrix(int[] solution) {
        int length = solution.length;
        int[][] matrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            matrix[i][i] = solution[i];
        }
        return matrix;
    }

    private boolean fillRow(int[][] matrix, int[] temp, int rowNum, int colNum, int[] solution) {
        if (colNum == solution.length) {
            return true;
        }

        if (rowNum == colNum) {
            temp[solution[colNum] - 1] = 1;
            return fillRow(matrix, temp, rowNum, colNum + 1, solution);
        } else {
            int[] columnValues = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                if (matrix[i][colNum] != 0) {
                    columnValues[matrix[i][colNum] - 1] = 1;
                }
            }

            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == 0 && columnValues[i] == 0) {
                    matrix[rowNum][colNum] = i + 1;
                    temp[i] = 1;
                    boolean rowFilled = fillRow(matrix, temp, rowNum, colNum + 1, solution);
                    if (rowFilled) {
                        return true;
                    } else {
                        matrix[rowNum][colNum] = 0;
                        temp[i] = 0;
                    }
                }
            }

            return false;
        }
    }

    private boolean isImpossible(int[] solution) {
        int[] frequency = new int[solution.length];
        for (int value : solution) {
            if (value == 0) {
                return true;
            }
            frequency[value - 1]++;
        }

        int maxFrequency = 0;
        int maxFrequencyIndex = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > maxFrequency) {
                maxFrequency = frequency[i];
                maxFrequencyIndex = i;
            }
        }

        int nonMaxFrequencyCount = 0;
        for (int value : solution) {
            if (value != maxFrequencyIndex + 1) {
                nonMaxFrequencyCount++;
            }
        }

        return nonMaxFrequencyCount == 1;
    }
}