import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int T = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int i = 1; i <= T; i++) {
                String data = scanner.nextLine();
                System.out.println("Case #" + i + ": " + processString(data));
            }
        }

        scanner.close();
    }

    private static String processString(String data) {
        int currentValue = 0;
        int openParentheses = 0;
        StringBuilder sb = new StringBuilder();

        for (char ch : data.toCharArray()) {
            int newCharValue = Character.getNumericValue(ch);

            while (openParentheses < newCharValue) {
                sb.append('(');
                openParentheses++;
            }

            while (openParentheses > newCharValue) {
                sb.append(')');
                openParentheses--;
            }

            sb.append(newCharValue);
            currentValue = newCharValue;
        }

        while (openParentheses > 0) {
            sb.append(')');
            openParentheses--;
        }

        return sb.toString();
    }
}