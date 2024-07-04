import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static int T;
    static String S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            S = br.readLine();
            processTestCase(testCase);
        }
        br.close();
    }

    private static void processTestCase(int testCase) {
        char[] characters = S.toCharArray();
        StringBuilder result = new StringBuilder();
        int openBrackets = 0;
        char previousChar = 's';

        for (int i = 0; i < characters.length; i++) {
            int currentDigit = Character.getNumericValue(characters[i]);

            if (previousChar == 's') {
                openBrackets = currentDigit;
                for (int j = 0; j < currentDigit; j++) {
                    result.append("(");
                }
            } else {
                int previousDigit = Character.getNumericValue(previousChar);

                if (previousChar != characters[i]) {
                    int difference = previousDigit - currentDigit;
                    if (difference > 0) {
                        for (int j = 0; j < difference; j++) {
                            result.append(")");
                            openBrackets--;
                        }
                    } else {
                        for (int j = 0; j < -difference; j++) {
                            result.append("(");
                            openBrackets++;
                        }
                    }
                }
            }
            previousChar = characters[i];
            result.append(characters[i]);

            if (i == characters.length - 1) {
                for (int j = 0; j < openBrackets; j++) {
                    result.append(")");
                }
            }
        }

        System.out.println("Case #" + testCase + ": " + result.toString());
    }
}