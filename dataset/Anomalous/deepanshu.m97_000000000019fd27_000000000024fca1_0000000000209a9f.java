import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());

            for (int i = 1; i <= t; i++) {
                String str = br.readLine();
                int[] balance = new int[str.length() + 1];

                for (int j = 0; j < str.length(); j++) {
                    int num = Character.getNumericValue(str.charAt(j));
                    balance[j] += num;
                    balance[j + 1] -= num;
                }

                StringBuilder result = new StringBuilder();
                for (int j = 0; j < str.length(); j++) {
                    result.append(generateBrackets(balance[j]));
                    result.append(str.charAt(j));
                }
                result.append(generateBrackets(balance[str.length()]));

                System.out.println("Case #" + i + ": " + result.toString());
            }
        }
    }

    private static String generateBrackets(int count) {
        StringBuilder brackets = new StringBuilder();
        char bracketChar = count > 0 ? '(' : ')';
        for (int i = 0; i < Math.abs(count); i++) {
            brackets.append(bracketChar);
        }
        return brackets.toString();
    }
}