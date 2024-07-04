import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class Solution {
    public static String process(final String[] scenario) {
        String base = scenario[0];
        for (int i = 0; i < 10; i++) {
            String open = "", close = "";
            for (int j = 0; j < i; j++) {
                open += "(";
                close += ")";
            }
            base = base.replaceAll("" + i, open + i + close);
        }

        while (base.indexOf(")(") > 0)
            base = base.replaceAll("\\)\\(", "");

        return base;
    }

    public static void main(String[] args) {
//        System.out.println(process(new String[]{"221"}));
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