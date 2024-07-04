import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 0; caseNum < numCases; caseNum++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                while (openBrackets < digit) {
                    result.append('(');
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    result.append(')');
                    openBrackets--;
                }
                result.append(ch);
            }

            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            System.out.printf("Case #%d: %s\n", caseNum + 1, result.toString());
        }

        reader.close();
    }
}