import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            processInput(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class InputData {
        String inputString;

        public InputData(BufferedReader reader) throws IOException {
            this.inputString = reader.readLine();
        }
    }

    private static class OutputData {
        String outputString;

        public OutputData(String outputString) {
            this.outputString = outputString;
        }

        @Override
        public String toString() {
            return outputString;
        }
    }

    private static void processInput(BufferedReader reader) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(new InputData(reader)));
        }
    }

    private static OutputData solve(InputData inputData) {
        String inputString = inputData.inputString;
        StringBuilder result = new StringBuilder();
        int currentLevel = 0;

        for (char ch : inputString.toCharArray()) {
            int digit = ch - '0';

            while (currentLevel < digit) {
                currentLevel++;
                result.append("(");
            }

            while (currentLevel > digit) {
                currentLevel--;
                result.append(")");
            }

            result.append(ch);
        }

        while (currentLevel > 0) {
            currentLevel--;
            result.append(")");
        }

        return new OutputData(result.toString());
    }
}