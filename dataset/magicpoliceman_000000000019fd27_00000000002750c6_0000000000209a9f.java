import java.io.*;

public class Solution {

    static public void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().replaceAll("\\s+$", ""));

        for (int i = 0; i < testCases; i++) {
            String line = bufferedReader.readLine();
            String solution = solve(line);
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    static private String solve(String line) {
        StringBuilder result = new StringBuilder();
        String[] digits = line.split("");
        for (int i = 0; i < digits.length; i++) {
            String digit = digits[i];
            if (digit.equals("0")) {
                result.append(digit);
            } else {
                int digitInt = Integer.parseInt(digit);
                append(result, "(", digitInt);
                result.append(digit);
                int prevDigit = digitInt;
                int bracketsLeft = digitInt;
                for (int j = i + 1; j < digits.length; j++) {
                    int nextDigit = Integer.parseInt(digits[j]);
                    if (nextDigit == prevDigit) {
                        result.append(nextDigit);
                        i++;
                    } else if (nextDigit < prevDigit) {
                        int diff = prevDigit - nextDigit;
                        append(result, ")", diff);
                        bracketsLeft -= diff;
                        result.append(nextDigit);
                        prevDigit = nextDigit;
                        i++;
                    } else {
                        break;
                    }
                }
                append(result, ")", bracketsLeft);
            }
        }
        return result.toString();
    }

    private static void append(StringBuilder result, String s, int times) {
        for (int j = 0; j < times; j++) {
            result.append(s);
        }
    }
}