import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            String s = scanner.nextLine();
            StringBuilder output = new StringBuilder();

            int previousDigit = 0;
            for (char c : s.toCharArray()) {
                int currentDigit = Character.getNumericValue(c);
                int difference = currentDigit - previousDigit;

                if (difference > 0) {
                    for (int j = 0; j < difference; j++) {
                        output.append('(');
                    }
                } else if (difference < 0) {
                    for (int j = 0; j < -difference; j++) {
                        output.append(')');
                    }
                }

                output.append(c);
                previousDigit = currentDigit;
            }

            for (int j = 0; j < previousDigit; j++) {
                output.append(')');
            }

            System.out.println("Case #" + caseNum + ": " + output);
        }
    }
}