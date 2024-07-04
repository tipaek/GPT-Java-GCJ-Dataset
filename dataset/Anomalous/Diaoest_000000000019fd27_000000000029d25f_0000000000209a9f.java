import java.util.Scanner;
import java.util.Stack;

public class Google {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int numCases = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            for (int i = 0; i < numCases; i++) {
                String input = scanner.nextLine();
                char[] characters = input.toCharArray();
                StringBuilder result = new StringBuilder();
                Stack<Character> stack = new Stack<>();

                for (char ch : characters) {
                    int currentDigit = ch - '0';
                    while (currentDigit < stack.size()) {
                        stack.pop();
                        result.append(')');
                    }
                    while (currentDigit > stack.size()) {
                        stack.push('(');
                        result.append('(');
                    }
                    result.append(ch);
                }
                while (!stack.isEmpty()) {
                    stack.pop();
                    result.append(')');
                }
                System.out.println("Case #" + (i + 1) + ": " + result.toString() + "\n");
            }
        }
        scanner.close();
    }
}