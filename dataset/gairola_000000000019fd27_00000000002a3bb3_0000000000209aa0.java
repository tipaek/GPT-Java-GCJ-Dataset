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
        if ((trace < order) || (trace > order * order)) return "IMPOSSIBLE";

        int[][] latinSquare = baseLatinSquare(order);
        if (solveForTrace(latinSquare, trace, 0)) {
            String result = "POSSIBLE\n";

            for (int i = 0; i < latinSquare.length; i++) {
                for (int j = 0; j < latinSquare[i].length; j++)
                    result += latinSquare[i][j] + " ";
                result = result.trim();
                result += "\n";
            }

            return result.trim();
        }
        return "IMPOSSIBLE";
    }

    static boolean solveForTrace(int[][] base, int trace, int row) {
        if (calculateTrace(base) == trace) return true;

        if (row < base.length) {
            for (int col = 0; col < base.length; col++) {
                for (int i = 0; i < base.length; i++) {
                    int tmp = base[i][row];
                    base[i][row] = base[i][col];
                    base[i][col] = tmp;
                }

                if (solveForTrace(base, trace, row + 1)) return true;
            }
        }

        return false;
    }

    private static int[][] baseLatinSquare(int o) {
        int[][] matrix = new int[o][o];
        for (int i = 0; i < o; i++) {
            for (int j = 0; j < o; j++) {
                matrix[i][j] = i + j + 1;
                if (matrix[i][j] > o) matrix[i][j] -= o;
            }
        }
        return matrix;
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) trace += matrix[i][i];

        return trace;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
//        System.out.println(process(new String[]{"5 9"}));
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