import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class Solution {
    public static String process(String[] scenario) {
        String[] tokens = tokenize(scenario[0]);
        int order = Integer.parseInt(tokens[0].trim());
        int trace = Integer.parseInt(tokens[1].trim());

        if (trace < order || trace > order * order) return "IMPOSSIBLE";

        int[][] latinSquare = generateBaseLatinSquare(order);
        if (findLatinSquareWithTrace(latinSquare, trace, 0)) {
            StringBuilder result = new StringBuilder("POSSIBLE\n");
            for (int[] row : latinSquare) {
                for (int value : row) {
                    result.append(value).append(" ");
                }
                result.setLength(result.length() - 1); // Remove trailing space
                result.append("\n");
            }
            return result.toString().trim();
        }
        return "IMPOSSIBLE";
    }

    private static boolean findLatinSquareWithTrace(int[][] square, int trace, int row) {
        if (calculateTrace(square) == trace) return true;
        if (row < square.length) {
            for (int col = 0; col < square.length; col++) {
                for (int i = 0; i < square.length; i++) {
                    int temp = square[i][row];
                    square[i][row] = square[i][col];
                    square[i][col] = temp;
                }
                if (findLatinSquareWithTrace(square, trace, row + 1)) return true;
            }
        }
        return false;
    }

    private static int[][] generateBaseLatinSquare(int order) {
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

    private static String[] tokenize(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input.trim(), " \n\r\t,.;");
        String[] tokens = new String[tokenizer.countTokens()];
        for (int i = 0; i < tokens.length && tokenizer.hasMoreTokens(); i++) {
            tokens[i] = tokenizer.nextToken();
        }
        return tokens;
    }
}