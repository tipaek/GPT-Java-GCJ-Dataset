import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NestingDepth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int j = 0; j < input.length(); j++) {
                int digit = Character.getNumericValue(input.charAt(j));
                
                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                
                result.append(digit);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}