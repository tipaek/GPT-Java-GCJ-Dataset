import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        InputStream input = System.in;
        InputReader reader = new InputReader(input);
        int testCases = reader.nextInt();

        for (int i = 0; i < testCases; i++) {
            String inputString = reader.next();
            List<Integer> digits = new ArrayList<>();

            for (char ch : inputString.toCharArray()) {
                digits.add(ch - '0');
            }

            StringBuilder output = new StringBuilder();
            int previousDigit = 0;

            for (int currentDigit : digits) {
                if (currentDigit > previousDigit) {
                    output.append("(".repeat(currentDigit - previousDigit));
                } else if (currentDigit < previousDigit) {
                    output.append(")".repeat(previousDigit - currentDigit));
                }
                output.append(currentDigit);
                previousDigit = currentDigit;
            }

            output.append(")".repeat(previousDigit));
            System.out.println(output);
        }
    }

    static class InputReader {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        public InputReader(InputStream input) {
            bufferedReader = new BufferedReader(new InputStreamReader(input));
        }

        String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}