import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int test = 1; test <= testCases; test++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < input.length(); i++) {
                int requiredDepth = Character.getNumericValue(input.charAt(i));

                while (currentDepth < requiredDepth) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > requiredDepth) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(requiredDepth);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + test + ": " + result.toString());
        }
    }
}