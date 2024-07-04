import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static String process(final String[] scenario) {
        int cLock = 0, jLock = 0;
        int[][] triggers = new int[scenario.length * 2][2];
        int[][] tasks = new int[scenario.length][2];

        for (int i = 0; i < scenario.length; i++) {
            String[] tokens = tokenize(scenario[i]);
            tasks[i][0] = Integer.parseInt(tokens[0]);
            tasks[i][1] = Integer.parseInt(tokens[1]);

            triggers[2 * i][0] = tasks[i][0];
            triggers[2 * i][1] = i + 1;

            triggers[2 * i + 1][0] = tasks[i][1];
            triggers[2 * i + 1][1] = -(i + 1);
        }

        Arrays.sort(triggers, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));

        char[] schedule = new char[scenario.length];
        for (int[] trigger : triggers) {
            if (trigger[1] > 0) {
                if (cLock == 0) {
                    cLock = trigger[1];
                    schedule[trigger[1] - 1] = 'C';
                } else if (jLock == 0) {
                    jLock = trigger[1];
                    schedule[trigger[1] - 1] = 'J';
                } else {
                    return "IMPOSSIBLE";
                }
            } else {
                if (cLock == -trigger[1]) {
                    cLock = 0;
                } else if (jLock == -trigger[1]) {
                    jLock = 0;
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }

        return new String(schedule);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfScenarios = Integer.parseInt(scanner.nextLine().trim());

            for (int currentScenario = 1; currentScenario <= numberOfScenarios; currentScenario++) {
                int numTasks = Integer.parseInt(scanner.nextLine().trim());
                String[] scenario = new String[numTasks];
                for (int i = 0; i < numTasks; i++) {
                    scenario[i] = scanner.nextLine().trim();
                }
                System.out.println("Case #" + currentScenario + ": " + process(scenario));
            }
        }
    }

    private static String[] tokenize(final String string) {
        StringTokenizer tokenizer = new StringTokenizer(string.trim(), " \n\r\t,.;");
        String[] tokens = new String[tokenizer.countTokens()];
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokenizer.nextToken();
        }
        return tokens;
    }
}