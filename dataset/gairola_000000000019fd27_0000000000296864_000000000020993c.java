import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class Solution {
    public static String process(final String[] scenario) {
        final int order = scenario.length;

        final int[][] matrix = new int[order][order];

        int trace = 0, dupRows = 0, dupColumns = 0;
        for (int i = 0; i < order; i++) {
            final String[] row = tokenize(scenario[i]);
            for (int j = 0; j < order; j++) {
                matrix[i][j] = Integer.parseInt(row[j].trim());

                if (i == j) trace += matrix[i][j];
            }
        }

        for (int i = 0; i < order; i++) {
            final Set<Integer> ixj = new HashSet<>(), jxi = new HashSet<>();
            for (int j = 0; j < order; j++) {
                ixj.add(matrix[i][j]);
                jxi.add(matrix[j][i]);
            }

            if (ixj.size() != order) dupRows++;
            if (jxi.size() != order) dupColumns++;
        }

        return trace + " " + dupRows + " " + dupColumns;
    }

    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            if (scanner.hasNext()) {
                int currentScenario = 0;
                final int numberOfScenarios = Integer.parseInt(scanner.nextLine().trim());

                while (++currentScenario <= numberOfScenarios) {
                    String[] scenario = new String[Integer.parseInt(scanner.nextLine())];
                    for (int i = 0; i < scenario.length; i++)
                        scenario[i] = scanner.nextLine().trim();

                    System.out.println("Case #" + currentScenario + ": " + process(scenario));
                }
            }
        }
    }

    private static String[] tokenize(String string) {
        final StringTokenizer tokenizer = new StringTokenizer(string.trim(), " \n\r\t,.;");

        final String[] tokens = new String[tokenizer.countTokens()];
        for (int i = 0; i < tokens.length && tokenizer.hasMoreTokens(); i++)
            tokens[i] = tokenizer.nextToken();
        return tokens;
    }
}