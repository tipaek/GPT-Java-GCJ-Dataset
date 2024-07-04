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
        for (int i = 0; i < testCases; i++) {
            String result = solveTestCase();
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

    private String solveTestCase() throws IOException {
        int n = Integer.parseInt(nextToken());
        int k = Integer.parseInt(nextToken());
        int[] solution = new int[n];
        Arrays.fill(solution, 0);

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
                    if (quotient + counter < n) {
                        counter++;
                    }
                } else {
                    add = remainder;
                    remainder = 0;
                }
                solution[j] = quotient + add;
            }

            if (remainder > 0) {
                int idx = 0;
                while (remainder > 0) {
                    solution[idx++]++;
                    remainder--;
                }
            }
        }

        if (isImpossible(solution)) {
            return null;
        }

        return createMatrix(solution);
    }

    private String createMatrix(int[] solution) {
        int length = solution.length;
        int[][] matrix = initializeMatrix(solution);

        int[] completed = new int[length];
        int startRow = 0, curRow = 0;

        while (!allRowsCompleted(completed) && startRow < length) {
            if (curRow == length) {
                curRow = 0;
            }

            int[] temp = new int[length];
            temp[solution[curRow] - 1] = 1;
            boolean rowFilled = fillRow(matrix, temp, curRow, 0, solution);

            if (rowFilled) {
                completed[curRow] = 1;
                curRow++;
            } else {
                startRow++;
                curRow = startRow;
                matrix = initializeMatrix(solution);
                completed = new int[length];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int cell : row) {
                sb.append(cell).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private boolean allRowsCompleted(int[] completed) {
        for (int status : completed) {
            if (status == 0) {
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
                    if (fillRow(matrix, temp, rowNum, colNum + 1, solution)) {
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
        int maxFrequencyValue = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > maxFrequency) {
                maxFrequency = frequency[i];
                maxFrequencyValue = i + 1;
            }
        }

        int differentCount = 0;
        for (int value : solution) {
            if (value != maxFrequencyValue) {
                differentCount++;
            }
        }

        return differentCount == 1;
    }
}