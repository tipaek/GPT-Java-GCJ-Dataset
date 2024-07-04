import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class Solution {
    public static String process(final String[] scenario) {
        final String[] tokens = tokenize(scenario[0]);

        final int order = Integer.parseInt(tokens[0].trim());
        final int trace = Integer.parseInt(tokens[1].trim());

        int[][] latinSquare = generateLatinSquare(order, trace);
        if (latinSquare != null && calculateTrace(latinSquare) == trace) {
            StringBuilder result = new StringBuilder("POSSIBLE\n");

            for (int[] row : latinSquare) {
                for (int num : row) {
                    result.append(num).append(" ");
                }
                result.append("\n");
            }

            return result.toString().trim();
        }
        return "IMPOSSIBLE";
    }

    private static int[][] generateLatinSquare(int order, int trace) {
        int[][] baseSquare = createBaseLatinSquare(order);
        return solveForTrace(baseSquare, trace, 0, 0);
    }

    private static int[][] solveForTrace(int[][] base, int trace, int depth, int sum) {
        if (sum > trace) return new int[0][0];

        if (depth == base.length) {
            return (sum == trace) ? base : new int[0][0];
        }

        for (int j = 0; j < base.length; j++) {
            int[][] found = solveForTrace(base, trace, depth + 1, sum + base[depth][j]);
            if (found.length == base.length) {
                swapColumns(base, depth, j);
                return base;
            }
        }
        return new int[0][0];
    }

    private static void swapColumns(int[][] matrix, int col1, int col2) {
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
    }

    private static int[][] createBaseLatinSquare(int order) {
        int[][] matrix = new int[order][order];
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                matrix[i][j] = (i + j) % order + 1;
            }
        }
        return matrix;
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            if (scanner.hasNext()) {
                int numberOfScenarios = Integer.parseInt(scanner.nextLine().trim());

                for (int currentScenario = 1; currentScenario <= numberOfScenarios; currentScenario++) {
                    String[] scenario = {scanner.nextLine().trim()};
                    System.out.println("Case #" + currentScenario + ": " + process(scenario));
                }
            }
        }
    }

    private static String[] tokenize(final String string) {
        StringTokenizer tokenizer = new StringTokenizer(string.trim(), " \n\r\t,.;");
        String[] tokens = new String[tokenizer.countTokens()];

        for (int i = 0; tokenizer.hasMoreTokens(); i++) {
            tokens[i] = tokenizer.nextToken();
        }
        return tokens;
    }
}