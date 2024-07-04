import java.util.Scanner;

public class NestingDepth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();

            int previousDepth = 0;

            for (char digitChar : input.toCharArray()) {
                int currentDepth = Character.getNumericValue(digitChar);

                while (previousDepth < currentDepth) {
                    result.append('(');
                    previousDepth++;
                }

                while (previousDepth > currentDepth) {
                    result.append(')');
                    previousDepth--;
                }

                result.append(digitChar);
            }

            while (previousDepth > 0) {
                result.append(')');
                previousDepth--;
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }

        scanner.close();
    }
}