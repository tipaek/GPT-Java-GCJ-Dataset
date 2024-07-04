import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; ++t) {
                System.out.print("Case #" + t + ": ");
                String input = scanner.next();
                int previousDigit = 0;
                for (char c : input.toCharArray()) {
                    int currentDigit = Character.getNumericValue(c);
                    if (previousDigit < currentDigit) {
                        for (int i = 0; i < currentDigit - previousDigit; i++) {
                            System.out.print("(");
                        }
                    } else if (previousDigit > currentDigit) {
                        for (int i = 0; i < previousDigit - currentDigit; i++) {
                            System.out.print(")");
                        }
                    }
                    System.out.print(currentDigit);
                    previousDigit = currentDigit;
                }
                for (int i = 0; i < previousDigit; i++) {
                    System.out.print(")");
                }
                System.out.println();
            }
        }
    }
}