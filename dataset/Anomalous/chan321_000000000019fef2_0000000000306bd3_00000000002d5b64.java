import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringBuilder resultBuilder = new StringBuilder();
            String[] input = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int count = calculatePairs(n, m, resultBuilder);
            System.out.println("Case #" + caseNumber + ": " + count + resultBuilder.toString());
        }
    }

    public static int calculatePairs(int n, int m, StringBuilder resultBuilder) {
        if (n <= 1 || m <= 1) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < m - 1; i++) {
            int firstNum = n * (m - 1) - i;
            int secondNum = n - 1;
            resultBuilder.append("\n").append(firstNum).append(" ").append(secondNum);
            count++;
        }

        count += calculatePairs(n - 1, m, resultBuilder);
        return count;
    }
}