import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int cases = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < cases; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            String input = tokenizer.nextToken();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int j = 0; j < input.length(); j++) {
                int digit = Character.getNumericValue(input.charAt(j));
                while (openBrackets < digit) {
                    result.append("(");
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    result.append(")");
                    openBrackets--;
                }
                result.append(digit);
            }

            while (openBrackets > 0) {
                result.append(")");
                openBrackets--;
            }

            writer.println("Case #" + (i + 1) + ": " + result.toString());
        }

        writer.close();
    }
}