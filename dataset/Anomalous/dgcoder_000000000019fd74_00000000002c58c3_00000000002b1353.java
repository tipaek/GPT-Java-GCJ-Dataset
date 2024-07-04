import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().read();
    }

    public void read() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());

            for (int t = 1; t <= T; t++) {
                testCase(t, br);
            }
        }
    }

    public void testCase(int testNumber, BufferedReader br) throws Exception {
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        ArrayList<ArrayList<Double>> data = generateData();

        if (N <= 501) {
            handleSmallN(sb, N, data);
        } else {
            handleLargeN(sb, N, data);
        }

        print(testNumber, sb.toString());
    }

    private ArrayList<ArrayList<Double>> generateData() {
        ArrayList<ArrayList<Double>> data = new ArrayList<>();
        data.add(new ArrayList<>());
        data.add(new ArrayList<>());
        data.get(1).add(1.0);

        for (int r = 2; r < 501; r++) {
            ArrayList<Double> temp = new ArrayList<>();
            temp.add(1.0);
            for (int k = 1; k < r; k++) {
                temp.add(data.get(r - 1).get(k - 1) + data.get(r - 1).get(k));
            }
            temp.add(1.0);
            data.add(temp);
        }

        return data;
    }

    private void handleSmallN(StringBuilder sb, int N, ArrayList<ArrayList<Double>> data) {
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
        int col = row;

        if (val > 400) {
            append(sb, 2, 2);
            val--;

            for (int c = 3; c >= 1; c--) {
                append(sb, 3, c);
                val -= data.get(3).get(c - 1);
            }

            for (int c = 1; c < 4; c++) {
                append(sb, 4, c);
                val -= data.get(4).get(c - 1);
            }

            row = 4;
            col = row;
        }

        while (val > 0) {
            append(sb, row, col);
            val--;
            row++;
            col++;
        }
    }

    private void handleLargeN(StringBuilder sb, int N, ArrayList<ArrayList<Double>> data) {
        int val = N - 1;
        sb.append("1 1");

        int row = 2;

        while (val >= 499 - row) {
            if (row % 2 == 0) {
                for (int c = 0; c < row; c++) {
                    val -= data.get(row).get(c);
                    append(sb, row, c + 1);
                }
            } else {
                for (int c = row - 1; c >= 0; c--) {
                    val -= data.get(row).get(c);
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

    private void print(int testCase, String result) {
        System.out.format("Case #%d: \n", testCase);
        System.out.println(result);
    }
}