import java.util.Scanner;

public class NestingDepth {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                String n = scanner.next();
                StringBuilder result = new StringBuilder();
                int previousDepth = 0;

                for (char c : n.toCharArray()) {
                    int currentDepth = Character.getNumericValue(c);
                    if (currentDepth > previousDepth) {
                        result.append("(".repeat(currentDepth - previousDepth));
                    } else if (currentDepth < previousDepth) {
                        result.append(")".repeat(previousDepth - currentDepth));
                    }
                    result.append(currentDepth);
                    previousDepth = currentDepth;
                }
                result.append(")".repeat(previousDepth));
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }
}