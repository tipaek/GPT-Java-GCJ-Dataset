import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        PrintWriter writer = new PrintWriter(System.out);
        StringBuilder result = new StringBuilder();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            result.append("Case #").append(caseNumber).append(":\n");
            int n = Integer.parseInt(reader.readLine());
            int currentSum = 1;
            int row = 1;

            result.append("1 1\n");

            while (currentSum + row + 1 <= n) {
                row++;
                currentSum += row;
                result.append(row).append(" ").append(row).append("\n");
            }

            n -= currentSum;

            if (n > 0) {
                addRemainingElements(result, row, n);
            }
        }

        writer.print(result);
        writer.flush();
        reader.close();
    }

    private static void addRemainingElements(StringBuilder result, int row, int remaining) {
        for (int i = 1; i <= remaining; i++) {
            result.append(row + 1).append(" ").append(i).append("\n");
        }
    }
}