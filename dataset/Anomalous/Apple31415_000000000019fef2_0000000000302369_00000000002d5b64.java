import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine().trim());

        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int ranks = Integer.parseInt(tokenizer.nextToken());
            int suits = Integer.parseInt(tokenizer.nextToken());

            int result = (ranks - 1) * (suits - 1);
            System.out.printf("Case #%d: %d%n", caseIndex, result);
            System.out.print(generateOperations(ranks, suits));
        }

        reader.close();
    }

    private static String generateOperations(int ranks, int suits) {
        StringBuilder operations = new StringBuilder();

        for (int i = ranks * (suits - 1); i > suits - 1; i--) {
            int operationValue = (i - 1) / (suits - 1);
            operations.append(String.format("%d %d%n", i, operationValue));
        }

        return operations.toString();
    }
}