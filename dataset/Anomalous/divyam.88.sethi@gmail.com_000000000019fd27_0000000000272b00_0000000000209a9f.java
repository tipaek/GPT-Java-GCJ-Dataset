import java.util.Scanner;

public class Main {
    public static String balance(String str) {
        StringBuilder balancedStr = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';

            while (currentDepth < digit) {
                balancedStr.append('(');
                currentDepth++;
            }

            while (currentDepth > digit) {
                balancedStr.append(')');
                currentDepth--;
            }

            balancedStr.append(str.charAt(i));
        }

        while (currentDepth > 0) {
            balancedStr.append(')');
            currentDepth--;
        }

        return balancedStr.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            String str = scanner.nextLine();
            String balancedStr = balance(str);
            System.out.println("Case #" + caseNumber + ": " + balancedStr);
        }

        scanner.close();
    }
}