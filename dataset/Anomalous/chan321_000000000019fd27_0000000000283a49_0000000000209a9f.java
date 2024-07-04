import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= testCases; i++) {
            String inputString = reader.readLine().trim();
            processTestCase(inputString, i);
        }
    }

    private static void processTestCase(String input, int caseNumber) {
        for (int i = 0; i < 9; i++) {
            LinkedList<Integer> positions = new LinkedList<>();
            int length = input.length();

            for (int j = 0; j < length; j++) {
                char currentChar = input.charAt(j);
                if (currentChar == '(' || currentChar == ')') {
                    continue;
                }

                if (positions.size() % 2 == 0) {
                    positions.push(j);
                }

                if (currentChar <= (char) (i + '0')) {
                    if (positions.peek() == j) {
                        positions.pop();
                    } else {
                        positions.push(j);
                    }
                }
            }

            if (positions.size() % 2 != 0) {
                positions.push(length);
            }

            if (!positions.isEmpty()) {
                input = insertBrackets(input, positions);
            }
        }

        System.out.println();
        System.out.format("Case #%d: %s", caseNumber, input);
    }

    private static String insertBrackets(String input, LinkedList<Integer> positions) {
        StringBuilder modifiedString = new StringBuilder(input);
        for (int i = 0; i < positions.size(); i++) {
            if (i % 2 == 0) {
                modifiedString.insert(positions.get(i), ")");
            } else {
                modifiedString.insert(positions.get(i), "(");
            }
        }
        return modifiedString.toString();
    }
}