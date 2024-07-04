import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static String process(String[] scenario) {
        int order = scenario.length;
        int[][] matrix = new int[order][order];
        int trace = 0, dupRows = 0, dupColumns = 0;

        for (int i = 0; i < order; i++) {
            String[] row = tokenize(scenario[i]);
            for (int j = 0; j < order; j++) {
                matrix[i][j] = Integer.parseInt(row[j].trim());
                if (i == j) trace += matrix[i][j];
            }
        }

        for (int i = 0; i < order; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < order; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }
            if (rowSet.size() != order) dupRows++;
            if (colSet.size() != order) dupColumns++;
        }

        return trace + " " + dupRows + " " + dupColumns;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            if (scanner.hasNext()) {
                int numberOfScenarios = Integer.parseInt(scanner.nextLine().trim());

                for (int currentScenario = 1; currentScenario <= numberOfScenarios; currentScenario++) {
                    int size = Integer.parseInt(scanner.nextLine().trim());
                    String[] scenario = new String[size];
                    for (int i = 0; i < size; i++) {
                        scenario[i] = scanner.nextLine().trim();
                    }
                    System.out.println("Case #" + currentScenario + ": " + process(scenario));
                }
            }
        }
    }

    private static String[] tokenize(String string) {
        StringTokenizer tokenizer = new StringTokenizer(string.trim(), " \n\r\t,.;");
        String[] tokens = new String[tokenizer.countTokens()];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            tokens[i++] = tokenizer.nextToken();
        }
        return tokens;
    }
}