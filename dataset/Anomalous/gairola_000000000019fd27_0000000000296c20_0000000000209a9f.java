import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static String process(String scenario) {
        String base = scenario;
        for (int i = 0; i < 10; i++) {
            StringBuilder open = new StringBuilder();
            StringBuilder close = new StringBuilder();
            for (int j = 0; j < i; j++) {
                open.append("(");
                close.append(")");
            }
            base = base.replaceAll("" + i, open.toString() + i + close.toString());
        }

        while (base.contains(")(")) {
            base = base.replace(")(", "");
        }

        return base;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            if (scanner.hasNext()) {
                int numberOfScenarios = Integer.parseInt(scanner.nextLine().trim());

                for (int currentScenario = 1; currentScenario <= numberOfScenarios; currentScenario++) {
                    String scenario = scanner.nextLine().trim();
                    System.out.println("Case #" + currentScenario + ": " + process(scenario));
                }
            }
        }
    }
}