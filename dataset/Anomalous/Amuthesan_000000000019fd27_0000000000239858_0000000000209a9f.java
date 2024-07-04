import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; i++) {
                String input = scanner.next();
                StringBuilder encapsulated = new StringBuilder();
                for (char ch : input.toCharArray()) {
                    encapsulated.append(encapsulate(ch));
                }
                String result = encapsulated.toString().replaceAll("\\)\\(", "");
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }

    private static String encapsulate(char ch) {
        int number = Character.getNumericValue(ch);
        if (number == 0) {
            return String.valueOf(ch);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number; i++) {
            result.append('(');
        }
        result.append(ch);
        for (int i = 0; i < number; i++) {
            result.append(')');
        }
        return result.toString();
    }
}