import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(inputReader.readLine());

            for (int t = 1; t <= testCases; t++) {
                StringBuilder output = new StringBuilder();
                String line = inputReader.readLine();

                int currentDepth = 0;
                for (char ch : line.toCharArray()) {
                    int nextDigit = Character.getNumericValue(ch);
                    while (currentDepth > nextDigit) {
                        output.append(")");
                        currentDepth--;
                    }
                    while (currentDepth < nextDigit) {
                        output.append("(");
                        currentDepth++;
                    }
                    output.append(nextDigit);
                }
                while (currentDepth > 0) {
                    output.append(")");
                    currentDepth--;
                }

                System.out.printf("Case #%d: %s%n", t, output.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}