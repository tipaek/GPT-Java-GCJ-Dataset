import java.util.Scanner;

public class CodeJam2020_NestingDepth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            int requiredDepth;

            for (char c : input.toCharArray()) {
                requiredDepth = Character.getNumericValue(c);
                
                while (currentDepth < requiredDepth) {
                    result.append('(');
                    currentDepth++;
                }
                
                while (currentDepth > requiredDepth) {
                    result.append(')');
                    currentDepth--;
                }
                
                result.append(c);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
        
        scanner.close();
    }
}