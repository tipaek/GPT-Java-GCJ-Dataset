import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; ++i) {
            String input = scanner.next();
            int length = input.length();
            StringBuilder output = new StringBuilder();

            for (int j = 0; j < length; ++j) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                
                if (j == 0) {
                    for (int k = 0; k < currentDigit; ++k) {
                        output.append('(');
                    }
                } else {
                    int previousDigit = Character.getNumericValue(input.charAt(j - 1));
                    if (currentDigit > previousDigit) {
                        for (int k = 0; k < currentDigit - previousDigit; ++k) {
                            output.append('(');
                        }
                    } else if (currentDigit < previousDigit) {
                        for (int k = 0; k < previousDigit - currentDigit; ++k) {
                            output.append(')');
                        }
                    }
                }

                output.append(currentDigit);

                if (j == length - 1) {
                    for (int k = 0; k < currentDigit; ++k) {
                        output.append(')');
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }
    }
}