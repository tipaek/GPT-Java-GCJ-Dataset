import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().execute();
    }

    public void execute() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            processTestCase(t, br);
        }
        br.close();
    }

    public void processTestCase(int testNumber, BufferedReader br) throws Exception {
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        ArrayList<ArrayList<Double>> pascalTriangle = generatePascalTriangle(500);

        if (N <= 501) {
            handleSmallN(N, sb);
        } else {
            handleLargeN(N, sb, pascalTriangle);
        }

        printResult(testNumber, sb.toString());
    }

    private ArrayList<ArrayList<Double>> generatePascalTriangle(int size) {
        ArrayList<ArrayList<Double>> pascalTriangle = new ArrayList<>();
        pascalTriangle.add(new ArrayList<>());
        ArrayList<Double> firstRow = new ArrayList<>();
        firstRow.add(1.0);
        firstRow.add(1.0);
        pascalTriangle.add(firstRow);

        for (int r = 2; r <= size; r++) {
            ArrayList<Double> row = new ArrayList<>();
            row.add(1.0);
            for (int k = 1; k < r; k++) {
                row.add(pascalTriangle.get(r - 1).get(k - 1) + pascalTriangle.get(r - 1).get(k));
            }
            row.add(1.0);
            pascalTriangle.add(row);
        }

        return pascalTriangle;
    }

    private void handleSmallN(int N, StringBuilder sb) {
        int val = N;
        if (val >= 1) {
            sb.append("1 1");
            val--;
        }
        if (val >= 1) {
            sb.append("\n2 1");
            val--;
        }
        int row = 2;
        if (val > 400) {
            append(sb, 2, 2);
            append(sb, 3, 3);
            append(sb, 3, 2);
            append(sb, 3, 1);
            val -= 5;
            row = 4;
        }
        while (val > 0) {
            append(sb, row, 1);
            val--;
            row++;
        }
    }

    private void handleLargeN(int N, StringBuilder sb, ArrayList<ArrayList<Double>> pascalTriangle) {
        int val = N - 1;
        sb.append("1 1");
        int row = 2;

        while (val >= 500 - row) {
            if (row % 2 == 0) {
                for (int c = 0; c < row; c++) {
                    val -= pascalTriangle.get(row).get(c);
                    append(sb, row, c + 1);
                }
            } else {
                for (int c = row - 1; c >= 0; c--) {
                    val -= pascalTriangle.get(row).get(c);
                    append(sb, row, c + 1);
                }
            }
            row++;
        }

        if (row % 2 == 0) {
            while (val > 0) {
                append(sb, row, 1);
                val--;
                row++;
            }
        } else {
            while (val > 0) {
                append(sb, row, row);
                val--;
                row++;
            }
        }
    }

    private void append(StringBuilder sb, int row, int col) {
        sb.append("\n").append(row).append(" ").append(col);
    }

    private void printResult(int testCase, String result) {
        System.out.format("Case #%d: \n", testCase);
        System.out.println(result);
    }
}