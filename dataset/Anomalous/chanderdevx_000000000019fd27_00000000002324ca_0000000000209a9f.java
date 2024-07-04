import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.nextLine();
            StringBuilder formattedString = new StringBuilder();

            boolean isOpen = false;
            for (char ch : input.toCharArray()) {
                if (ch == '1') {
                    if (!isOpen) {
                        formattedString.append('(');
                        isOpen = true;
                    }
                } else {
                    if (isOpen) {
                        formattedString.append(')');
                        isOpen = false;
                    }
                }
                formattedString.append(ch);
            }

            if (isOpen) {
                formattedString.append(')');
            }

            System.out.println("Case #" + testCase + ": " + formattedString.toString());
        }
    }
}