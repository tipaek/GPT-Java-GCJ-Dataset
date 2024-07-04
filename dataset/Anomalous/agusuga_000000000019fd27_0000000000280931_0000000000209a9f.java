import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            int currentLevel = 0;

            System.out.print("Case #" + (i + 1) + ": ");

            for (int j = 0; j < input.length(); j++) {
                int digit = Character.getNumericValue(input.charAt(j));
                if (digit > currentLevel) {
                    for (int k = 0; k < digit - currentLevel; k++) {
                        System.out.print("(");
                    }
                } else if (digit < currentLevel) {
                    for (int k = 0; k < currentLevel - digit; k++) {
                        System.out.print(")");
                    }
                }
                System.out.print(digit);
                currentLevel = digit;
            }

            for (int k = 0; k < currentLevel; k++) {
                System.out.print(")");
            }

            if (i < testCases - 1) {
                System.out.println();
            }
        }
    }
}