import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Solution {

    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/testIn"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                total.append(line).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes(StandardCharsets.UTF_8));
        System.setIn(testInput);
    }

    public static void main(String[] args) throws IOException {
        // Uncomment to run the test method
        // test();
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(in.nextLine());
            for (int x = 1; x <= t; ++x) {
                int rows = Integer.parseInt(in.nextLine());
                System.out.println("Case #" + x + ": " + getResult(rows, in));
            }
        }
    }

    private static String getResult(int rows, Scanner in) {
        int[][] numberInCol = new int[rows][rows + 1];
        int[][] numberInRow = new int[rows][rows + 1];
        int trace = 0;

        for (int i = 0; i < rows; i++) {
            String[] raw = in.nextLine().split(" ");
            for (int j = 0; j < rows; j++) {
                int n = Integer.parseInt(raw[j]);
                if (i == j) {
                    trace += n;
                }
                numberInCol[j][n]++;
                numberInRow[i][n]++;
            }
        }

        int dupInCol = 0;
        int dupInRow = 0;

        for (int i = 0; i < rows; i++) {
            boolean hasDupCol = false;
            boolean hasDupRow = false;
            for (int j = 1; j <= rows; j++) {
                if (numberInCol[i][j] > 1) {
                    hasDupCol = true;
                }
                if (numberInRow[i][j] > 1) {
                    hasDupRow = true;
                }
                if (hasDupCol && hasDupRow) {
                    break;
                }
            }
            if (hasDupCol) {
                dupInCol++;
            }
            if (hasDupRow) {
                dupInRow++;
            }
        }

        return trace + " " + dupInRow + " " + dupInCol;
    }
}