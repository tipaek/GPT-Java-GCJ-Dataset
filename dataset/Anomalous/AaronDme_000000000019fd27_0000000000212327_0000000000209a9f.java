import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(input.readLine());

        for (int i = 1; i <= testCases; i++) {
            String s = input.readLine();
            int openBrackets = 0;
            StringBuilder result = new StringBuilder("Case #" + i + ": ");

            for (int j = 0; j < s.length(); j++) {
                int digit = s.charAt(j) - '0';

                while (digit > openBrackets) {
                    result.append('(');
                    openBrackets++;
                }

                while (digit < openBrackets) {
                    result.append(')');
                    openBrackets--;
                }

                result.append(digit);
            }

            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            System.out.println(result);
        }
    }
}