import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int t = Integer.parseInt(tokenizer.nextToken());

        for (int i = 1; i <= t; i++) {
            String input = reader.readLine();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;

            for (int j = 0; j < input.length(); j++) {
                int digit = input.charAt(j) - '0';
                if (digit > currentDepth) {
                    for (int k = 0; k < digit - currentDepth; k++) {
                        output.append('(');
                    }
                    currentDepth = digit;
                } else if (digit < currentDepth) {
                    for (int k = 0; k < currentDepth - digit; k++) {
                        output.append(')');
                    }
                    currentDepth = digit;
                }
                output.append(input.charAt(j));
            }

            for (int k = 0; k < currentDepth; k++) {
                output.append(')');
            }

            System.out.println("Case #" + i + ": " + output.toString());
        }
    }
}