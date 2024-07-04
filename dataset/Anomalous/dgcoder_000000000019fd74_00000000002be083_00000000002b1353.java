import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().execute();
    }

    public void execute() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            processTestCase(i, reader);
        }
        reader.close();
    }

    public void processTestCase(int testCaseNumber, BufferedReader reader) throws Exception {
        int N = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        ArrayList<ArrayList<Double>> pascalTriangle = generatePascalTriangle(500);

        if (N <= 501) {
            handleSmallN(N, output);
        } else {
            handleLargeN(N, output, pascalTriangle);
        }

        displayResult(testCaseNumber, output.toString());
    }

    private ArrayList<ArrayList<Double>> generatePascalTriangle(int size) {
        ArrayList<ArrayList<Double>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        ArrayList<Double> firstRow = new ArrayList<>();
        firstRow.add(1.0);
        firstRow.add(1.0);
        triangle.add(firstRow);

        for (int row = 2; row <= size; row++) {
            ArrayList<Double> currentRow = new ArrayList<>();
            currentRow.add(1.0);
            for (int col = 1; col < row; col++) {
                currentRow.add(triangle.get(row - 1).get(col - 1) + triangle.get(row - 1).get(col));
            }
            currentRow.add(1.0);
            triangle.add(currentRow);
        }

        return triangle;
    }

    private void handleSmallN(int N, StringBuilder output) {
        int value = N;
        if (value >= 1) {
            output.append("1 1");
            value--;
        }
        if (value >= 1) {
            output.append("\n2 1");
            value--;
        }
        int row = 2;
        int col = row;
        while (value > 0) {
            output.append("\n").append(row).append(" ").append(col);
            value--;
            row++;
            col++;
        }
    }

    private void handleLargeN(int N, StringBuilder output, ArrayList<ArrayList<Double>> pascalTriangle) {
        int value = N - 1;
        output.append("1 1");
        int row = 2;

        while (value >= 500 - row) {
            if (row % 2 == 0) {
                for (int col = 0; col < row; col++) {
                    value -= pascalTriangle.get(row).get(col);
                    appendCoordinates(output, row, col + 1);
                }
            } else {
                for (int col = row - 1; col >= 0; col--) {
                    value -= pascalTriangle.get(row).get(col);
                    appendCoordinates(output, row, col + 1);
                }
            }
            row++;
        }

        if (row % 2 == 0) {
            while (value > 0) {
                appendCoordinates(output, row, 1);
                value--;
                row++;
            }
        } else {
            while (value > 0) {
                appendCoordinates(output, row, row);
                value--;
                row++;
            }
        }
    }

    private void appendCoordinates(StringBuilder output, int row, int col) {
        output.append("\n").append(row).append(" ").append(col);
    }

    private void displayResult(int testCaseNumber, String result) {
        System.out.format("Case #%d:\n", testCaseNumber);
        System.out.println(result);
    }
}