import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static String process(String[] scenario) {
        int cLock = 0, jLock = 0;
        int[][] triggers = new int[scenario.length * 2][2];
        int[][] tasks = new int[scenario.length][2];

        for (int i = 0; i < scenario.length; i++) {
            String[] tokens = scenario[i].split(" ");
            tasks[i][0] = Integer.parseInt(tokens[0]);
            tasks[i][1] = Integer.parseInt(tokens[1]);

            triggers[2 * i][0] = tasks[i][0];
            triggers[2 * i][1] = i + 1;

            triggers[2 * i + 1][0] = tasks[i][1];
            triggers[2 * i + 1][1] = -1 * (i + 1);
        }

        Arrays.sort(triggers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < triggers.length; i++) {
            if (triggers[i][1] > 0) {
                if (cLock == 0) {
                    cLock = triggers[i][1];
                    result.append("C");
                } else if (jLock == 0) {
                    jLock = triggers[i][1];
                    result.append("J");
                } else {
                    return "IMPOSSIBLE";
                }
            } else {
                if (cLock == -triggers[i][1]) {
                    cLock = 0;
                } else if (jLock == -triggers[i][1]) {
                    jLock = 0;
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            if (scanner.hasNext()) {
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
    }
}