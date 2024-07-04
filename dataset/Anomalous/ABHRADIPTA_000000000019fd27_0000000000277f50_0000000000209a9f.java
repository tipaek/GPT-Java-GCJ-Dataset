import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        String[] results = new String[testCases];

        for (int t = 0; t < testCases; t++) {
            String input = reader.readLine() + " ";
            StringBuilder result = new StringBuilder();
            int count = 1;

            for (int i = 0; i < input.length() - 1; i++) {
                char currentChar = input.charAt(i);
                char nextChar = input.charAt(i + 1);

                if (currentChar == nextChar) {
                    count++;
                } else {
                    int num = Character.getNumericValue(currentChar);
                    if (num > 0) {
                        result.append("(".repeat(num));
                    }
                    result.append(String.valueOf(currentChar).repeat(count));
                    if (num > 0) {
                        result.append(")".repeat(num));
                    }
                    count = 1;
                }
            }

            results[t] = result.toString();
        }

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + results[t]);
        }
    }
}