import java.util.Scanner;

public class NestedNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();

            int currentLevel = 0;

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';

                while (currentLevel < digit) {
                    result.append('(');
                    currentLevel++;
                }
                while (currentLevel > digit) {
                    result.append(')');
                    currentLevel--;
                }

                result.append(ch);
            }

            while (currentLevel > 0) {
                result.append(')');
                currentLevel--;
            }

            System.out.printf("Case #%d: %s\n", testCase, result.toString());
        }

        scanner.close();
    }
}