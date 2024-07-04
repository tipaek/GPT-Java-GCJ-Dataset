import java.util.Scanner;

public class NestingDepth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentLevel = 0;

            result.append("Case #").append(i + 1).append(": ");

            for (char digit : input.toCharArray()) {
                int level = Character.getNumericValue(digit);

                while (currentLevel < level) {
                    result.append('(');
                    currentLevel++;
                }

                while (currentLevel > level) {
                    result.append(')');
                    currentLevel--;
                }

                result.append(digit);
            }

            while (currentLevel > 0) {
                result.append(')');
                currentLevel--;
            }

            System.out.println(result);
        }

        scanner.close();
    }
}