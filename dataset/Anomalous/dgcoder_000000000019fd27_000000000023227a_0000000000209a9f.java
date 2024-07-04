import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String input = reader.readLine();
            String result = generateNestedString(input);
            System.out.printf("Case #%d: %s%n", t, result);
        }
        reader.close();
    }

    public static String generateNestedString(String input) {
        StringBuilder nestedString = new StringBuilder();
        int openBrackets = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));

            if (i == 0) {
                for (int j = 0; j < currentDigit; j++) {
                    nestedString.append('(');
                }
                openBrackets = currentDigit;
            } else {
                int previousDigit = Character.getNumericValue(input.charAt(i - 1));
                if (currentDigit > previousDigit) {
                    for (int j = 0; j < currentDigit - openBrackets; j++) {
                        nestedString.append('(');
                    }
                } else if (currentDigit < previousDigit) {
                    for (int j = 0; j < openBrackets - currentDigit; j++) {
                        nestedString.append(')');
                    }
                }
                openBrackets = currentDigit;
            }
            nestedString.append(input.charAt(i));
        }

        for (int j = 0; j < openBrackets; j++) {
            nestedString.append(')');
        }

        return nestedString.toString();
    }
}