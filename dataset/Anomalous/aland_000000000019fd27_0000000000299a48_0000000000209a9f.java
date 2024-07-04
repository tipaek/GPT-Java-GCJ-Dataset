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
                int currentDigit = input.charAt(i) - '0';

                if (currentDigit == balance) {
                    result.append(input.charAt(i));
                } else if (currentDigit > balance) {
                    int difference = currentDigit - balance;
                    result.append(repeatChar('(', difference)).append(input.charAt(i));
                    balance += difference;
                } else {
                    int difference = balance - currentDigit;
                    result.append(repeatChar(')', difference)).append(input.charAt(i));
                    balance -= difference;
                }
            }

            if (balance > 0) {
                result.append(repeatChar(')', balance));
            }

            System.out.println(result.toString());
        }
    }

    private static String repeatChar(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}