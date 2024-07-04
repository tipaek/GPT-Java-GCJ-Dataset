import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private static String compute(String s) {
        StringBuilder result = new StringBuilder();
        int currentLevel = 0;

        for (char c : s.toCharArray()) {
            int digit = Character.getNumericValue(c);
            while (currentLevel < digit) {
                result.append('(');
                currentLevel++;
            }
            while (currentLevel > digit) {
                result.append(')');
                currentLevel--;
            }
            result.append(digit);
        }

        while (currentLevel > 0) {
            result.append(')');
            currentLevel--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            System.out.println("Case #" + i + ": " + compute(input));
        }

        scanner.close();
    }
}