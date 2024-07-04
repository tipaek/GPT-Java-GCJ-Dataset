import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            String input = reader.readLine();
            int length = input.length();
            int previousDigit = 0;

            for (int j = 0; j < length; j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                int difference = previousDigit - currentDigit;

                if (difference < 0) {
                    for (int k = 0; k < -difference; k++) {
                        System.out.print("(");
                    }
                } else if (difference > 0) {
                    for (int k = 0; k < difference; k++) {
                        System.out.print(")");
                    }
                }

                System.out.print(currentDigit);
                previousDigit = currentDigit;
            }

            for (int j = 0; j < previousDigit; j++) {
                System.out.print(")");
            }

            System.out.println();
        }
    }
}