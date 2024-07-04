import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class Solution {
    public static String process(final String[] scenario) {
        int cLock = 0, jLock = 0;
        final int[][] triggers = new int[scenario.length * 2][2];

        final int[][] tasks = new int[scenario.length][2];
        for (int i = 0; i < scenario.length; i++) {
            final String[] tokens = tokenize(scenario[i]);
            tasks[i][0] = Integer.parseInt(tokens[0]);
            tasks[i][1] = Integer.parseInt(tokens[1]);

            triggers[2 * i][0] = tasks[i][0];
            triggers[2 * i][1] = i + 1;

            triggers[2 * i + 1][0] = tasks[i][1];
            triggers[2 * i + 1][1] = -1 * (i + 1);
        }

        Arrays.sort(triggers, new Comparator<int[]>() {
            @Override
            public int compare(final int[] o1, final int[] o2) {
                return Integer.compare(o1[0], o2[0]) * 10000 + Integer.compare(o1[1], o2[1]);
            }
        });

        char[] schedule = new char[scenario.length];
        for (int i = 0; i < 2 * scenario.length; i++) {
            if (triggers[i][1] > 0) {
                if (cLock == 0) {
                    cLock += triggers[i][1];
                    schedule[triggers[i][1] - 1] = 'C';
                } else if (jLock == 0) {
                    jLock += triggers[i][1];
                    schedule[triggers[i][1] - 1] = 'J';
                } else return "IMPOSSIBLE";
            } else {
                if (cLock == -1 * triggers[i][1])
                    cLock += triggers[i][1];
                else if (jLock == -1 * triggers[i][1])
                    jLock += triggers[i][1];
                else return "IMPOSSIBLE";
            }
//            System.out.println("--->" + triggers[i][0] + ":" + triggers[i][1] + "(" + cLock + "," + jLock + ")");
        }

        return String.valueOf(schedule);
    }

    public static void main(String[] args) {
//        System.out.println(process(new String[]{"99 150", "1 100", "100 301", "2 5", "150 250"}));
//        System.exit(0);

        try (final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            if (scanner.hasNext()) {
                int currentScenario = 0;
                final int numberOfScenarios = Integer.parseInt(scanner.nextLine().trim());

                while (++currentScenario <= numberOfScenarios) {
                    String[] scenario = new String[Integer.parseInt(scanner.nextLine().trim())];
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