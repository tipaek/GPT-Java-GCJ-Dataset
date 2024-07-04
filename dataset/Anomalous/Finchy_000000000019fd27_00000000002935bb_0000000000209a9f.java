import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NestingDepth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int num = Character.getNumericValue(ch);
                while (currentDepth < num) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > num) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(ch);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }
}