import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static BufferedReader in;
    static List<int[]> lines = new ArrayList<>();

    public static void main(String[] args) {
        readLines();

        int testcaseId = 1;

        for (int[] line : lines) {
            computeLine(line, testcaseId);
            testcaseId++;
        }
    }

    private static void computeLine(int[] line, int testcaseId) {
        StringBuilder stringBuilder = new StringBuilder();

        int previousNumber = 0;

        for (int i = 0; i < line.length; i++) {
            int currentNumber = line[i];

            char charToAdd = currentNumber - previousNumber > 0 ? '(' : ')';

            for (int j = 0; j < Math.abs(currentNumber - previousNumber); j++) {
                stringBuilder.append(charToAdd);
            }

            stringBuilder.append(currentNumber);

            previousNumber = currentNumber;
        }

        for (int j = 0; j < previousNumber; j++) {
            stringBuilder.append(')');
        }

        System.out.println("case #" + testcaseId + ": " + stringBuilder.toString());
    }

    public static void readLines() {
        in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();

            int numberOfTestCases = Integer.parseInt(line);

            for (int i = 0; i < numberOfTestCases; i++) {
                line = in.readLine();

                int[] numberLine = new int[line.length()];

                char[] charArray = line.toCharArray();

                for (int j = 0; j < line.length(); j++) {
                    char numberChar = charArray[j];
                    numberLine[j] = Integer.parseInt(String.valueOf(numberChar));
                }

                lines.add(numberLine);
            }
        } catch (IOException e) {
            System.out.println("something went wrong during reading input");
        }
    }
}
