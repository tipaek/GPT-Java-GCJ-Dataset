import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            String input = reader.readLine();
            int length = input.length();
            int balance = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int value = input.charAt(i) - '0';

                if (value == balance) {
                    result.append(input.charAt(i));
                } else if (value > balance) {
                    result.append(repeatChar('(', value - balance))
                          .append(input.charAt(i));
                    balance = value;
                } else {
                    result.append(repeatChar(')', balance - value))
                          .append(input.charAt(i));
                    balance = value;
                }
            }

            if (balance > 0) {
                result.append(repeatChar(')', balance));
            }

            System.out.println(result.toString());
        }
    }

    private static String repeatChar(char ch, int times) {
        return String.join("", Collections.nCopies(times, String.valueOf(ch)));
    }
}