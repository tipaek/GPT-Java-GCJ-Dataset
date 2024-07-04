import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Parent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : inputString.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (digit > currentDepth) {
                    result.append('(');
                    currentDepth++;
                }
                while (digit < currentDepth) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(digit);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
        scanner.close();
    }
}