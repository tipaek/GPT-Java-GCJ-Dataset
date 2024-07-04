import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String inputString = bufferedReader.readLine().trim();
            processTestCase(inputString, testCase);
        }
    }

    public static void processTestCase(String inputString, int testCaseNumber) {
        int length = inputString.length();

        for (int i = 0; i < 9; i++) {
            LinkedList<Integer> bracketPositions = new LinkedList<>();
            for (int j = 0; j < length; j++) {
                char currentChar = inputString.charAt(j);
                if (currentChar == '(' || currentChar == ')') {
                    continue;
                }

                if (bracketPositions.size() % 2 == 0) {
                    bracketPositions.push(j);
                }

                if (currentChar <= i + '0') {
                    if (bracketPositions.peek() == j) {
                        bracketPositions.pop();
                    } else {
                        bracketPositions.push(j);
                    }
                }
            }

            if (bracketPositions.size() % 2 != 0) {
                bracketPositions.push(length);
            }

            if (!bracketPositions.isEmpty()) {
                inputString = insertBrackets(inputString, bracketPositions);
            }
        }

        System.out.println();
        System.out.format("Case #%d: %s", testCaseNumber, inputString);
    }

    public static String insertBrackets(String inputString, LinkedList<Integer> bracketPositions) {
        StringBuilder stringBuilder = new StringBuilder(inputString);
        for (int i = 0; i < bracketPositions.size(); i++) {
            if (i % 2 == 0) {
                stringBuilder.insert(bracketPositions.get(i), ")");
            } else {
                stringBuilder.insert(bracketPositions.get(i), "(");
            }
        }
        return stringBuilder.toString();
    }
}