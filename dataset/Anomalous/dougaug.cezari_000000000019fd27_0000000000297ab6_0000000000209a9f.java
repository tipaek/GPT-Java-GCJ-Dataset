import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            boolean isOpen = false;

            for (char ch : input.toCharArray()) {
                if (ch == '0') {
                    if (isOpen) {
                        result.append(')');
                        isOpen = false;
                    }
                } else {
                    if (!isOpen) {
                        result.append('(');
                        isOpen = true;
                    }
                }
                result.append(ch);
            }

            if (isOpen) {
                result.append(')');
            }

            System.out.println(String.format("Case #%d: %s", t, result));
        }
    }
}