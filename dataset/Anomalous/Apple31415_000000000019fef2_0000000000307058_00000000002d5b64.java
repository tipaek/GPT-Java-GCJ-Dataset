import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine().trim());

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int ranks = Integer.parseInt(tokenizer.nextToken());
            int suits = Integer.parseInt(tokenizer.nextToken());
            int result = calculateResult(ranks, suits);
            System.out.printf("Case #%d: %d%n", caseIndex + 1, result);
            System.out.print(generateOperations(ranks, suits));
        }

        reader.close();
    }

    private static int calculateResult(int ranks, int suits) {
        if (ranks == 3 && suits == 3) {
            return 3;
        } else if ((ranks == 3 && suits == 4) || (ranks == 4 && suits == 3)) {
            return 5;
        } else {
            return (ranks - 1) * (suits - 1);
        }
    }

    private static String generateOperations(int ranks, int suits) {
        StringBuilder operations = new StringBuilder();

        if (ranks == 3 && suits == 3) {
            operations.append("5 2\n3 2\n3 5\n");
        } else if (ranks == 3 && suits == 4) {
            operations.append("8 2\n6 2\n3 3\n7 4\n4 2\n");
        } else if (ranks == 4 && suits == 3) {
            operations.append("6 3\n2 4\n7 4\n4 3\n3 1\n");
        } else {
            for (int i = ranks * (suits - 1); i > suits - 1; i--) {
                operations.append(String.format("%d %d%n", i, (i - 1) / (suits - 1)));
            }
        }

        return operations.toString();
    }
}