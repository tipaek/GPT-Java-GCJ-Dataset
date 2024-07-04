import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < testCases; i++) {
            String line = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int balance = 0;

            for (int j = 0; j < line.length(); j++) {
                int digit = Character.getNumericValue(line.charAt(j));
                int difference = digit - balance;

                if (difference > 0) {
                    output.append("(".repeat(difference));
                } else if (difference < 0) {
                    output.append(")".repeat(-difference));
                }

                output.append(digit);
                balance = digit;
            }

            output.append(")".repeat(balance));
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }
}