import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static Integer caseCounter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer numberOfCases = Integer.valueOf(st.nextToken());

        for (int i = 0; i < numberOfCases; i++) {
            String line = br.readLine();
            Integer[] array = new Integer[line.length()];

            for (int j = 0; j < line.length(); j++) {
                array[j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }

            solve(array);
        }
    }

    private static void solve(Integer[] array) {
        caseCounter++;
        Integer unclosedParenthesisCounter = 0;
        Integer lastDigit = null;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            Integer currentDigit = array[i];

            if (i == 0) {
                lastDigit = currentDigit;
            }

            if (currentDigit == 0) {
                while (unclosedParenthesisCounter > 0) {
                    sb.append(")");
                    unclosedParenthesisCounter--;
                }
                sb.append(currentDigit);
                lastDigit = currentDigit;
                continue;
            } else {
                if (currentDigit < lastDigit) {
                    int numberOfParenthesis = lastDigit - currentDigit;
                    while (numberOfParenthesis > 0) {
                        sb.append(")");
                        numberOfParenthesis--;
                    }
                }

                int numberOfParenthesis = currentDigit - unclosedParenthesisCounter;

                while (numberOfParenthesis > 0) {
                    sb.append("(");
                    numberOfParenthesis--;
                    unclosedParenthesisCounter++;
                }
                sb.append(currentDigit);
            }

            lastDigit = currentDigit;
        }

        while (unclosedParenthesisCounter > 0) {
            sb.append(")");
            unclosedParenthesisCounter--;
        }
        System.out.println(String.format("Case #%s: %s", caseCounter, sb.toString()));
    }
}
