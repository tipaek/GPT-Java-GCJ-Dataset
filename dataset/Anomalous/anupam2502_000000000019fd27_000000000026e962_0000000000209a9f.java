import java.util.Scanner;

public class NestingDepth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();

            int previousDepth = 0;
            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                int depthDifference = currentDigit - previousDepth;

                if (depthDifference > 0) {
                    for (int j = 0; j < depthDifference; j++) {
                        result.append('(');
                    }
                } else if (depthDifference < 0) {
                    for (int j = 0; j < -depthDifference; j++) {
                        result.append(')');
                    }
                }

                result.append(currentDigit);
                previousDepth = currentDigit;
            }

            for (int i = 0; i < previousDepth; i++) {
                result.append(')');
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }

        scanner.close();
    }
}