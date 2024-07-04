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

        int[][] latinSquare = solveForTrace(latinSquare(order, 0, 1), trace, 0, 0);
        if (latinSquare.length == order && calculateTrace(latinSquare) == trace) {
            String result = "POSSIBLE\n";

            for (int i = 0; i < latinSquare.length; i++) {
                for (int j = 0; j < latinSquare[i].length; j++)
                    result += latinSquare[i][j] + " ";
                result += "\n";
            }

            return result.trim();
        }
        return "IMPOSSIBLE";
    }

    static int[][] solveForTrace(int[][] base, int trace, int depth, int sum) {
        if (sum > trace) return new int[][]{};

        if (depth == base.length) {
            if (sum == trace) return base;
            return new int[][]{};
        }

        for (int j = 0; j < base.length; j++) {
            int[][] found = solveForTrace(base, trace, depth + 1, sum + base[depth][j]);
            if (found.length == base.length) {
                for (int i = 0; i < base.length; i++) {
                    int tmp = base[i][depth];
                    base[i][depth] = base[i][j];
                    base[i][j] = tmp;
                }
                return base;
            }
        }
        return new int[][]{};
    }

    private static int[][] latinSquare(int o, int d, int val) {
        int[][] matrix = new int[o][o];
        matrix[d][d] = val;

        for (int i = 0; i < o; i++) {
            int e = d + i + 1;
            if (e < o) {
                matrix[d][e] = matrix[d][d + i] + 1;
                matrix[e][d] = matrix[d + i][d] + 1;
                if (matrix[d][e] > o) matrix[d][e] -= o;
                if (matrix[e][d] > o) matrix[e][d] -= o;
            }

            int f = d - i - 1;
            if (f >= 0) {
                matrix[d][f] = matrix[d][d - i] - 1;
                matrix[f][d] = matrix[d + i][d] - 1;
                if (matrix[d][f] <= 0) matrix[d][f] += o;
                if (matrix[f][d] <= 0) matrix[f][d] += o;
            }
        }

        for (int i = 0; i < o; i++) {
            int e = d + i + 1;
            if (e < o) {
                matrix[0][e] = matrix[0][d + i] + 1;
                matrix[e][0] = matrix[d + i][0] + 1;
                if (matrix[0][e] > o) matrix[0][e] -= o;
                if (matrix[e][0] > o) matrix[e][0] -= o;
            }

            int f = d - i - 1;
            if (f >= 0) {
                matrix[0][f] = matrix[0][d - i] - 1;
                matrix[f][0] = matrix[d + i][0] - 1;
                if (matrix[0][f] <= 0) matrix[0][f] += o;
                if (matrix[f][0] <= 0) matrix[f][0] += o;
            }
        }

        for (int i = 0; i < o; i++) {
            for (int j = 0; j < o; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = matrix[i][j - 1] + 1;
                    if (matrix[i][j] > o) matrix[i][j] -= o;
                }
            }
        }

        return matrix;
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++)
            trace += matrix[i][i];

        return trace;
    }

//    private static void printMatrix(int[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++)
//                System.out.print(matrix[i][j] + "\t");
//            System.out.println();
//        }
//        System.out.println("------------------------------------");
//    }

    public static void main(String[] args) {
//        System.out.println(process(new String[]{"5 10"}));
//        System.exit(0);

        try (final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            if (scanner.hasNext()) {
                int currentScenario = 0;
                final int numberOfScenarios = Integer.parseInt(scanner.nextLine().trim());

                while (++currentScenario <= numberOfScenarios) {
                    String[] scenario = new String[1];
                    for (int i = 0; i < scenario.length; i++)
                        scenario[i] = scanner.nextLine().trim();

                    System.out.println("Case #" + currentScenario + ": " + process(scenario));
                }
            }
        }
    }

    private static String[] tokenize(final String string) {
        final StringTokenizer tokenizer = new StringTokenizer(string.trim(), " \n\r\t,.;");

        final String[] tokens = new String[tokenizer.countTokens()];
        for (int i = 0; i < tokens.length && tokenizer.hasMoreTokens(); i++)
            tokens[i] = tokenizer.nextToken();
        return tokens;
    }
}