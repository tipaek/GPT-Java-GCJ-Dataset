import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = reader.readLine();
            StringBuilder output = new StringBuilder();
            int openBrackets = 0;

            for (char digitChar : input.toCharArray()) {
                int digit = digitChar - '0';
                while (openBrackets < digit) {
                    output.append("(");
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    output.append(")");
                    openBrackets--;
                }
                output.append(digit);
            }

            while (openBrackets > 0) {
                output.append(")");
                openBrackets--;
            }

            System.out.printf("Case #%d: %s%n", caseNum, output.toString());
        }

        reader.close();
    }
}