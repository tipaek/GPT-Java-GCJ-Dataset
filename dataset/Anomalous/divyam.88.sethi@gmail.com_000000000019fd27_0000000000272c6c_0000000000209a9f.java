import java.util.Scanner;

class Main {
    public static String balance(String str) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';

            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }

            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }

            result.append(str.charAt(i));
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            String str = scanner.next();
            String balancedStr = balance(str);
            System.out.println("Case #" + caseNum + ": " + balancedStr);
        }

        scanner.close();
    }
}